package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicQualityGrade
import gtcloud.yqbjgh.repositories.dic.CampDicQualityGradeRepository
import gtcloud.yqbjgh.services.dic.CampDicQualityGradeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicQualityGradeServiceImpl implements CampDicQualityGradeService {

    @Autowired
    CampDicQualityGradeRepository repository

    @Override
    CampDicQualityGrade getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
