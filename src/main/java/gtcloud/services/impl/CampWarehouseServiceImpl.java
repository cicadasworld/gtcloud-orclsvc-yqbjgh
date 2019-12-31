package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampWarehouse;
import gtcloud.repositories.CampWarehouseRepository;
import gtcloud.services.CampWarehouseService;

@Service
public class CampWarehouseServiceImpl implements CampWarehouseService {

	@Autowired
    private CampWarehouseRepository repository;

    @Override
    public List<CampWarehouse> listAll() {
        List<CampWarehouse> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampWarehouse getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<CampWarehouse> getByCampId(String campId) {
		List<CampWarehouse> results = new ArrayList<>();
		repository.findByCampId(campId).forEach(results::add);
		return results;
	}
}
