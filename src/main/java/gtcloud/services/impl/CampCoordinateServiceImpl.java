package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampCoordinate;
import gtcloud.repositories.CampCoordinateRepository;
import gtcloud.services.CampCoordinateService;

@Service
public class CampCoordinateServiceImpl implements CampCoordinateService {

    @Autowired
    private CampCoordinateRepository repository;

    @Override
    public List<CampCoordinate> listAll() {
        List<CampCoordinate> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampCoordinate getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CampCoordinate saveOrUpdate(CampCoordinate coordinate) {
        repository.save(coordinate);
        return coordinate;
    }

    @Override
    public List<CampCoordinate> getByFid(String fid) {
        return repository.findByFid(fid, Sort.by("coordinateNum"));
    }

    @Override
    public CampCoordinate getOneByFid(String fid) {
        List<CampCoordinate> campCoordinates = repository.findByFid(fid, null);
        if (campCoordinates.size() > 0) {
            return campCoordinates.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void deleteByFid(String fid) {
        List<CampCoordinate> campCoordinates = repository.findByFid(fid, null);
        for (CampCoordinate campCoordinate : campCoordinates) {
            String jlbm = campCoordinate.getJlbm();
            repository.deleteById(jlbm);
        }
    }
}
