package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.model.VUseCampLocationDTO

interface VUseCampLocationService {

    List<VUseCampLocationDTO> getVUsingCampCampLocationByBdnm(String bdnm)
}
