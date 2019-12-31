package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicTrafieldKind;
import gtcloud.repositories.dic.CampDicTrafieldKindRepository;
import gtcloud.services.dic.CampDicTrafieldKindService;

@Service
public class CampDicTrafieldKindServiceImpl implements CampDicTrafieldKindService {

    @Autowired
    private CampDicTrafieldKindRepository repository;

    @Override
    public CampDicTrafieldKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
