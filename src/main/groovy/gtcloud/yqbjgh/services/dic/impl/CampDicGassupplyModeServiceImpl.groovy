package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicGassupplyMode
import gtcloud.yqbjgh.repositories.dic.CampDicGassupplyModeRepository
import gtcloud.yqbjgh.services.dic.CampDicGassupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicGassupplyModeServiceImpl implements CampDicGassupplyModeService {

    @Autowired
    private CampDicGassupplyModeRepository repository

    @Override
    CampDicGassupplyMode getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampDicGassupplyMode> listAll() {
        return repository.findAll()
    }
}
