package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampWarehouseMaterialDTO
import gtcloud.yqbjgh.services.CampWarehouseMaterialService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CampWarehouseMaterialController {

	@Autowired
    private CampWarehouseMaterialService service

	@GetMapping(value = "/camp-warehouse-material/{warehouseId}")
	List<CampWarehouseMaterialDTO> getCampWarehouseMaterial(@PathVariable String warehouseId) {
        return service.getCampWarehouseMaterial(warehouseId)
	}
}
