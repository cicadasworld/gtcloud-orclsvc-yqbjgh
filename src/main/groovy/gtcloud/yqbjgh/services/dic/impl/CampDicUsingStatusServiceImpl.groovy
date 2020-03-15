package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicUsingStatus
import gtcloud.yqbjgh.repositories.dic.CampDicUsingStatusRepository
import gtcloud.yqbjgh.services.dic.CampDicUsingStatusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicUsingStatusServiceImpl implements CampDicUsingStatusService {

    @Autowired
    private CampDicUsingStatusRepository repository

    @Override
    CampDicUsingStatus getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
