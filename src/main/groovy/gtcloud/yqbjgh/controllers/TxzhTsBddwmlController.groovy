package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.model.BddwmlNode
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TxzhTsBddwmlController {

    @Autowired
    TxzhTsBddwmlService bddwmlSvc

    @GetMapping(value = "/bddwml/{nm}")
    TxzhTsBddwml getTxzhTsBddwml(@PathVariable String nm) {
        TxzhTsBddwml result = bddwmlSvc.getById(nm)
        return result
    }

    @GetMapping(value = "/bddwml-zbgc/catalogue")
    List<BddwmlNode> getRootWithZbgc() {
        return bddwmlSvc.getManagedTree()
    }

    @GetMapping(value = "/bddwml-resident-unit/catalogue")
    List<BddwmlNode> getRootWithCampApartUseclass(
            @RequestParam(defaultValue = "") String unitKind) {
        return bddwmlSvc.getUsingTree(unitKind)
    }
}
