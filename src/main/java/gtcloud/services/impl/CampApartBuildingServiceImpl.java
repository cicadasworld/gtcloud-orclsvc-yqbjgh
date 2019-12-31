package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampApartBuilding;
import gtcloud.repositories.CampApartBuildingRepository;
import gtcloud.services.CampApartBuildingService;

@Service
public class CampApartBuildingServiceImpl implements CampApartBuildingService {

	@Autowired
    private CampApartBuildingRepository repository;

    @Override
    public List<CampApartBuilding> listAll() {
        List<CampApartBuilding> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampApartBuilding getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<CampApartBuilding> getByCampId(String campId) {
		List<CampApartBuilding> results = new ArrayList<>();
		repository.findByCampId(campId).forEach(results::add);
		return results;
	}

	@Override
	public CampApartBuilding saveOrUpdate(CampApartBuilding building) {
		repository.save(building);
		return building;
	}
}
