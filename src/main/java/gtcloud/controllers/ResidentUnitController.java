package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.ResidentUnitToResidentUnitDTO;
import gtcloud.domain.ResidentUnit;
import gtcloud.model.ResidentUnitDTO;
import gtcloud.services.ResidentUnitService;

@RestController
public class ResidentUnitController {

	@Autowired
    private ResidentUnitService service;

	@Autowired
	private ResidentUnitToResidentUnitDTO convertor;

	@GetMapping(value = "/resident-unit/list")
	@CrossOrigin
	public List<ResidentUnit> list() {
		List<ResidentUnit> listAll = service.listAll();
		return listAll;
	}

	@GetMapping(value = "/resident-unit/{id}")
	@CrossOrigin
	public List<ResidentUnitDTO> getResidentUnit(@PathVariable String id) {
		List<ResidentUnitDTO> results = new ArrayList<>();
		List<ResidentUnit> units = service.getByBdnm(id);
		for (ResidentUnit unit : units) {
			ResidentUnitDTO dto = convertor.convert(unit);
			results.add(dto);
		}
		return results;
	}
}
