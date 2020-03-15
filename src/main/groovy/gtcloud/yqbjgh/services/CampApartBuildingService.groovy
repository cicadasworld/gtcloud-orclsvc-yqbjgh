package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.model.CampApartBuildingDTO

interface CampApartBuildingService {

    CampApartBuildingDTO getById(String id)

    List<CampApartBuildingDTO> getCampApartBuildingByCampId(String campId)
}
