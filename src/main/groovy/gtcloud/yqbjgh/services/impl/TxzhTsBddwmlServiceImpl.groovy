package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.bootstrap.BddwmlNodeBean
import gtcloud.yqbjgh.bootstrap.RootIdsBean
import gtcloud.yqbjgh.domain.CampApartUseclass
import gtcloud.yqbjgh.domain.ResidentUnit
import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.model.BddwmlNode
import gtcloud.yqbjgh.repositories.CampApartUseclassRepository
import gtcloud.yqbjgh.repositories.ResidentUnitRepository
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import gtcloud.yqbjgh.repositories.TxzyTsZbgcRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicAdminDivisionRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitGradeRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitKindRepository
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Stream

import static java.util.stream.Collectors.toList

@Service
class TxzhTsBddwmlServiceImpl implements TxzhTsBddwmlService {

	@Autowired
    private TxzhTsBddwmlRepository bddwmlRepo

	@Autowired
    private TxzyTsZbgcRepository zbgcRepo

	@Autowired
    private CampApartUseclassRepository campApartUseclassRepo

    @Autowired
    private ResidentUnitRepository residentUnitRepo

    @Autowired
    private RootIdsBean rootIdsBean

    @Autowired
    private BddwmlNodeBean bddwmlNodeBean

    @Autowired
    private ResidentDicUnitGradeRepository residentDicUnitGradeRepo

    @Autowired
    private ResidentDicAdminDivisionRepository residentDicAdminDivisionRepo

    @Autowired
    private ResidentDicUnitKindRepository residentDicUnitKindRepo

    @Override
    TxzhTsBddwml getById(String id) {
        return bddwmlRepo.findById(id).orElse(null)
    }

    @Override
    List<String> getRootIds() {
        List<TxzhTsBddwml> entities = bddwmlRepo.findByParentnmIsNull()
        return entities.stream().map{bddwml -> bddwml.nm}.collect(toList())
    }

    @Override
    Map<String, BddwmlNode> getUsingTreeMap() {
        Map<String, BddwmlNode> rootToNodes = new HashMap<>()
        List<String> rootIds = getRootIds()
        for (String rootId : rootIds) {
            final BddwmlNode node = getNodeById(rootId)
            rootToNodes.put(rootId, node)
        }
        return rootToNodes
    }

    @Override
    List<BddwmlNode> getManagedTree() {
        List<String> rootIds = rootIdsBean.rootIds
        return rootIds.stream().map{id -> getManagedTreeById(id)}.collect(toList())
    }

    BddwmlNode getManagedTreeById(String id) {
        final BddwmlNode node = bddwmlNodeBean.rootToNodes.get(id)
        this.getManagedTree(node) // recursive
        return node
    }

    private BddwmlNode getNodeById(String id) {
        TxzhTsBddwml entity = this.getById(id)
        return this.getNodeByEntity(entity)
    }

