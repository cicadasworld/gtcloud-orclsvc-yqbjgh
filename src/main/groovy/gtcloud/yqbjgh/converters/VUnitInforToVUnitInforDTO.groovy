package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.VUnitInfor
import gtcloud.yqbjgh.domain.dic.ResidentDicAdminDivision
import gtcloud.yqbjgh.domain.dic.ResidentDicUnitGrade
import gtcloud.yqbjgh.domain.dic.ResidentDicUnitKind
import gtcloud.yqbjgh.model.VUnitInforDTO
import gtcloud.yqbjgh.repositories.VUnitInforRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicAdminDivisionRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitGradeRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitKindRepository
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

import static java.util.stream.Collectors.toList

@Component
class VUnitInforToVUnitInforDTO implements Converter<VUnitInfor, VUnitInforDTO> {

    @Autowired
    TxzhTsBddwmlService bddwmlService

    @Autowired
    VUnitInforRepository vUnitInforRepository

    @Autowired
    ResidentDicAdminDivisionRepository residentDicAdminDivisionRepository

    @Autowired
    ResidentDicUnitKindRepository residentDicUnitKindRepository

    @Autowired
    ResidentDicUnitGradeRepository residentDicUnitGradeRepository

    @Override
    VUnitInforDTO convert(VUnitInfor source) {
        VUnitInforDTO target = new VUnitInforDTO()
        String bdnm = source.getBdnm()
        boolean isRootUnit = bddwmlService.isRootUnit(bdnm)
        if (isRootUnit) {
            target.xh = source.xh
            target.bdnm = source.bdnm
            target.bdjc = source.bdjc
            target.parentnm = source.parentnm

            List<VUnitInfor> vUnitInfors = vUnitInforRepository.findAll()
            setTotalNums(vUnitInfors, target)
            return target
        } else {
            target.xh = source.xh
            target.bdnm = source.bdnm
            target.mc = source.mc
            target.bdjc = source.bdjc
            target.parentnm = source.parentnm
            target.jlbm = source.jlbm

            //adminDivision -> adminDivision����
            String adminDivision = source.adminDivision
            Optional<ResidentDicAdminDivision> optAdminDivision =
                    residentDicAdminDivisionRepository.findById(adminDivision ?: "")
            optAdminDivision.ifPresent { dic -> target.adminDivision = dic.mc }

            target.detailAddress = source.detailAddress

            //unitKind -> unitKind����
            String unitKind = source.unitKind
            Optional<ResidentDicUnitKind> optUnitKind = residentDicUnitKindRepository.findById(unitKind ?: "")
            optUnitKind.ifPresent { dic -> target.unitKind = dic.mc }

            //unitGrade -> unitGrade����
            String unitGrade = source.unitGrade
            Optional<ResidentDicUnitGrade> optUnitGrade = residentDicUnitGradeRepository.findById(unitGrade ?: "")
            optUnitGrade.ifPresent { dic -> target.unitGrade = dic.mc }

            target.usingCampId = source.usingCampId
            target.soldierAuthorizedNum = source.soldierAuthorizedNum
            target.soldierRealityNum = source.soldierRealityNum
            target.employeeAuthorizedNum = source.employeeAuthorizedNum
            target.employeeRealityNum = source.employeeRealityNum
            target.officerorAuthorizedNum = source.officerorAuthorizedNum
            target.officerRealityNum = source.officerRealityNum
            target.civilAuthorizedNum = source.civilAuthorizedNum
            target.civilRealityNum = source.civilRealityNum
            target.mission = source.mission
            target.missionEx = source.missionEx
            target.remark = source.remark
            target.usingApartNum = source.usingApartNum

            List<String> bdnms = bddwmlService.getBdnmFamily(bdnm)
            List<VUnitInfor> vUnitInfors = bdnms.stream().
                    map { nm -> vUnitInforRepository.findByBdnm(nm)?.get() }.collect(toList())
            setTotalNums(vUnitInfors, target)
            return target
        }
    }

    private static void setTotalNums(List<VUnitInfor> vUnitInfors, VUnitInforDTO target) {
        int totalSoldierAuthorizedNum = vUnitInfors.stream().
                mapToInt { u -> u.soldierAuthorizedNum ?: 0 }.sum()
        int totalSoldierRealityNum = vUnitInfors.stream().
                mapToInt { u -> u.soldierRealityNum ?: 0 }.sum()

        int totalEmployeeAuthorizedNum = vUnitInfors.stream().
                mapToInt { u -> u.employeeAuthorizedNum ?: 0 }.sum()
        int totalEmployeeRealityNum = vUnitInfors.stream().
                mapToInt { u -> u.employeeRealityNum ?: 0 }.sum()

        int totalOfficerorAuthorizedNum = vUnitInfors.stream().
                mapToInt { u -> u.officerorAuthorizedNum ?: 0 }.sum()

        int totalOfficerRealityNum = vUnitInfors.stream().
                mapToInt { u -> u.officerRealityNum ?: 0 }.sum()

        int totalCivilAuthorizedNum = vUnitInfors.stream().
                mapToInt { u -> u.civilAuthorizedNum ?: 0 }.sum()
        int totalCivilRealityNum = vUnitInfors.stream().
                mapToInt { u -> u.civilRealityNum ?: 0 }.sum()

        target.totalSoldierAuthorizedNum = totalSoldierAuthorizedNum
        target.totalSoldierRealityNum = totalSoldierRealityNum
        target.totalEmployeeAuthorizedNum = totalEmployeeAuthorizedNum
        target.totalEmployeeRealityNum = totalEmployeeRealityNum
        target.totalOfficerorAuthorizedNum = totalOfficerorAuthorizedNum
        target.totalOfficerRealityNum = totalOfficerRealityNum
        target.totalCivilAuthorizedNum = totalCivilAuthorizedNum
        target.totalCivilRealityNum = totalCivilRealityNum
    }

}
