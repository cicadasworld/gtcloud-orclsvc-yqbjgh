package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.model.CampWarehouseDTO

interface CampWarehouseService {

    List<CampWarehouseDTO> getCampWarehouse(String campId)
}
