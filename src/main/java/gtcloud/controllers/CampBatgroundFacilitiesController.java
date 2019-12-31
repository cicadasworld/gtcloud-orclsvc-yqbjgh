package gtcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.domain.CampBatgroundFacilities;
import gtcloud.services.CampBatgroundFacilitiesService;

@RestController
public class CampBatgroundFacilitiesController {

	@Autowired
    private CampBatgroundFacilitiesService service;

	@GetMapping(value = "/camp-batground-facilities/list")
	@CrossOrigin
	public List<CampBatgroundFacilities> list() {
		List<CampBatgroundFacilities> listAll = service.listAll();
		return listAll;
	}

	@GetMapping(value = "/camp-batground-facilities/{id}")
	@CrossOrigin
	public List<CampBatgroundFacilities> getCampBatgroundFacilities(@PathVariable String id) {
		List<CampBatgroundFacilities> results = service.getByCampId(id);
		return results;
	}
}
