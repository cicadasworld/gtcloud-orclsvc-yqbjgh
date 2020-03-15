package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.model.CampBatgroundFacilitiesDTO

interface CampBatgroundFacilitiesService {

    List<CampBatgroundFacilitiesDTO> getCampBatgroundFacilities(String campId)
}
