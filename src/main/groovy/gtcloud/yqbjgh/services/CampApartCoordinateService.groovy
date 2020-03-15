package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.CampApartCoordinate
import gtcloud.yqbjgh.model.CampApartCoordinateDTO

interface CampApartCoordinateService {

    CampApartCoordinate getById(String id)

    List<CampApartCoordinateDTO> getCampApartCoordinate(String apartId)

    CampApartCoordinateDTO createCampApartCoordinate(CampApartCoordinateDTO dto)

    CampApartCoordinateDTO updateCampApartCoordinate(String jlbm, CampApartCoordinateDTO dto)

    List<CampApartCoordinateDTO> deleteCampApartCoordinate(String apartId)
}
