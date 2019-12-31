package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicUsingStatus;
import gtcloud.repositories.dic.CampDicUsingStatusRepository;
import gtcloud.services.dic.CampDicUsingStatusService;

@Service
public class CampDicUsingStatusServiceImpl implements CampDicUsingStatusService {

    @Autowired
    private CampDicUsingStatusRepository repository;

    @Override
    public CampDicUsingStatus getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
