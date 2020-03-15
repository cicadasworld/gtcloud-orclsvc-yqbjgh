package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.ResidentDicUnitKind
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitKindRepository
import gtcloud.yqbjgh.services.dic.ResidentDicUnitKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResidentDicUnitKindServiceImpl implements ResidentDicUnitKindService {

    @Autowired
    private ResidentDicUnitKindRepository repository

    @Override
    ResidentDicUnitKind getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
