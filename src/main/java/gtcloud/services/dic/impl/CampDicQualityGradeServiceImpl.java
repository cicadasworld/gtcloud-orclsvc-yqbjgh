package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.CampDicQualityGrade;
import gtcloud.repositories.dic.CampDicQualityGradeRepository;
import gtcloud.services.dic.CampDicQualityGradeService;

@Service
public class CampDicQualityGradeServiceImpl implements CampDicQualityGradeService {

    @Autowired
    private CampDicQualityGradeRepository repository;

    @Override
    public CampDicQualityGrade getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
