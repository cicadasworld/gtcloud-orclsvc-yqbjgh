package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.ResidentDicStaffKind;
import gtcloud.repositories.dic.ResidentDicStaffKindRepository;
import gtcloud.services.dic.ResidentDicStaffKindService;

@Service
public class ResidentDicStaffKindServiceImpl implements ResidentDicStaffKindService {

    @Autowired
    private ResidentDicStaffKindRepository repository;

    @Override
    public ResidentDicStaffKind getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
