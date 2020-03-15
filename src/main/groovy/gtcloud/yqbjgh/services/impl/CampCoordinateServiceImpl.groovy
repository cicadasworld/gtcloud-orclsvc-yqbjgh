package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampCoordinateToCampCoordinateDTO
import gtcloud.yqbjgh.domain.CampCoordinate

import gtcloud.yqbjgh.model.CampCoordinateDTO
import gtcloud.yqbjgh.repositories.CampCoordinateRepository
import gtcloud.yqbjgh.services.CampCoordinateService
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point
import org.locationtech.jts.geom.Polygon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampCoordinateServiceImpl implements CampCoordinateService {

    @Autowired
    private CampCoordinateRepository repository

    @Autowired
    private CampCoordinateToCampCoordinateDTO converter

    @Autowired
    private GeometryFactory geometryFactory

    private List<CampCoordinate> deleteByFid(String fid) {
        List<CampCoordinate> campCoordinates = repository.findByFid(fid, Sort.by("coordinateNum"))
        campCoordinates.forEach{campCoordinate -> repository.deleteById(campCoordinate.getJlbm())}
        return campCoordinates
    }

    @Override
    List<CampCoordinateDTO> getCampCoordinateByFid(String fid) {
        final List<CampCoordinate> campCoordinates = repository.findByFid(fid, Sort.by("coordinateNum"))
        return campCoordinates.stream()
                .map{campCoordinate -> converter.convert(campCoordinate)}
                .collect(toList())
    }

    @Override
    CampCoordinateDTO saveCampCoordinate(CampCoordinateDTO dto) {
        CampCoordinate coordinate = new CampCoordinate()
        coordinate.setJlbm(dto.getJlbm())
        coordinate.setFid(dto.getFid())
        coordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()))
        coordinate.setCoorX(dto.getCoorX())
        coordinate.setCoorY(dto.getCoorY())
        coordinate.setCenterX(dto.getCenterX())
        coordinate.setCenterY(dto.getCenterY())
        repository.save(coordinate)
        return dto
    }

    @Override
    CampCoordinateDTO updateCampCoordinate(String jlbm, CampCoordinateDTO dto) {
        CampCoordinate coordinate = new CampCoordinate()
        coordinate.setJlbm(jlbm)
        coordinate.setFid(dto.getFid())
        coordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()))
        coordinate.setCoorX(dto.getCoorX())
        coordinate.setCoorY(dto.getCoorY())
        coordinate.setCenterX(dto.getCenterX())
        coordinate.setCenterY(dto.getCenterY())
        repository.save(coordinate)
        return dto
    }

    @Override
    List<CampCoordinateDTO> updateCampCoordinates(String fid, List<CampCoordinateDTO> dtos) {
        // remove old coordiantes
        this.deleteByFid(fid)

        // calculate centroid
        List<Coordinate> coords = new ArrayList<>()
        for (CampCoordinateDTO dto : dtos) {
            coords.add(new Coordinate(Double.valueOf(dto.getCoorX()), Double.valueOf(dto.getCoorY())))
        }
        coords.add(new Coordinate(Double.valueOf(dtos.get(0).getCoorX()), Double.valueOf(dtos.get(0).getCoorY())))
        Polygon polygon = geometryFactory.createPolygon(coords.toArray(new Coordinate[coords.size()]))
        Point centroid = polygon.getCentroid()

        for (CampCoordinateDTO dto : dtos) {
            dto.setFid(fid)
            dto.setCenterX(String.valueOf(centroid.getX()))
            dto.setCenterY(String.valueOf(centroid.getY()))
            CampCoordinate coordinate = new CampCoordinate()
            String jlbm = dto.getJlbm()
            if (jlbm == null || jlbm.isEmpty()) {
                jlbm = UUID.randomUUID().toString().replace("-", "")
            }
            coordinate.setJlbm(jlbm)
            coordinate.setFid(fid)
            coordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()))
            coordinate.setCoorX(dto.getCoorX())
            coordinate.setCoorY(dto.getCoorY())
            coordinate.setCenterX(String.valueOf(centroid.getX()))
            coordinate.setCenterY(String.valueOf(centroid.getY()))
            repository.save(coordinate)
        }
        return dtos
    }

    @Override
    List<CampCoordinateDTO> deleteCampCoordinates(String fid) {
        List<CampCoordinate> campCoordinates = this.deleteByFid(fid)
        return campCoordinates.stream().map{campCoordinate ->
                converter.convert(campCoordinate)}.collect(toList())
    }
}
