package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.ResidentDicAdminDivision;
import gtcloud.repositories.dic.ResidentDicAdminDivisionRepository;
import gtcloud.services.dic.ResidentDicAdminDivisionService;

@Service
public class ResidentDicAdminDivisionServiceImpl implements ResidentDicAdminDivisionService {

    @Autowired
    private ResidentDicAdminDivisionRepository repository;

    @Override
    public ResidentDicAdminDivision getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
