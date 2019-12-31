package gtcloud.services;

import gtcloud.domain.CampCoordinate;

import java.util.List;

public interface CampCoordinateService {

    List<CampCoordinate> listAll();

    CampCoordinate getById(String id);

    CampCoordinate saveOrUpdate(CampCoordinate coordinate);

    List<CampCoordinate> getByFid(String fid);

    CampCoordinate getOneByFid(String fid);

    void deleteByFid(String fid);

}
