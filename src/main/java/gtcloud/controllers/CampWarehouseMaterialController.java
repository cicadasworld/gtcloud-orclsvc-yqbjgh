package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.CampWarehouseMaterialToCampWarehouseMaterialDTO;
import gtcloud.domain.CampWarehouseMaterial;
import gtcloud.model.CampWarehouseMaterialDTO;
import gtcloud.services.CampWarehouseMaterialService;

@RestController
public class CampWarehouseMaterialController {

	@Autowired
    private CampWarehouseMaterialService service;

	@Autowired
	private CampWarehouseMaterialToCampWarehouseMaterialDTO convertor;

	@GetMapping(value = "/camp-warehouse-material/list")
	@CrossOrigin
	public List<CampWarehouseMaterial> list() {
		List<CampWarehouseMaterial> listAll = service.listAll();
		return listAll;
	}

	@GetMapping(value = "/camp-warehouse-material/{id}")
	@CrossOrigin
	public List<CampWarehouseMaterialDTO> getCampWarehouseMaterial(@PathVariable String id) {
		List<CampWarehouseMaterialDTO> results = new ArrayList<>();
		List<CampWarehouseMaterial> campWarehouseMaterials = service.getByWarehouseId(id);
		for (CampWarehouseMaterial campWarehouseMaterial : campWarehouseMaterials) {
			CampWarehouseMaterialDTO dto = convertor.convert(campWarehouseMaterial);
			results.add(dto);
		}
		return results;
	}
}
