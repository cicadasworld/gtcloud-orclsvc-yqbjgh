package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.model.StaffStatistics
import gtcloud.yqbjgh.model.VUnitInforDTO

interface VUnitInforService {

    VUnitInforDTO getVUnitInforBybdnm(String bdnm)

    StaffStatistics getVUnitInforByCampId(String campId)

    StaffStatistics getVUnitInforByApartNum(String apartNum)
}
