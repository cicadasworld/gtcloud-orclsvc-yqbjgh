package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.CampWarehouseMaterial
import gtcloud.yqbjgh.model.CampWarehouseMaterialDTO

interface CampWarehouseMaterialService {

    CampWarehouseMaterial getById(String id)

    List<CampWarehouseMaterialDTO> getCampWarehouseMaterial(String warehouseId)
}
