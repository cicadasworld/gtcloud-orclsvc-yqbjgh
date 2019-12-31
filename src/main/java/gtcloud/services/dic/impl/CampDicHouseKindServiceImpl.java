package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicHouseKind;
import gtcloud.repositories.dic.CampDicHouseKindRepository;
import gtcloud.services.dic.CampDicHouseKindService;

@Service
public class CampDicHouseKindServiceImpl implements CampDicHouseKindService {

    @Autowired
    private CampDicHouseKindRepository repository;

    @Override
    public CampDicHouseKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
