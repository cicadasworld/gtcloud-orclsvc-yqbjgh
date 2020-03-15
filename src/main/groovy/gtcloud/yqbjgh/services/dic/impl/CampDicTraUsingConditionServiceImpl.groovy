package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicTraUsingCondition
import gtcloud.yqbjgh.repositories.dic.CampDicTraUsingConditionRepository
import gtcloud.yqbjgh.services.dic.CampDicTraUsingConditionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicTraUsingConditionServiceImpl implements CampDicTraUsingConditionService {

    @Autowired
    private CampDicTraUsingConditionRepository repository

    @Override
    CampDicTraUsingCondition getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
