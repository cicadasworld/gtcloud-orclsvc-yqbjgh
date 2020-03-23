package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicWarKind
import gtcloud.yqbjgh.repositories.dic.CampDicWarKindRepository
import gtcloud.yqbjgh.services.dic.CampDicWarKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicWarKindServiceImpl implements CampDicWarKindService {

    @Autowired
    CampDicWarKindRepository repository

    @Override
    CampDicWarKind getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
