package gtcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.domain.CampTrainingField;
import gtcloud.services.CampTrainingFieldService;

@RestController
public class CampTrainingFieldController {

	@Autowired
    private CampTrainingFieldService service;

	@GetMapping(value = "/camp-training-field/list")
	@CrossOrigin
	public List<CampTrainingField> list() {
		List<CampTrainingField> listAll = service.listAll();
		return listAll;
	}

	@GetMapping(value = "/camp-training-field/{id}")
	@CrossOrigin
	public List<CampTrainingField> getCampTrainingField(@PathVariable String id) {
		List<CampTrainingField> results = service.getByCampId(id);
		return results;
	}
}
