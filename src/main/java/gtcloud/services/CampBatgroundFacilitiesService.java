package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampBatgroundFacilities;

public interface CampBatgroundFacilitiesService {

    List<CampBatgroundFacilities> listAll();

    CampBatgroundFacilities getById(String id);

    List<CampBatgroundFacilities> getByCampId(String campId);
}
