package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampApartCoordinate;
import gtcloud.repositories.CampApartCoordinateRepository;
import gtcloud.services.CampApartCoordinateService;

@Service
public class CampApartCoordinateServiceImpl implements CampApartCoordinateService {

	@Autowired
    private CampApartCoordinateRepository repository;

    @Override
    public List<CampApartCoordinate> listAll() {
        List<CampApartCoordinate> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampApartCoordinate getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public CampApartCoordinate saveOrUpdate(CampApartCoordinate coordinate) {
		repository.save(coordinate);
		return coordinate;
	}

	@Override
	public List<CampApartCoordinate> getByApartId(String id) {
		List<CampApartCoordinate> results = new ArrayList<>();
		repository.findByApartId(id).forEach(results::add);
		return results;
	}
}
