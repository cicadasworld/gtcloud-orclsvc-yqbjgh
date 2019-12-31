package gtcloud.services;

import java.util.List;

import gtcloud.domain.ResidentUnitCampusing;

public interface ResidentUnitCampusingService {

    List<ResidentUnitCampusing> listAll();

    ResidentUnitCampusing getById(String id);

    List<ResidentUnitCampusing> getByCampId(String campId);
}
