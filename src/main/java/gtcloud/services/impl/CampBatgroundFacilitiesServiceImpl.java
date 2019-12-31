package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampBatgroundFacilities;
import gtcloud.repositories.CampBatgroundFacilitiesRepository;
import gtcloud.services.CampBatgroundFacilitiesService;

@Service
public class CampBatgroundFacilitiesServiceImpl implements CampBatgroundFacilitiesService {

	@Autowired
    private CampBatgroundFacilitiesRepository repository;

    @Override
    public List<CampBatgroundFacilities> listAll() {
        List<CampBatgroundFacilities> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampBatgroundFacilities getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<CampBatgroundFacilities> getByCampId(String campId) {
		List<CampBatgroundFacilities> results = new ArrayList<>();
		repository.findByCampId(campId).forEach(results::add);
		return results;
	}
}
