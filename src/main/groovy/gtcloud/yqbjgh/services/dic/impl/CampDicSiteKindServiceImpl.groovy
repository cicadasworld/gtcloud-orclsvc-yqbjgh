package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicSiteKind
import gtcloud.yqbjgh.repositories.dic.CampDicSiteKindRepository
import gtcloud.yqbjgh.services.dic.CampDicSiteKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicSiteKindServiceImpl implements CampDicSiteKindService {

    @Autowired
    private CampDicSiteKindRepository repository

    @Override
    CampDicSiteKind getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampDicSiteKind> listAll() {
        return repository.findAll()
    }
}
