package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.ResidentDicAdminDivision
import gtcloud.yqbjgh.services.dic.ResidentDicAdminDivisionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ResidentDicAdminDivisionController {

    @Autowired
    ResidentDicAdminDivisionService service

    @GetMapping(value = "/resident-dic-admin-division")
    List<ResidentDicAdminDivision> getResidentDicAdminDivisionList() {
        return service.listAll()
    }
}
