package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.VCampLocationToVCampLocationDTO
import gtcloud.yqbjgh.domain.CampCoordinate
import gtcloud.yqbjgh.domain.VCampLocation
import gtcloud.yqbjgh.model.CustomFields
import gtcloud.yqbjgh.model.VCampLocationDTO
import gtcloud.yqbjgh.repositories.CampCoordinateRepository
import gtcloud.yqbjgh.repositories.VCampLocationRepository
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import gtcloud.yqbjgh.services.VCampLocationService
import gtcloud.yqbjgh.specification.Specifications
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point
import org.locationtech.jts.geom.Polygon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList
import static java.util.stream.Collectors.toSet
import static org.apache.commons.lang3.StringUtils.isNotBlank

@Service
class VCampLocationServiceImpl implements VCampLocationService {

    @Autowired
    VCampLocationRepository vCampLocationRepository

    @Autowired
    CampCoordinateRepository campCoordinateRepository

    @Autowired
    TxzhTsBddwmlService bddwmlService

    @Autowired
    VCampLocationToVCampLocationDTO converter

    @Autowired
    GeometryFactory geometryFactory

    @Override
    List<VCampLocationDTO> queryVCampLocationByCustomFields(CustomFields customFields) {
        Float maxCampArea = vCampLocationRepository.findMaxCampArea()
        String dknm = customFields.getDknm() ?: ""
        String dkmc = customFields.getDkmc() ?: ""
        String campWord = customFields.getCampWord() ?: ""
        String campCode = customFields.getCampCode() ?: ""
        String detailAddress = customFields.getDetailAddress() ?: ""
        String campKind = customFields.getCampKind() ?: ""
        String adminDivision = customFields.getAdminDivision() ?: ""
        String siteKind = customFields.getSiteKind() ?: ""
        String watersupplyMode = customFields.getWatersupplyMode() ?: ""
        String elecsupplyMode = customFields.getElecsupplyMode() ?: ""
        String gassupplyMode = customFields.getGassupplyMode() ?: ""
        String heatsupplyMode = customFields.getHeatsupplyMode() ?: ""
        String campAreaFrom = customFields.getCampAreaFrom() ?: "0"
        String campAreaTo = customFields.getCampAreaTo() ?: String.valueOf(maxCampArea)

        Float from = campAreaFrom as Float
        Float to = campAreaTo as Float ?: maxCampArea

        Specification<VCampLocation> spec

        if (dknm.isEmpty() && dkmc.isEmpty() && campWord.isEmpty() && campCode.isEmpty() && detailAddress.isEmpty())
            spec = Specifications.<VCampLocation> and()
                    .like(isNotBlank(campKind), "campKind", campKind)
                    .like(isNotBlank(adminDivision), "adminDivision", adminDivision)
                    .like(isNotBlank(siteKind), "siteKind", siteKind)
                    .like(isNotBlank(watersupplyMode), "watersupplyMode", watersupplyMode)
                    .like(isNotBlank(elecsupplyMode), "elecsupplyMode", elecsupplyMode)
                    .like(isNotBlank(gassupplyMode), "gassupplyMode", gassupplyMode)
                    .like(isNotBlank(heatsupplyMode), "heatsupplyMode", heatsupplyMode)
                    .between(true, "campArea", from, to)
                    .build()
        else {
            spec = Specifications.<VCampLocation> and()
                    .like(isNotBlank(campKind), "campKind", campKind)
                    .like(isNotBlank(adminDivision), "adminDivision", adminDivision)
                    .like(isNotBlank(siteKind), "siteKind", siteKind)
                    .like(isNotBlank(watersupplyMode), "watersupplyMode", watersupplyMode)
                    .like(isNotBlank(elecsupplyMode), "elecsupplyMode", elecsupplyMode)
                    .like(isNotBlank(gassupplyMode), "gassupplyMode", gassupplyMode)
                    .like(isNotBlank(heatsupplyMode), "heatsupplyMode", heatsupplyMode)
                    .between(true, "campArea", from, to)
                    .predicate(Specifications.<VCampLocation> or()
                    .like(isNotBlank(dknm), "dknm", "%" + dknm + "%")
                    .like(isNotBlank(dkmc), "dkmc", "%" + dkmc + "%")
                    .like(isNotBlank(campWord), "campWord", "%" + campWord + "%")
                    .like(isNotBlank(campCode), "campCode", "%" + campCode + "%")
                    .like(isNotBlank(detailAddress), "detailAddress", "%" + detailAddress + "%")
                    .build())
                    .build()
        }

        List<VCampLocation> vCampLocations = vCampLocationRepository.findAll(spec)
        return vCampLocations.stream().
                map { vCampLocation -> converter.convert(vCampLocation) }.
                collect(toList())
    }

