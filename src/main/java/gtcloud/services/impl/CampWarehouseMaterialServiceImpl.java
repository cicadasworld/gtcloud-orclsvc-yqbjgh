package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampWarehouseMaterial;
import gtcloud.repositories.CampWarehouseMaterialRepository;
import gtcloud.services.CampWarehouseMaterialService;

@Service
public class CampWarehouseMaterialServiceImpl implements CampWarehouseMaterialService {

	@Autowired
    private CampWarehouseMaterialRepository repository;

    @Override
    public List<CampWarehouseMaterial> listAll() {
        List<CampWarehouseMaterial> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampWarehouseMaterial getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<CampWarehouseMaterial> getByWarehouseId(String warehouseId) {
		List<CampWarehouseMaterial> results = new ArrayList<>();
		repository.findByWarehouseId(warehouseId).forEach(results::add);
		return results;
	}
}
