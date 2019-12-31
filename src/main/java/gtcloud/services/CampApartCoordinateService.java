package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampApartCoordinate;

public interface CampApartCoordinateService {

    List<CampApartCoordinate> listAll();

    CampApartCoordinate getById(String id);

    List<CampApartCoordinate> getByApartId(String id);

    CampApartCoordinate saveOrUpdate(CampApartCoordinate coordinate);
}
