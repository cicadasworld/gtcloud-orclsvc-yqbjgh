package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicCamp
import gtcloud.yqbjgh.repositories.dic.CampDicCampRepository
import gtcloud.yqbjgh.services.dic.CampDicCampService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicCampServiceImpl implements CampDicCampService {

    @Autowired
    CampDicCampRepository repository

    @Override
    CampDicCamp getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
