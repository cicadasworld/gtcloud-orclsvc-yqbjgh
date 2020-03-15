package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicBatKind
import gtcloud.yqbjgh.repositories.dic.CampDicBatKindRepository
import gtcloud.yqbjgh.services.dic.CampDicBatKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicBatKindServiceImpl implements CampDicBatKindService {

    @Autowired
    private CampDicBatKindRepository repository

    @Override
    CampDicBatKind getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
