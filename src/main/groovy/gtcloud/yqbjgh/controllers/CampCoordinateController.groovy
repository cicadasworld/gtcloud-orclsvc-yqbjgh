package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampCoordinateDTO
import gtcloud.yqbjgh.services.CampCoordinateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CampCoordinateController {

    @Autowired
    CampCoordinateService service

    @GetMapping(value = "/camp-coordinate/{fid}")
    List<CampCoordinateDTO> getCampCoordinateByFid(@PathVariable String fid) {
        return service.getCampCoordinateByFid(fid)
    }

    @PostMapping(value = "/camp-coordinate")
    CampCoordinateDTO saveCampCoordinate(@RequestBody CampCoordinateDTO dto) {// Ϊ���빤���ṩ�Ľӿ�
        return service.saveCampCoordinate(dto)
    }

    @PutMapping(value = "/camp-coordinate/fid/{fid}")
    List<CampCoordinateDTO> updateCampCoordinates(
            @PathVariable String fid,
            @RequestBody List<CampCoordinateDTO> dtos) { // ΪGTMap�ṩ�༭�ؿ�Ľӿ�
        return service.updateCampCoordinates(fid, dtos)
    }

    @DeleteMapping(value = "/camp-coordinate/fid/{fid}")
    List<CampCoordinateDTO> deleteCampCoordinates(@PathVariable String fid) { // ΪGTMap�ṩɾ���ؿ�Ľӿ�
        return service.deleteCampCoordinates(fid)
    }

    @PutMapping(value = "/camp-coordinate/{jlbm}")
    CampCoordinateDTO updateCampCoordinate(
            @PathVariable String jlbm, @RequestBody CampCoordinateDTO dto) {
        return service.updateCampCoordinate(jlbm, dto)
    }
}
