package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.domain.CampApartBuilding;
import gtcloud.domain.CampApartCoordinate;
import gtcloud.model.CampApartBuildingDTO;
import gtcloud.services.CampApartBuildingService;
import gtcloud.services.CampApartCoordinateService;

@RestController
public class CampApartBuildingController {

    @Autowired
    private CampApartBuildingService apartBuildingSvc;

    @Autowired
    private CampApartCoordinateService apartCoordinateSvc;

	@GetMapping(value = "/camp-apart-building/list")
	@CrossOrigin
	public List<CampApartBuilding> list() {
		List<CampApartBuilding> listAll = apartBuildingSvc.listAll();
		return listAll;
	}

	@GetMapping(value = "/camp-apart-building/{id}")
	@CrossOrigin
	public CampApartBuilding getCampApartBuilding(@PathVariable String id) {
		CampApartBuilding result = apartBuildingSvc.getById(id);
		return result;
	}

    @GetMapping(value = "/camp-apart-building/campId/{campId}")
    @CrossOrigin
    public List<CampApartBuildingDTO> getCampApartBuildingByNm(@PathVariable String campId) {
        List<CampApartBuildingDTO> results = new ArrayList<>();
        List<CampApartBuilding> campApartBuildings = apartBuildingSvc.getByCampId(campId);
        for (CampApartBuilding campApartBuilding : campApartBuildings) {
			CampApartBuildingDTO dto = new CampApartBuildingDTO();
			dto.setApartName(campApartBuilding.getApartName());
			dto.setApartNum(campApartBuilding.getApartNum());
			dto.setBuildingStructure(campApartBuilding.getBuildingStructure());
			dto.setCampId(campApartBuilding.getCampId());
			dto.setElevatorNum(campApartBuilding.getElevatorNum());
			dto.setFloorArea(campApartBuilding.getFloorArea());
			dto.setFloorlevelDown(campApartBuilding.getFloorlevelDown());
			dto.setFloorlevelUp(campApartBuilding.getFloorlevelUp());
			dto.setFloorYear(campApartBuilding.getFloorYear());
			dto.setJlbm(campApartBuilding.getJlbm());
			dto.setQualityGrade(campApartBuilding.getQualityGrade());
			dto.setSjcjry(campApartBuilding.getSjcjry());
			dto.setSjcjsj(campApartBuilding.getSjcjsj());
			dto.setUsingStatus(campApartBuilding.getUsingStatus());
			List<CampApartCoordinate> campApartCoordinates = apartCoordinateSvc.getByApartId(campApartBuilding.getJlbm()); // 分栋坐标的apartId和分栋信息的jlbm关联
        	for (CampApartCoordinate campApartCoordinate : campApartCoordinates) {
				dto.setCoorX(campApartCoordinate.getCoorX());
				dto.setCoorY(campApartCoordinate.getCoorY());
			}
        	results.add(dto);
		}
        return results;
    }
}
