package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.CampApartUseclass
import gtcloud.yqbjgh.model.CampApartUseclassDTO

interface CampApartUseclassService {

    CampApartUseclass getById(String id)

    List<CampApartUseclassDTO> getCampApartUseClass(String apartId)
}
