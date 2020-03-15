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
    private VCampLocationRepository vCampLocationRepository

    @Autowired
    private CampCoordinateRepository campCoordinateRepository

    @Autowired
    private TxzhTsBddwmlService bddwmlService

    @Autowired
    private VCampLocationToVCampLocationDTO converter

    @Autowired
    private GeometryFactory geometryFactory

    @Override
    List<VCampLocationDTO> queryVCampLocationByCustomFields(CustomFields customFields) {
        Float maxCampArea = vCampLocationRepository.findMaxCampArea()
        String dknm = Optional.ofNullable(customFields.getDknm()).orElse("")
        String dkmc = Optional.ofNullable(customFields.getDkmc()).orElse("")
        String campWord = Optional.ofNullable(customFields.getCampWord()).orElse("")
        String campCode = Optional.ofNullable(customFields.getCampCode()).orElse("")
        String detailAddress = Optional.ofNullable(customFields.getDetailAddress()).orElse("")
        String campKind = Optional.ofNullable(customFields.getCampKind()).orElse("")
        String adminDivision = Optional.ofNullable(customFields.getAdminDivision()).orElse("")
        String siteKind = Optional.ofNullable(customFields.getSiteKind()).orElse("")
        String watersupplyMode = Optional.ofNullable(customFields.getWatersupplyMode()).orElse("")
        String elecsupplyMode = Optional.ofNullable(customFields.getElecsupplyMode()).orElse("")
        String gassupplyMode = Optional.ofNullable(customFields.getGassupplyMode()).orElse("")
        String heatsupplyMode = Optional.ofNullable(customFields.getHeatsupplyMode()).orElse("")
        String campAreaFrom = Optional.ofNullable(customFields.getCampAreaFrom()).orElse("0")
        String campAreaTo = Optional.ofNullable(customFields.getCampAreaTo()).orElse(String.valueOf(maxCampArea))
        Float from = null
        Float to = null
        boolean campAreaBlankCheck = isNotBlank(campAreaFrom) && isNotBlank(campAreaTo)
        if (campAreaBlankCheck) {
            from = Float.valueOf(campAreaFrom)
            to = Float.valueOf(campAreaTo)
        }

        Specification<VCampLocation> spec

        if (dknm.isEmpty() && dkmc.isEmpty() && campWord.isEmpty() && campCode.isEmpty() && detailAddress.isEmpty())
            spec = Specifications.<VCampLocation>and()
                    .like(isNotBlank(campKind), "campKind", campKind)
                    .like(isNotBlank(adminDivision), "adminDivision", adminDivision)
                    .like(isNotBlank(siteKind), "siteKind", siteKind)
                    .like(isNotBlank(watersupplyMode), "watersupplyMode", watersupplyMode)
                    .like(isNotBlank(elecsupplyMode), "elecsupplyMode", elecsupplyMode)
                    .like(isNotBlank(gassupplyMode), "gassupplyMode", gassupplyMode)
                    .like(isNotBlank(heatsupplyMode), "heatsupplyMode", heatsupplyMode)
                    .between(campAreaBlankCheck, "campArea", from, to)
                    .build()
        else {
            spec = Specifications.<VCampLocation>and()
                    .like(isNotBlank(campKind), "campKind", campKind)
                    .like(isNotBlank(adminDivision), "adminDivision", adminDivision)
                    .like(isNotBlank(siteKind), "siteKind", siteKind)
                    .like(isNotBlank(watersupplyMode), "watersupplyMode", watersupplyMode)
                    .like(isNotBlank(elecsupplyMode), "elecsupplyMode", elecsupplyMode)
                    .like(isNotBlank(gassupplyMode), "gassupplyMode", gassupplyMode)
                    .like(isNotBlank(heatsupplyMode), "heatsupplyMode", heatsupplyMode)
                    .between(campAreaBlankCheck, "campArea", from, to)
                    .predicate(Specifications.<VCampLocation>or()
                            .like(isNotBlank(dknm), "dknm", "%" + dknm + "%")
                            .like(isNotBlank(dkmc), "dkmc", "%" + dkmc + "%")
                            .like(isNotBlank(campWord), "campWord", "%" + campWord + "%")
                            .like(isNotBlank(campCode), "campCode", "%" + campCode + "%")
                            .like(isNotBlank(detailAddress), "detailAddress", "%" + detailAddress + "%")
                            .build())
                    .build()
        }

        List<VCampLocation> vCampLocations = vCampLocationRepository.findAll(spec)
        return vCampLocations.stream()
                .map{vCampLocation -> converter.convert(vCampLocation)}
                .collect(toList())
    }

    @Override
    VCampLocation getByDknm(String dknm) {
        return vCampLocationRepository.findById(dknm).orElse(null)
    }

    @Override
    List<VCampLocationDTO> getVManagedCampLocationsByBdnm(String id) {
        List<String> bdnms = bddwmlService.getBdnmFamily(id)
        return bdnms.stream().
                flatMap{bdnm -> getVCampLocationDTO(bdnm).stream()}.
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
                map{vCampLocation -> converter.convert(vCampLocation)}.
                collect(toList())
    }

    @Override
    List<VCampLocationDTO> queryCampLocationByRect(Double left, Double bottom, Double right, Double top) {
        Set<String> dknms = new HashSet<>()
        List<CampCoordinate> campCoordinates = campCoordinateRepository.findAll()
        for (CampCoordinate campCoordinate : campCoordinates) {
            Double x = Double.valueOf(campCoordinate.getCenterX())
            Double y = Double.valueOf(campCoordinate.getCenterY())
            if (x > left && x < right && y > bottom && y < top) { // ¼ìË÷Ìõ¼þ
                String fid = campCoordinate.getFid()
                dknms.add(fid)
            }
        }

        List<VCampLocationDTO> results = new ArrayList<>()
        dknms.forEach{dknm ->
            convertToDTO(vCampLocationRepository, dknm)
        }
        return results
    }

    void convertToDTO(VCampLocationRepository vCampLocationRepository, String dknm) {
        Optional<VCampLocation> optionalVCampLocation = vCampLocationRepository.findById(dknm)
        optionalVCampLocation.ifPresent{vCampLocation -> converter.convert(vCampLocation)}
    }

    @Override
    List<VCampLocationDTO> queryCampLocationByPolygon(Polygon polygon) {
        List<CampCoordinate> campCoordinates = campCoordinateRepository.findAll()
        Set<String> fids = campCoordinates.stream()
                .filter{campCoordinate -> pointIsInPolygon(polygon, campCoordinate)}
                .map{campCoordinate -> campCoordinate.fid}
                .collect(toSet())

        List<VCampLocation> vCampLocations = vCampLocationRepository.findAll()
        return vCampLocations.stream()
                .filter{vCampLocation -> locationIsInFids(fids, vCampLocation)}
                .map{ vCampLocation -> converter.convert(vCampLocation)}
                .collect(toList())
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
        Set<String> fids = campCoordinates.stream()
                .filter{campCoordinate -> pointIsInCircle(lat, lng, radius, campCoordinate)}
                .map{campCoordinate -> campCoordinate.fid}
                .collect(toSet())

        List<VCampLocation> vCampLocations = vCampLocationRepository.findAll()
        return vCampLocations.stream()
                .filter{vCampLocation -> locationIsInFids(fids, vCampLocation)}
                .map{vCampLocation -> converter.convert(vCampLocation)}
                .collect(toList())
    }

    private boolean pointIsInCircle(Double lat, Double lng, Double radius, CampCoordinate coordinate) {
        Double x = Double.valueOf(coordinate.getCenterX())
        Double y = Double.valueOf(coordinate.getCenterY())
        Point point = geometryFactory.createPoint(new Coordinate(x, y))
        Point circle = geometryFactory.createPoint(new Coordinate(lat, lng))
        return point.isWithinDistance(circle, radius)
    }
}
