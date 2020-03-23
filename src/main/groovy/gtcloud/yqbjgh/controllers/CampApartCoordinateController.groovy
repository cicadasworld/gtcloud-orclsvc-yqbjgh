package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampApartCoordinateDTO
import gtcloud.yqbjgh.services.CampApartCoordinateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CampApartCoordinateController {

    @Autowired
    CampApartCoordinateService service

    @GetMapping(value = "/camp-apart-coordinate/{apartId}")
    List<CampApartCoordinateDTO> getCampApartCoordinate(@PathVariable String apartId) {
        return service.getCampApartCoordinate(apartId)
    }

    @PostMapping(value = "/camp-apart-coordinate")
    CampApartCoordinateDTO createCampApartCoordinate(@RequestBody CampApartCoordinateDTO dto) {
        return service.createCampApartCoordinate(dto)
    }

    @PutMapping(value = "/camp-apart-coordinate/{jlbm}")
    CampApartCoordinateDTO updateCampApartCoordinate(
            @PathVariable String jlbm, @RequestBody CampApartCoordinateDTO dto) {
        return service.updateCampApartCoordinate(jlbm, dto)
    }

    @DeleteMapping(value = "/camp-apart-coordinate/{apartId}")
    List<CampApartCoordinateDTO> deleteCampApartCoordinate(@PathVariable String apartId) {
        return service.deleteCampApartCoordinate(apartId)
    }
}
