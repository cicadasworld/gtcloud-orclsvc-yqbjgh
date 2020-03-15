package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicStaffKind
import gtcloud.yqbjgh.repositories.dic.CampDicStaffKindRepository
import gtcloud.yqbjgh.services.dic.CampDicStaffKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicStaffKindServiceImpl implements CampDicStaffKindService {

    @Autowired
    private CampDicStaffKindRepository repository

    @Override
    CampDicStaffKind getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
