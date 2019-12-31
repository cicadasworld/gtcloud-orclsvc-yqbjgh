package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicCampKind;
import gtcloud.repositories.dic.CampDicCampKindRepository;
import gtcloud.services.dic.CampDicCampKindService;

@Service
public class CampDicCampKindServiceImpl implements CampDicCampKindService {

    @Autowired
    private CampDicCampKindRepository repository;

    @Override
    public CampDicCampKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
