package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampBatgroundFacilitiesToCampBatgroundFacilitiesDTO
import gtcloud.yqbjgh.domain.CampBatgroundFacilities
import gtcloud.yqbjgh.model.CampBatgroundFacilitiesDTO
import gtcloud.yqbjgh.repositories.CampBatgroundFacilitiesRepository
import gtcloud.yqbjgh.services.CampBatgroundFacilitiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampBatgroundFacilitiesServiceImpl implements CampBatgroundFacilitiesService {

    @Autowired
    CampBatgroundFacilitiesRepository repository

    @Autowired
    CampBatgroundFacilitiesToCampBatgroundFacilitiesDTO converter

    @Override
    List<CampBatgroundFacilitiesDTO> getCampBatgroundFacilities(String campId) {
        List<CampBatgroundFacilities> campBatgroundFacilities = repository.findByCampId(campId)
        return campBatgroundFacilities.stream().
                map { campBatgroundFacility -> converter.convert(campBatgroundFacility) }.
                collect(toList())
    }
}
