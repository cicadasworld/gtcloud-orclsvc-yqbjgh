package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicTrafieldKind
import gtcloud.yqbjgh.repositories.dic.CampDicTrafieldKindRepository
import gtcloud.yqbjgh.services.dic.CampDicTrafieldKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicTrafieldKindServiceImpl implements CampDicTrafieldKindService {

    @Autowired
    CampDicTrafieldKindRepository repository

    @Override
    CampDicTrafieldKind getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
