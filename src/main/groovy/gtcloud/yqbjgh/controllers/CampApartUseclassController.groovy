package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampApartUseclassDTO
import gtcloud.yqbjgh.services.CampApartUseclassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CampApartUseclassController {

    @Autowired
    private CampApartUseclassService service

    @GetMapping(value = "/camp-apart-useclass/{apartId}")
    List<CampApartUseclassDTO> getCampApartUseclass(@PathVariable String apartId) {
        return service.getCampApartUseClass(apartId)
    }
}
