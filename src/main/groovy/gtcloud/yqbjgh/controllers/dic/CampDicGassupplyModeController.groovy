package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.CampDicGassupplyMode
import gtcloud.yqbjgh.services.dic.CampDicGassupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CampDicGassupplyModeController {

    @Autowired
    CampDicGassupplyModeService service

    @GetMapping(value = "/camp-dic-gassupply-mode")
    List<CampDicGassupplyMode> getCampDicGassupplyModeList() {
        return service.listAll()
    }
}
