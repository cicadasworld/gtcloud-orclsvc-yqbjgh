package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampApartBuilding;

public interface CampApartBuildingService {

    List<CampApartBuilding> listAll();

    CampApartBuilding getById(String id);

    List<CampApartBuilding> getByCampId(String campId);

    CampApartBuilding saveOrUpdate(CampApartBuilding building);
}
