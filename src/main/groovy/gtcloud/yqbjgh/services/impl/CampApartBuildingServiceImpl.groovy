package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampApartBuildingToCampApartBuildingDTO
import gtcloud.yqbjgh.domain.CampApartBuilding
import gtcloud.yqbjgh.model.CampApartBuildingDTO
import gtcloud.yqbjgh.repositories.CampApartBuildingRepository
import gtcloud.yqbjgh.services.CampApartBuildingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampApartBuildingServiceImpl implements CampApartBuildingService {

    @Autowired
    CampApartBuildingRepository campApartBuildingRepository

    @Autowired
    private CampApartBuildingToCampApartBuildingDTO converter

    @Override
    CampApartBuildingDTO getById(String id) {
        CampApartBuildingDTO dto = new CampApartBuildingDTO()
        Optional<CampApartBuilding> optionalCampApartBuilding = campApartBuildingRepository.findById(id)
        if (optionalCampApartBuilding.isPresent()) {
            dto = converter.convert(optionalCampApartBuilding.get())
        }
        return dto
    }

    @Override
    List<CampApartBuildingDTO> getCampApartBuildingByCampId(String campId) {
        List<CampApartBuilding> campApartBuildings = campApartBuildingRepository.findByCampId(campId)
        return campApartBuildings.stream().
                map { campApartBuilding -> converter.convert(campApartBuilding) }.
                collect(toList())
    }
}
