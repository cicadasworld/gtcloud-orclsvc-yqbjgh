package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.CampDicElecsupplyMode
import gtcloud.yqbjgh.services.dic.CampDicElecsupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CampDicElecsupplyModeController {

    @Autowired
    CampDicElecsupplyModeService service

    @GetMapping(value = "/camp-dic-elecsupply-mode")
    List<CampDicElecsupplyMode> getCampDicElecsupplyModeList() {
        return service.listAll()
    }
}
