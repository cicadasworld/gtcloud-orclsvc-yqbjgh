package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.ResidentUnitCampusingToResidentUnitCampusingDTO;
import gtcloud.domain.ResidentUnitCampusing;
import gtcloud.model.ResidentUnitCampusingDTO;
import gtcloud.services.ResidentUnitCampusingService;

@RestController
public class ResidentUnitCampusingController {

	@Autowired
    private ResidentUnitCampusingService service;

	@Autowired
	private ResidentUnitCampusingToResidentUnitCampusingDTO convertor;

	@GetMapping(value = "/resident-unit-campusing/list")
	@CrossOrigin
	public List<ResidentUnitCampusing> list() {
		List<ResidentUnitCampusing> listAll = service.listAll();
		return listAll;
	}

	@GetMapping(value = "/resident-unit-campusing/{id}")
	@CrossOrigin
	public List<ResidentUnitCampusingDTO> getResidentCampusing(@PathVariable String id) {
		List<ResidentUnitCampusingDTO> results = new ArrayList<>();
		List<ResidentUnitCampusing> residentUnitCampusings = service.getByCampId(id);
		for (ResidentUnitCampusing residentUnitCampusing : residentUnitCampusings) {
			ResidentUnitCampusingDTO dto = convertor.convert(residentUnitCampusing);
			results.add(dto);
		}
		return results;
	}
}
