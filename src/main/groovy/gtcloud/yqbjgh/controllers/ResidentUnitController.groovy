package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.ResidentUnitDTO
import gtcloud.yqbjgh.services.ResidentUnitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ResidentUnitController {

	@Autowired
    private ResidentUnitService service

	@GetMapping(value = "/resident-unit/bdnm/{bdnm}")
	List<ResidentUnitDTO> getResidentUnit(@PathVariable String bdnm) {
        return service.getResidentUnit(bdnm)
	}

    @GetMapping(value = "/resident-unit/campid/{campId}")
    List<ResidentUnitDTO> getResidentUnitByCampId(@PathVariable String campId) {
        return service.getResidentUnitByCampId(campId)
    }
}
