package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicHeatsupplyMode
import gtcloud.yqbjgh.repositories.dic.CampDicHeatsupplyModeRepository
import gtcloud.yqbjgh.services.dic.CampDicHeatsupplyModeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicHeatsupplyModeServiceImpl implements CampDicHeatsupplyModeService {

    @Autowired
    private CampDicHeatsupplyModeRepository repository

    @Override
    CampDicHeatsupplyMode getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampDicHeatsupplyMode> listAll() {
        return repository.findAll()
    }
}
