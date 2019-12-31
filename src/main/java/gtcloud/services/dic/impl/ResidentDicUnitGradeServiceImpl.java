package gtcloud.services.dic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.dic.ResidentDicUnitGrade;
import gtcloud.repositories.dic.ResidentDicUnitGradeRepository;
import gtcloud.services.dic.ResidentDicUnitGradeService;

@Service
public class ResidentDicUnitGradeServiceImpl implements ResidentDicUnitGradeService {

    @Autowired
    private ResidentDicUnitGradeRepository repository;

    @Override
    public ResidentDicUnitGrade getById(String id) {
        return repository.findById(id).orElse(null);
    }
}
