package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampLocation;

public interface CampLocationService {

    List<CampLocation> listAll();

    CampLocation getById(String id);

    List<CampLocation> getByNm(String nm);
}
