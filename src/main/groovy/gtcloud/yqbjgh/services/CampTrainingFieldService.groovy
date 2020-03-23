package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.model.CampTrainingFieldDTO

interface CampTrainingFieldService {

    List<CampTrainingFieldDTO> getCampTrainingField(String campId)
}
