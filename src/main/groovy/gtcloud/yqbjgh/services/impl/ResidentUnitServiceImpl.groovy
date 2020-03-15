package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.ResidentUnitToResidentUnitDTO
import gtcloud.yqbjgh.domain.ResidentUnit
import gtcloud.yqbjgh.model.ResidentUnitDTO
import gtcloud.yqbjgh.repositories.ResidentUnitRepository
import gtcloud.yqbjgh.services.ResidentUnitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class ResidentUnitServiceImpl implements ResidentUnitService {

	@Autowired
    private ResidentUnitRepository repository

    @Autowired
    private ResidentUnitToResidentUnitDTO converter

    @Override
    List<ResidentUnitDTO> getResidentUnit(String bdnm) {
        List<ResidentUnit> residentUnits = this.getByBdnm(bdnm)
        return residentUnits.stream()
                .map{residentUnit -> converter.convert(residentUnit)}
                .collect(toList())
    }

    List<ResidentUnit> getByBdnm(String bdnm) {
        return repository.findByBdnm(bdnm)
    }

    @Override
    List<ResidentUnitDTO> getResidentUnitByCampId(String campId) {
        List<ResidentUnit> residentUnits = this.getByUseingCampId(campId)
        return residentUnits.stream()
                .map{residentUnit -> converter.convert(residentUnit)}
                .collect(toList())
    }

    List<ResidentUnit> getByUseingCampId(String campId) {
        return repository.findByUseingCampId(campId)
    }
}
