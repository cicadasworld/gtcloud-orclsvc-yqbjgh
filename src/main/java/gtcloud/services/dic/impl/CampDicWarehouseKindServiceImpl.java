package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicWarehouseKind;
import gtcloud.repositories.dic.CampDicWarehouseKindRepository;
import gtcloud.services.dic.CampDicWarehouseKindService;

@Service
public class CampDicWarehouseKindServiceImpl implements CampDicWarehouseKindService {

    @Autowired
    private CampDicWarehouseKindRepository repository;

    @Override
    public CampDicWarehouseKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
