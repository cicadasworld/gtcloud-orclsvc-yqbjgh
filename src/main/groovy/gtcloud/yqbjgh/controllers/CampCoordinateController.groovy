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
    CampCoordinateDTO saveCampCoordinate(@RequestBody CampCoordinateDTO dto) {// 为导入工具提供的接口
        return service.saveCampCoordinate(dto)
    }

    @PutMapping(value = "/camp-coordinate/fid/{fid}")
    List<CampCoordinateDTO> updateCampCoordinates(
            @PathVariable String fid,
            @RequestBody List<CampCoordinateDTO> dtos) { // 为GTMap提供编辑地块的接口
        return service.updateCampCoordinates(fid, dtos)
    }

    @DeleteMapping(value = "/camp-coordinate/fid/{fid}")
    List<CampCoordinateDTO> deleteCampCoordinates(@PathVariable String fid) { // 为GTMap提供删除地块的接口
        return service.deleteCampCoordinates(fid)
    }

    @PutMapping(value = "/camp-coordinate/{jlbm}")
    CampCoordinateDTO updateCampCoordinate(
            @PathVariable String jlbm, @RequestBody CampCoordinateDTO dto) {
        return service.updateCampCoordinate(jlbm, dto)
    }
}
