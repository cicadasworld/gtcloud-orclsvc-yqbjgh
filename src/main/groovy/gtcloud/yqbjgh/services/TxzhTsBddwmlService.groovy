package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.model.BddwmlNode

interface TxzhTsBddwmlService {

    TxzhTsBddwml getById(String id)

    List<BddwmlNode> getManagedTree()

    List<BddwmlNode> getUsingTree(String unitKind)

    Map<String,BddwmlNode> getUsingTreeMap()

    List<String> getRootIds()

    boolean isRootUnit(String bdnm)

    BddwmlNode getRootUnit(String bdnm)

    List<String> getBdnmFamily(String bdnm)
}
