package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampWarehouseMaterial;

public interface CampWarehouseMaterialService {

    List<CampWarehouseMaterial> listAll();

    CampWarehouseMaterial getById(String id);

    List<CampWarehouseMaterial> getByWarehouseId(String warehouseId);
}
