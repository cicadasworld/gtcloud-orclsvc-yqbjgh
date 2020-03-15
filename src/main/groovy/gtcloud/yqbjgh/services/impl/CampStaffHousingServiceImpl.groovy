package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampStaffHousingToCampStaffHousingDTO
import gtcloud.yqbjgh.domain.CampStaffHousing
import gtcloud.yqbjgh.model.CampStaffHousingDTO
import gtcloud.yqbjgh.repositories.CampStaffHousingRepository
import gtcloud.yqbjgh.services.CampStaffHousingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampStaffHousingServiceImpl implements CampStaffHousingService {

    @Autowired
    private CampStaffHousingRepository repository

    @Autowired
    private CampStaffHousingToCampStaffHousingDTO converter

    @Override
    List<CampStaffHousingDTO> getCampStaffHousing(String apartId) {
        List<CampStaffHousing> campStaffHousings = this.getByApartId(apartId)
        return campStaffHousings.stream()
                .map{campStaffHousing -> converter.convert(campStaffHousing)}
                .collect(toList())
    }

    List<CampStaffHousing> getByApartId(String apartId) {
        return repository.findByApartId(apartId)
    }
}
