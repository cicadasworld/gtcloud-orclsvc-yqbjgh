package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicBarrackUseClass
import gtcloud.yqbjgh.repositories.dic.CampDicBarrackUseClassRepository
import gtcloud.yqbjgh.services.dic.CampDicBarrackUseClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicBarrackUseClassServiceImpl implements CampDicBarrackUseClassService {

    @Autowired
    private CampDicBarrackUseClassRepository repository

    @Override
    CampDicBarrackUseClass getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
