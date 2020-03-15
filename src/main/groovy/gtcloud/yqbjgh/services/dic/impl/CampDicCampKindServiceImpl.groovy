package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicCampKind
import gtcloud.yqbjgh.repositories.dic.CampDicCampKindRepository
import gtcloud.yqbjgh.services.dic.CampDicCampKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicCampKindServiceImpl implements CampDicCampKindService {

    @Autowired
    private CampDicCampKindRepository repository

    @Override
    CampDicCampKind getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampDicCampKind> listAll() {
        return repository.findAll()
    }
}
