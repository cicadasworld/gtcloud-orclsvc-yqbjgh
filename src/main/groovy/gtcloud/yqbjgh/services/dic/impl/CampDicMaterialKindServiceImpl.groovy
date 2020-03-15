package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicMaterialKind
import gtcloud.yqbjgh.repositories.dic.CampDicMaterialKindRepository
import gtcloud.yqbjgh.services.dic.CampDicMaterialKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicMaterialKindServiceImpl implements CampDicMaterialKindService {

    @Autowired
    private CampDicMaterialKindRepository repository

    @Override
    CampDicMaterialKind getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
