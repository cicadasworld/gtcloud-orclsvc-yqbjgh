package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.ResidentUnitCampusing;
import gtcloud.repositories.ResidentUnitCampusingRepository;
import gtcloud.services.ResidentUnitCampusingService;

@Service
public class ResidentUnitCampusingServiceImpl implements ResidentUnitCampusingService {

	@Autowired
    private ResidentUnitCampusingRepository repository;

    @Override
    public List<ResidentUnitCampusing> listAll() {
        List<ResidentUnitCampusing> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public ResidentUnitCampusing getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<ResidentUnitCampusing> getByCampId(String campId) {
		List<ResidentUnitCampusing> results = new ArrayList<>();
		repository.findByCampId(campId).forEach(results::add);
		return results;
	}
}
