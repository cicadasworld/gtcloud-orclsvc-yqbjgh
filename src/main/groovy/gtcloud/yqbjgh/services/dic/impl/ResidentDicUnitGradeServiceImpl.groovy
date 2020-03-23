package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.ResidentDicUnitGrade
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitGradeRepository
import gtcloud.yqbjgh.services.dic.ResidentDicUnitGradeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResidentDicUnitGradeServiceImpl implements ResidentDicUnitGradeService {

    @Autowired
    ResidentDicUnitGradeRepository repository

    @Override
    ResidentDicUnitGrade getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
