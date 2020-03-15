package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampApartBuildingDTO
import gtcloud.yqbjgh.services.CampApartBuildingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CampApartBuildingController {

    @Autowired
    private CampApartBuildingService service

	@GetMapping(value = "/camp-apart-building/{jlbm}")
	CampApartBuildingDTO getCampApartBuilding(@PathVariable String jlbm) {
		return service.getById(jlbm)
	}

    @GetMapping(value = "/camp-apart-building/campid/{campId}")
    List<CampApartBuildingDTO> getCampApartBuildingByCampId(@PathVariable String campId) {
        return service.getCampApartBuildingByCampId(campId)
    }
}
