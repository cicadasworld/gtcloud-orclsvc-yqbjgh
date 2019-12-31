package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.CampApartCoordinateToCampApartCoordinateDTO;
import gtcloud.domain.CampApartCoordinate;
import gtcloud.model.CampApartCoordinateDTO;
import gtcloud.services.CampApartCoordinateService;

@RestController
public class CampApartCoordinateController {

    @Autowired
    private CampApartCoordinateService apartCoordinateSvc;

    @Autowired
    private CampApartCoordinateToCampApartCoordinateDTO convertor;

    @GetMapping(value = "/camp-apart-coordinate/list")
    @CrossOrigin
    public List<CampApartCoordinate> list() {
        List<CampApartCoordinate> listAll = apartCoordinateSvc.listAll();
        return listAll;
    }

    @GetMapping(value = "/camp-apart-coordinate/{id}")
    @CrossOrigin
    public List<CampApartCoordinateDTO> getCampApartCoordinate(@PathVariable String id) {
        List<CampApartCoordinateDTO> results = new ArrayList<>();
        List<CampApartCoordinate> campApartCoordinates = apartCoordinateSvc.getByApartId(id);
        for (CampApartCoordinate campApartCoordinate : campApartCoordinates) {
            CampApartCoordinateDTO dto = convertor.convert(campApartCoordinate);
            results.add(dto);
        }
        return results;
    }

    @PostMapping(value = "/camp-apart-coordinate")
    @CrossOrigin
    public CampApartCoordinateDTO createCampApartCoordinate(@RequestBody CampApartCoordinateDTO dto) {
    	CampApartCoordinate campApartCoordinate = new CampApartCoordinate();
    	String jlbm = UUID.randomUUID().toString().replace("-", "");
    	dto.setJlbm(jlbm);
    	campApartCoordinate.setJlbm(jlbm);
    	campApartCoordinate.setApartId(dto.getApartId());
    	campApartCoordinate.setCoorX(dto.getCoorX());
    	campApartCoordinate.setCoorY(dto.getCoorY());
    	campApartCoordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()));
    	campApartCoordinate.setCoorHeigh(dto.getCoorHeigh());
    	campApartCoordinate.setCoorLength(dto.getCoorLength());
    	campApartCoordinate.setSjcjry(dto.getSjcjry());
    	campApartCoordinate.setSjcjsj(dto.getSjcjsj());
    	apartCoordinateSvc.saveOrUpdate(campApartCoordinate);
    	return dto;
    }

    @PutMapping(value = "/camp-apart-coordinate/{id}")
    @CrossOrigin
    public CampApartCoordinateDTO updateCampApartCoordinate(@PathVariable String id, @RequestBody CampApartCoordinateDTO dto) {
    	CampApartCoordinate campApartCoordinate = new CampApartCoordinate();
    	campApartCoordinate.setJlbm(id);
    	campApartCoordinate.setApartId(dto.getApartId());
    	campApartCoordinate.setCoorX(dto.getCoorX());
    	campApartCoordinate.setCoorY(dto.getCoorY());
    	campApartCoordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()));
    	campApartCoordinate.setCoorHeigh(dto.getCoorHeigh());
    	campApartCoordinate.setCoorLength(dto.getCoorLength());
    	campApartCoordinate.setSjcjry(dto.getSjcjry());
    	campApartCoordinate.setSjcjsj(dto.getSjcjsj());
    	apartCoordinateSvc.saveOrUpdate(campApartCoordinate);
    	return dto;
    }
}
