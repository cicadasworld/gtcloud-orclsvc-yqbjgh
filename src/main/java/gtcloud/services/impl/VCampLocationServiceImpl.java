package gtcloud.services.impl;

import static gtcloud.specification.VCampLocationSpec.withBdmc;
import static gtcloud.specification.VCampLocationSpec.withCampCode;
import static gtcloud.specification.VCampLocationSpec.withCampWord;
import static gtcloud.specification.VCampLocationSpec.withDetailAddress;
import static gtcloud.specification.VCampLocationSpec.withDkmc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gtcloud.domain.VCampLocation;
import gtcloud.repositories.VCampLocationRepository;
import gtcloud.services.VCampLocationService;

@Service
public class VCampLocationServiceImpl implements VCampLocationService {

    @Autowired
    private VCampLocationRepository repository;

    @Override
    public List<VCampLocation> listAll() {
        List<VCampLocation> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public List<VCampLocation> getByBdnm(String bdnm) {
        List<VCampLocation> results = new ArrayList<>();
        repository.findByBdnm(bdnm).forEach(results::add);
        return results;
    }

    @Override
    public Page<VCampLocation> queryCampLocation(String key, Pageable pageable) {
        return repository.findAll(
                withBdmc(key)
                .or(withCampWord(key)
                .or(withCampCode(key))
                .or(withDetailAddress(key))
                .or(withDkmc(key))), pageable);
    }

    @Override
    public VCampLocation getByDknm(String dknm) {
        return repository.findById(dknm).orElse(null);
    }
}
