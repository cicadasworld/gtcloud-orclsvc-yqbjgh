package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampWarehouseDTO
import gtcloud.yqbjgh.services.CampWarehouseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CampWarehouseController {

    @Autowired
    CampWarehouseService service

    @GetMapping(value = "/camp-warehouse/{campId}")
    List<CampWarehouseDTO> getCampWarehouse(@PathVariable String campId) {
        return service.getCampWarehouse(campId)
    }
}
