package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicStaffKind;
import gtcloud.repositories.dic.CampDicStaffKindRepository;
import gtcloud.services.dic.CampDicStaffKindService;

@Service
public class CampDicStaffKindServiceImpl implements CampDicStaffKindService {

    @Autowired
    private CampDicStaffKindRepository repository;

    @Override
    public CampDicStaffKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
