package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampTrainingField;
import gtcloud.repositories.CampTrainingFieldRepository;
import gtcloud.services.CampTrainingFieldService;

@Service
public class CampTrainingFieldServiceImpl implements CampTrainingFieldService {

	@Autowired
    private CampTrainingFieldRepository repository;

    @Override
    public List<CampTrainingField> listAll() {
        List<CampTrainingField> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampTrainingField getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<CampTrainingField> getByCampId(String campId) {
		List<CampTrainingField> results = new ArrayList<>();
		repository.findByCampId(campId).forEach(results::add);
		return results;
	}
}
