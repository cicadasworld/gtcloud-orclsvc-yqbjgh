package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.ResidentUnit
import gtcloud.yqbjgh.model.ResidentUnitDTO

interface ResidentUnitService {

    List<ResidentUnit> getByBdnm(String bdnm)

    List<ResidentUnit> getByUseingCampId(String campId)

    List<ResidentUnitDTO> getResidentUnit(String bdnm)

    List<ResidentUnitDTO> getResidentUnitByCampId(String campId)
}
