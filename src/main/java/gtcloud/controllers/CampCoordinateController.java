package gtcloud.controllers;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import gtcloud.helper.GeometryHelper;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.domain.CampCoordinate;
import gtcloud.model.CampCoordinateDTO;
import gtcloud.services.CampCoordinateService;

@RestController
public class CampCoordinateController {

    @Autowired
    private CampCoordinateService campCoordinateSvc;

    @GetMapping(value = "/camp-coordinate/list")
    @CrossOrigin
    public List<CampCoordinate> list() {
        List<CampCoordinate> listAll = campCoordinateSvc.listAll();
        return listAll;
    }

	@GetMapping(value = "/camp-coordinate")
	@CrossOrigin
	public List<CampCoordinate> getCampCoordinateByRequestParam(@RequestParam String fid) {
		List<CampCoordinate> results = campCoordinateSvc.getByFid(fid);
		return results;
	}

	@GetMapping(value = "/camp-coordinate/{fid}")
	@CrossOrigin
	public List<CampCoordinate> getCampCoordinateByPathVariable(@PathVariable String fid) {
		List<CampCoordinate> results = campCoordinateSvc.getByFid(fid);
		return results;
	}

    @PostMapping(value = "/camp-coordinate")
    @CrossOrigin
    public CampCoordinateDTO saveCampApartCoordinate(@RequestBody CampCoordinateDTO dto) {// 为导入工具提供的接口
    	CampCoordinate coordinate = new CampCoordinate();
    	coordinate.setJlbm(dto.getJlbm());
    	coordinate.setFid(dto.getFid());
    	coordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()));
    	coordinate.setCoorX(dto.getCoorX());
    	coordinate.setCoorY(dto.getCoorY());
    	coordinate.setCenterX(dto.getCenterX());
    	coordinate.setCenterY(dto.getCenterY());
    	campCoordinateSvc.saveOrUpdate(coordinate);
    	return dto;
    }

    @PutMapping(value = "/camp-coordinate/{jlbm}")
    @CrossOrigin
    public CampCoordinateDTO updateCampApartCoordinate(@PathVariable String jlbm, @RequestBody CampCoordinateDTO dto) {
    	CampCoordinate coordinate = new CampCoordinate();
    	coordinate.setJlbm(jlbm);
    	coordinate.setFid(dto.getFid());
    	coordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()));
    	coordinate.setCoorX(dto.getCoorX());
    	coordinate.setCoorY(dto.getCoorY());
    	coordinate.setCenterX(dto.getCenterX());
    	coordinate.setCenterY(dto.getCenterY());
    	campCoordinateSvc.saveOrUpdate(coordinate);
    	return dto;
    }

    @PutMapping(value = "/camp-coordinate/fid/{fid}") // 为GTMap编辑地块提供的接口
    @CrossOrigin
    public List<CampCoordinateDTO> updateCampApartCoordinates(
    		@PathVariable String fid,
    		@RequestBody List<CampCoordinateDTO> dtos) {
        // remove old coordiantes
        campCoordinateSvc.deleteByFid(fid);

        // calculate centroid
        List<Coordinate> coords = new ArrayList<>();
        for (CampCoordinateDTO dto : dtos) {
            coords.add(new Coordinate(Double.valueOf(dto.getCoorX()), Double.valueOf(dto.getCoorY())));
        }
        coords.add(new Coordinate(Double.valueOf(dtos.get(0).getCoorX()), Double.valueOf(dtos.get(0).getCoorY())));
        Point centroid = GeometryHelper.getCentroid(coords.toArray(new Coordinate[coords.size()]));

        for (CampCoordinateDTO dto : dtos) {
            dto.setFid(fid);
            dto.setCenterX(String.valueOf(centroid.getX()));
            dto.setCenterY(String.valueOf(centroid.getY()));
            CampCoordinate coordinate = new CampCoordinate();
            String jlbm = dto.getJlbm();
            if (jlbm == null || jlbm.isEmpty()) {
                jlbm = UUID.randomUUID().toString().replace("-", "");
            }
            coordinate.setJlbm(jlbm);
            coordinate.setFid(fid);
            coordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()));
            coordinate.setCoorX(dto.getCoorX());
            coordinate.setCoorY(dto.getCoorY());
            coordinate.setCenterX(String.valueOf(centroid.getX()));
            coordinate.setCenterY(String.valueOf(centroid.getY()));
    		campCoordinateSvc.saveOrUpdate(coordinate);
		}
    	return dtos;
    }
}
