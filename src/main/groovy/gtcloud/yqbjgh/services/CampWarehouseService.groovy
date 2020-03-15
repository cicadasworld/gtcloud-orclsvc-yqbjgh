package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.CampWarehouse
import gtcloud.yqbjgh.model.CampWarehouseDTO

interface CampWarehouseService {

    List<CampWarehouse> getByCampId(String campId)

    List<CampWarehouseDTO> getCampWarehouse(String campId)
}
