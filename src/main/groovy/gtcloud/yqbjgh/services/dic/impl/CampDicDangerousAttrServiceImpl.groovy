package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicDangerousAttr
import gtcloud.yqbjgh.repositories.dic.CampDicDangerousAttrRepository
import gtcloud.yqbjgh.services.dic.CampDicDangerousAttrService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicDangerousAttrServiceImpl implements CampDicDangerousAttrService {

    @Autowired
    private CampDicDangerousAttrRepository repository

    @Override
    CampDicDangerousAttr getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
