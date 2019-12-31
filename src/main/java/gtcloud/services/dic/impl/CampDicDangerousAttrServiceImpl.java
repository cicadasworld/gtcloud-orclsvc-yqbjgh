package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicDangerousAttr;
import gtcloud.repositories.dic.CampDicDangerousAttrRepository;
import gtcloud.services.dic.CampDicDangerousAttrService;

@Service
public class CampDicDangerousAttrServiceImpl implements CampDicDangerousAttrService {

    @Autowired
    private CampDicDangerousAttrRepository repository;

    @Override
    public CampDicDangerousAttr getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
