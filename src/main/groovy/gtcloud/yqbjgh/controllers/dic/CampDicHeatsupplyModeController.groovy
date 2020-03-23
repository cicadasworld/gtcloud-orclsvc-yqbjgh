package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.CampDicHeatsupplyMode
import gtcloud.yqbjgh.services.dic.CampDicHeatsupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CampDicHeatsupplyModeController {

    @Autowired
    CampDicHeatsupplyModeService service

    @GetMapping(value = "/camp-dic-heatsupply-mode")
    List<CampDicHeatsupplyMode> getCampDicHeatsupplyModeList() {
        return service.listAll()
    }
}
