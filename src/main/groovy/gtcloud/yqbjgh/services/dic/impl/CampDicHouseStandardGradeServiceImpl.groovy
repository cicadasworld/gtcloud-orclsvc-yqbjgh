package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicHouseStandardGrade
import gtcloud.yqbjgh.repositories.dic.CampDicHouseStandardGradeRepository
import gtcloud.yqbjgh.services.dic.CampDicHouseStandardGradeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicHouseStandardGradeServiceImpl implements CampDicHouseStandardGradeService {

    @Autowired
    CampDicHouseStandardGradeRepository repository

    @Override
    CampDicHouseStandardGrade getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
