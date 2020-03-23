package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampTrainingFieldDTO
import gtcloud.yqbjgh.services.CampTrainingFieldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CampTrainingFieldController {

    @Autowired
    CampTrainingFieldService service

    @GetMapping(value = "/camp-training-field/{campId}")
    List<CampTrainingFieldDTO> getCampTrainingField(@PathVariable String campId) {
        return service.getCampTrainingField(campId)
    }
}
