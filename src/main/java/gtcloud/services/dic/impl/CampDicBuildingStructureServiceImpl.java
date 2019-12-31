package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicBuildingStructure;
import gtcloud.repositories.dic.CampDicBuildingStructureRepository;
import gtcloud.services.dic.CampDicBuildingStructureService;

@Service
public class CampDicBuildingStructureServiceImpl implements CampDicBuildingStructureService {

    @Autowired
    private CampDicBuildingStructureRepository repository;

    @Override
    public CampDicBuildingStructure getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
