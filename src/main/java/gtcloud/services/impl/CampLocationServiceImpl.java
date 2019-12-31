package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampLocation;
import gtcloud.repositories.CampLocationRepository;
import gtcloud.services.CampLocationService;

@Service
public class CampLocationServiceImpl implements CampLocationService {

	@Autowired
    private CampLocationRepository repository;

    @Override
    public List<CampLocation> listAll() {
        List<CampLocation> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampLocation getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<CampLocation> getByNm(String nm) {
		List<CampLocation> results = new ArrayList<>();
		repository.findByNm(nm).forEach(results::add);
		return results;
	}
}
