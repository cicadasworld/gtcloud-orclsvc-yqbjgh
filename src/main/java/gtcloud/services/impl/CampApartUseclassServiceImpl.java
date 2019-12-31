package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampApartUseclass;
import gtcloud.repositories.CampApartUseclassRepository;
import gtcloud.services.CampApartUseclassService;

@Service
public class CampApartUseclassServiceImpl implements CampApartUseclassService {

    @Autowired
    private CampApartUseclassRepository repository;

    @Override
    public List<CampApartUseclass> listAll() {
        List<CampApartUseclass> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public CampApartUseclass getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CampApartUseclass> getByApartId(String apartId) {
        List<CampApartUseclass> results = new ArrayList<>();
        repository.findByApartId(apartId).forEach(results::add);
        return results;
    }
}
