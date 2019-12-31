package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicBarrackUseClass;
import gtcloud.repositories.dic.CampDicBarrackUseClassRepository;
import gtcloud.services.dic.CampDicBarrackUseClassService;

@Service
public class CampDicBarrackUseClassServiceImpl implements CampDicBarrackUseClassService {

    @Autowired
    private CampDicBarrackUseClassRepository repository;

    @Override
    public CampDicBarrackUseClass getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
