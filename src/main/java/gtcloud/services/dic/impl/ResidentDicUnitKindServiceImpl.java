package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.ResidentDicUnitKind;
import gtcloud.repositories.dic.ResidentDicUnitKindRepository;
import gtcloud.services.dic.ResidentDicUnitKindService;

@Service
public class ResidentDicUnitKindServiceImpl implements ResidentDicUnitKindService {

    @Autowired
    private ResidentDicUnitKindRepository repository;

    @Override
    public ResidentDicUnitKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
