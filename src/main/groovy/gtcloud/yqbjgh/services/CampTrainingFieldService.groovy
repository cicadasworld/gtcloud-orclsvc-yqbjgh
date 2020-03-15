package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.CampTrainingField
import gtcloud.yqbjgh.model.CampTrainingFieldDTO

interface CampTrainingFieldService {

    List<CampTrainingField> getByCampId(String campId)

    List<CampTrainingFieldDTO> getCampTrainingField(String campId)
}