    private BddwmlNode getNodeByEntity(TxzhTsBddwml entity) {
        BddwmlNode node = new BddwmlNode()
        String nm = entity.nm
        node.nm = nm
        node.mc = entity.mc
        node.xh = entity.xh
        node.bdjc = entity.bdjc
        node.parentnm = entity.parentnm
        final List<BddwmlNode> children = this.getChildNodesById(nm)
        node.children = children
        node.isLeaf = children.isEmpty()
        final boolean managedCampExists = zbgcRepo.existsBySjcjdwnm(nm)
        node.hasManagedCamp = managedCampExists

        List<CampApartUseclass> campApartUseclasses = campApartUseclassRepo.findByBarrackUseUnit(nm)
        boolean usingCampExists = campApartUseclasses.stream().anyMatch{u -> u.barrackUseClass == '1001'}
        node.hasUsingCamp = usingCampExists

        List<ResidentUnit> residentUnits = residentUnitRepo.findByBdnm(nm)
        node.unitKind = residentUnits[0]?.unitKind
        node.adminDivision = residentUnits[0]?.adminDivision
        node.detailAddress = residentUnits[0]?.detailAddress
        node.unitGrade = residentUnits[0]?.unitGrade
        node.useingCampId = residentUnits[0]?.useingCampId
        node.soldierAuthorizedNum = residentUnits[0]?.soldierAuthorizedNum
        node.soldierRealityNum = residentUnits[0]?.soldierRealityNum
        node.employeeAuthorizedNum = residentUnits[0]?.employeeAuthorizedNum
        node.employeeRealityNum = residentUnits[0]?.employeeRealityNum
        node.officerorAuthorizedNum = residentUnits[0]?.officerorAuthorizedNum
        node.officerRealityNum = residentUnits[0]?.officerRealityNum
        node.civilAuthorizedNum = residentUnits[0]?.civilAuthorizedNum
        node.civilRealityNum = residentUnits[0]?.civilRealityNum
        node.mission = residentUnits[0]?.mission
        node.missionEx = residentUnits[0]?.missionEx
        node.remark = residentUnits[0]?.remark
        node.sjcjsj = residentUnits[0]?.sjcjsj
        node.sjcjry = residentUnits[0]?.sjcjry

        return node
    }

    private List<BddwmlNode> getChildNodesById(String id) {
        return bddwmlRepo.findByParentnm(id).
                stream().
                parallel().
                map{entity -> getNodeByEntity(entity)}.
                collect(toList())
    }

    void getManagedTree(BddwmlNode node) {
        node.show = node.hasManagedCamp || descendantsHasManagedCamp(node) // 判断管理单位条件
        final List<BddwmlNode> children = node.getChildren()
        children.sort{e1, e2 -> e1.xh <=> e2.xh} // 按xh排序
        for (BddwmlNode child : children) {
            this.getManagedTree(child)
        }
    }

    private static boolean descendantsHasManagedCamp(BddwmlNode node) {
        return stream(node).anyMatch{n -> n.hasManagedCamp}
    }

    @Override
    List<BddwmlNode> getUsingTree(String unitKind) {
        List<String> rootIds = rootIdsBean.rootIds
        return rootIds.stream().map{id -> getUsingTreeById(id, unitKind)}.collect(toList())
    }

    BddwmlNode getUsingTreeById(String id, String unitKind) {
        final BddwmlNode node = bddwmlNodeBean.rootToNodes.get(id)
        this.getUsingTree(node, unitKind) // recursive
        return node
    }

    void getUsingTree(BddwmlNode node, String unitKind) {
        if (node.hasUsingCamp || descendantsHasUsingCamp(node)) { // 判断使用单位条件
            node.show = !node.isLeaf || node.unitKind == unitKind // 显示指定unitKind值的叶子节点
        }
        final List<BddwmlNode> children = node.getChildren()
        children.sort{e1, e2 -> e1.xh <=> e2.xh} // 按xh排序
        for (BddwmlNode child : children) {
            this.getUsingTree(child, unitKind)
        }
    }

    private static boolean descendantsHasUsingCamp(BddwmlNode node) {
        return stream(node).anyMatch{n -> n.hasUsingCamp}
    }

    private static Stream<BddwmlNode> stream(BddwmlNode parentNode) {
        if (parentNode.isLeaf) {
            return Stream.of(parentNode)
        } else parentNode.children.stream().
                map{childNode -> stream(childNode)}.
                reduce(Stream.of(parentNode), {n1, n2 -> Stream.concat(n1, n2)})
    }

    @Override
    boolean isRootUnit(String bdnm) {
        List<String> rootIds = rootIdsBean.rootIds
        return rootIds.stream().anyMatch{rootId -> rootId == bdnm}
    }

    @Override
    BddwmlNode getRootUnit(String bdnm) {
        if (isRootUnit(bdnm)) {
            return bddwmlNodeBean.rootToNodes.get(bdnm)
        } else {
            return null
        }
    }

    @Override
    List<String> getBdnmFamily(String bdnm) {
        return bddwmlRepo.findBdnmFamily(bdnm)
    }
}