    @Override
    VCampLocation getByDknm(String dknm) {
        return vCampLocationRepository.findById(dknm).orElse(null)
    }

    @Override
    List<VCampLocationDTO> getVManagedCampLocationsByBdnm(String id) {
        List<String> bdnms = bddwmlService.getBdnmFamily(id)
        return bdnms.stream().
                flatMap { bdnm -> getVCampLocationDTO(bdnm).stream() }.
                collect(toList())
    }

    List<VCampLocationDTO> getVCampLocationDTO(String bdnm) {
        List<VCampLocation> vCampLocations
        boolean isRootUnit = bddwmlService.isRootUnit(bdnm)
        if (isRootUnit) {
            vCampLocations = vCampLocationRepository.findAll()
        } else {
            vCampLocations = vCampLocationRepository.findByBdnm(bdnm, Sort.by("dknm"))
        }
        return vCampLocations.stream().
                map { vCampLocation -> converter.convert(vCampLocation) }.
                collect(toList())
    }

    @Override
    List<VCampLocationDTO> queryCampLocationByPolygon(Polygon polygon) {
        List<CampCoordinate> campCoordinates = campCoordinateRepository.findAll()
        Set<String> fids = campCoordinates.stream().
                filter { campCoordinate -> pointIsInPolygon(polygon, campCoordinate) }.
                map { campCoordinate -> campCoordinate.fid }.
                collect(toSet())

        List<VCampLocation> vCampLocations = vCampLocationRepository.findAll()
        return vCampLocations.stream().
                filter { vCampLocation -> locationIsInFids(fids, vCampLocation) }.
                map { vCampLocation -> converter.convert(vCampLocation) }.
                collect(toList())
    }

    private boolean pointIsInPolygon(Polygon polygon, CampCoordinate coordinate) {
        Double x = Double.valueOf(coordinate.getCenterX())
        Double y = Double.valueOf(coordinate.getCenterY())
        Point point = geometryFactory.createPoint(new Coordinate(x, y))
        return polygon.contains(point)
    }

    private static boolean locationIsInFids(Set<String> fids, VCampLocation location) {
        return fids.contains(location.getDknm())
    }

    @Override
    List<VCampLocationDTO> queryCampLocationByCircle(Double lat, Double lng, Double radius) {
        List<CampCoordinate> campCoordinates = campCoordinateRepository.findAll()
        Set<String> fids = campCoordinates.stream().
                filter { campCoordinate -> pointIsInCircle(lat, lng, radius, campCoordinate) }.
                map { campCoordinate -> campCoordinate.fid }.
                collect(toSet())

        List<VCampLocation> vCampLocations = vCampLocationRepository.findAll()
        return vCampLocations.stream().
                filter { vCampLocation -> locationIsInFids(fids, vCampLocation) }.
                map { vCampLocation -> converter.convert(vCampLocation) }.
                collect(toList())
    }

    private boolean pointIsInCircle(Double lat, Double lng, Double radius, CampCoordinate coordinate) {
        Double x = Double.valueOf(coordinate.getCenterX())
        Double y = Double.valueOf(coordinate.getCenterY())
        Point point = geometryFactory.createPoint(new Coordinate(x, y))
        Point circle = geometryFactory.createPoint(new Coordinate(lat, lng))
        return point.isWithinDistance(circle, radius)
    }
}
