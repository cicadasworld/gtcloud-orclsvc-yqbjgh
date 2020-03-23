package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.CampDicWatersupplyMode
import gtcloud.yqbjgh.services.dic.CampDicWatersupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CampDicWatersupplyModeController {

    @Autowired
    CampDicWatersupplyModeService service

    @GetMapping(value = "/camp-dic-watersupply-mode")
    List<CampDicWatersupplyMode> getCampDicWatersupplyModeList() {
        return service.listAll()
    }
}
