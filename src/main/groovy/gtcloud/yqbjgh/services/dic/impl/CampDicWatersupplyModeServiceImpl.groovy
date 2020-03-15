package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicWatersupplyMode
import gtcloud.yqbjgh.repositories.dic.CampDicWatersupplyModeRepository
import gtcloud.yqbjgh.services.dic.CampDicWatersupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicWatersupplyModeServiceImpl implements CampDicWatersupplyModeService {

    @Autowired
    private CampDicWatersupplyModeRepository repository

    @Override
    CampDicWatersupplyMode getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampDicWatersupplyMode> listAll() {
        return repository.findAll()
    }
}
