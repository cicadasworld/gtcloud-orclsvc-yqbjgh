package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.CampDicSiteKind
import gtcloud.yqbjgh.services.dic.CampDicSiteKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CampDicSiteKindController {

    @Autowired
    CampDicSiteKindService service

    @GetMapping(value = "/camp-dic-site-kind")
    List<CampDicSiteKind> getCampDicSiteKindList() {
        return service.listAll()
    }
}
