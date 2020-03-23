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
    CampApartUseclassService service

    @GetMapping(value = "/camp-apart-useclass/{apartId}")
    List<CampApartUseclassDTO> getCampApartUseclass(@PathVariable String apartId) {
        return service.getCampApartUseClass(apartId)
    }

    @GetMapping(value = "/camp-apart-useclass/area-statistics/{campId}")
    Map<String, Double> getAreaStatistics(@PathVariable String campId) {
        return service.getAreaStatistics(campId)
    }
}
