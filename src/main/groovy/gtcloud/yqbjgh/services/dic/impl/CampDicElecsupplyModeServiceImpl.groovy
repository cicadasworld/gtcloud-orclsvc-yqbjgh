package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicElecsupplyMode
import gtcloud.yqbjgh.repositories.dic.CampDicElecsupplyModeRepository
import gtcloud.yqbjgh.services.dic.CampDicElecsupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicElecsupplyModeServiceImpl implements CampDicElecsupplyModeService {

    @Autowired
    private CampDicElecsupplyModeRepository repository

    @Override
    CampDicElecsupplyMode getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampDicElecsupplyMode> listAll() {
        return repository.findAll()
    }
}
