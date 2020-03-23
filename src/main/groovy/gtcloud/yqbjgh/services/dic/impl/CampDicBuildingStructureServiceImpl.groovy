package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.CampDicBuildingStructure
import gtcloud.yqbjgh.repositories.dic.CampDicBuildingStructureRepository
import gtcloud.yqbjgh.services.dic.CampDicBuildingStructureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampDicBuildingStructureServiceImpl implements CampDicBuildingStructureService {

    @Autowired
    CampDicBuildingStructureRepository repository

    @Override
    CampDicBuildingStructure getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
