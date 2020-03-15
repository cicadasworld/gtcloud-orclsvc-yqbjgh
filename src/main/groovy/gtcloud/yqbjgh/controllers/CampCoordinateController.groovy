package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampCoordinateDTO
import gtcloud.yqbjgh.services.CampCoordinateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CampCoordinateController {

    @Autowired
    private CampCoordinateService service

	@GetMapping(value = "/camp-coordinate/{fid}")
	List<CampCoordinateDTO> getCampCoordinateByFid(@PathVariable String fid) {
	    return  service.getCampCoordinateByFid(fid)
	}

    @PostMapping(value = "/camp-coordinate")
    CampCoordinateDTO saveCampCoordinate(@RequestBody CampCoordinateDTO dto) {// Ϊ���빤���ṩ�Ľӿ�
        return service.saveCampCoordinate(dto)
    }

    @PutMapping(value = "/camp-coordinate/fid/{fid}") // ΪGTMap�ṩ�༭�ؿ�Ľӿ�
    List<CampCoordinateDTO> updateCampCoordinates(
    		@PathVariable String fid,
    		@RequestBody List<CampCoordinateDTO> dtos) {
        return service.updateCampCoordinates(fid, dtos)
    }

    @DeleteMapping(value = "/camp-coordinate/fid/{fid}") // ΪGTMap�ṩɾ���ؿ�Ľӿ�
    List<CampCoordinateDTO> deleteCampCoordinates(@PathVariable String fid) {
	    return service.deleteCampCoordinates(fid)
    }

    @PutMapping(value = "/camp-coordinate/{jlbm}")
    CampCoordinateDTO updateCampCoordinate(@PathVariable String jlbm, @RequestBody CampCoordinateDTO dto) {
        return service.updateCampCoordinate(jlbm, dto)
    }
}
