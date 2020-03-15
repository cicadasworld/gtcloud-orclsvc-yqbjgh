package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.model.CampCoordinateDTO

interface CampCoordinateService {

    List<CampCoordinateDTO> getCampCoordinateByFid(String fid)

    CampCoordinateDTO saveCampCoordinate(CampCoordinateDTO dto)

    CampCoordinateDTO updateCampCoordinate(String jlbm, CampCoordinateDTO dto)

    List<CampCoordinateDTO> updateCampCoordinates(String fid, List<CampCoordinateDTO> dtos)

    List<CampCoordinateDTO> deleteCampCoordinates(String fid)
}
