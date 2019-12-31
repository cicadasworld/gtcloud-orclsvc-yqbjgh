package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.ResidentUnit;
import gtcloud.repositories.ResidentUnitRepository;
import gtcloud.services.ResidentUnitService;

@Service
public class ResidentUnitServiceImpl implements ResidentUnitService {

	@Autowired
    private ResidentUnitRepository repository;

    @Override
    public List<ResidentUnit> listAll() {
        List<ResidentUnit> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public ResidentUnit getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<ResidentUnit> getByBdnm(String bdnm) {
		List<ResidentUnit> results = new ArrayList<>();
		repository.findByBdnm(bdnm).forEach(results::add);
		return results;
	}
}
