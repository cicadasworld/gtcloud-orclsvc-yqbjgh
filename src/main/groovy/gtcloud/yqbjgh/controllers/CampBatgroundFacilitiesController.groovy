package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampBatgroundFacilitiesDTO
import gtcloud.yqbjgh.services.CampBatgroundFacilitiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CampBatgroundFacilitiesController {

    @Autowired
    CampBatgroundFacilitiesService service

    @GetMapping(value = "/camp-batground-facilities/{campId}")
    List<CampBatgroundFacilitiesDTO> getCampBatgroundFacilities(@PathVariable String campId) {
        return service.getCampBatgroundFacilities(campId)
    }
}
