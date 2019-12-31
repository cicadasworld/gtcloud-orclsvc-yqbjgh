package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicMaterialKind;
import gtcloud.repositories.dic.CampDicMaterialKindRepository;
import gtcloud.services.dic.CampDicMaterialKindService;

@Service
public class CampDicMaterialKindServiceImpl implements CampDicMaterialKindService {

    @Autowired
    private CampDicMaterialKindRepository repository;

    @Override
    public CampDicMaterialKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
