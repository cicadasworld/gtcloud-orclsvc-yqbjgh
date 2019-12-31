package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampStaffHousing;
import gtcloud.repositories.CampStaffHousingRepository;
import gtcloud.services.CampStaffHousingService;

@Service
public class CampStaffHousingServiceImpl implements CampStaffHousingService {

    @Autowired
    private CampStaffHousingRepository repository;

    @Override
    public List<CampStaffHousing> listAll() {
        List<CampStaffHousing> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampStaffHousing getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CampStaffHousing> getByApartId(String apartId) {
        List<CampStaffHousing> results = new ArrayList<>();
        repository.findByApartId(apartId).forEach(results::add);
        return results;
    }
}
