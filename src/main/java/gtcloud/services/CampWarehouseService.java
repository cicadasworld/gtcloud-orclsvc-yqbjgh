package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampWarehouse;

public interface CampWarehouseService {

    List<CampWarehouse> listAll();

    CampWarehouse getById(String id);

    List<CampWarehouse> getByCampId(String campId);
}
