package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.VUnitInforDTO
import gtcloud.yqbjgh.services.VUnitInforService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UnitInforController {

    @Autowired
    private VUnitInforService service

    @GetMapping(value = "/v-unit-infor/bdnm/{bdnm}")
    VUnitInforDTO getVUnitInforBybdnm(@PathVariable String bdnm) {
        return service.getVUnitInforBybdnm(bdnm)
    }
}
