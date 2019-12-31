package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.ResidentStaffConditionToResidentStaffConditionDTO;
import gtcloud.domain.ResidentStaffCondition;
import gtcloud.model.ResidentStaffConditionDTO;
import gtcloud.services.ResidentStaffConditionService;

@RestController
public class ResidentStaffConditionController {

	@Autowired
    private ResidentStaffConditionService service;

	@Autowired
	private ResidentStaffConditionToResidentStaffConditionDTO convertor;

	@GetMapping(value = "/resident-staff-condition/list")
	@CrossOrigin
	public List<ResidentStaffCondition> list() {
		List<ResidentStaffCondition> listAll = service.listAll();
		return listAll;
	}

	@GetMapping(value = "/resident-staff-condition/{id}")
	@CrossOrigin
	public List<ResidentStaffConditionDTO> getResidentStaffConditionByBdnm(@PathVariable String id) {
		List<ResidentStaffConditionDTO> results = new ArrayList<>();
		List<ResidentStaffCondition> conditions = service.getByBdnm(id);
		for (ResidentStaffCondition condition : conditions) {
			ResidentStaffConditionDTO dto = convertor.convert(condition);
			results.add(dto);
		}
		return results;
	}
}
