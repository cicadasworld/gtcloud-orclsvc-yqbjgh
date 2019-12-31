package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicHouseGrade;
import gtcloud.repositories.dic.CampDicHouseGradeRepository;
import gtcloud.services.dic.CampDicHouseGradeService;

@Service
public class CampDicHouseGradeServiceImpl implements CampDicHouseGradeService {

    @Autowired
    private CampDicHouseGradeRepository repository;

    @Override
    public CampDicHouseGrade getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
