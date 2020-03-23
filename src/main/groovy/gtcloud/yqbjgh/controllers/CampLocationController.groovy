package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.domain.VCampLocation
import gtcloud.yqbjgh.model.CustomFields
import gtcloud.yqbjgh.model.RestResult
import gtcloud.yqbjgh.model.VCampLocationDTO
import gtcloud.yqbjgh.model.VUseCampLocationDTO
import gtcloud.yqbjgh.services.VCampLocationService
import gtcloud.yqbjgh.services.VUseCampLocationService
import org.geotools.geojson.geom.GeometryJSON
import org.locationtech.jts.geom.Polygon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CampLocationController {

    @Autowired
    VCampLocationService vCampLocationService

    @Autowired
    VUseCampLocationService vUseCampLocationService

    @GetMapping(value = "/v-camp-location/managed-camp/{bdnm}")
    RestResult<VCampLocationDTO> getVCampLocationForManagedCampByBdnm(@PathVariable String bdnm) {
        RestResult<VCampLocationDTO> restResult = new RestResult<>()
        List<VCampLocationDTO> results = vCampLocationService.getVManagedCampLocationsByBdnm(bdnm)
        restResult.setEndpoint("/v-camp-location/managed-camp/" + bdnm)
        restResult.setCampLocations(results)
        return restResult
    }

    @GetMapping(value = "/v-camp-location/using-camp/{bdnm}")
    RestResult<VUseCampLocationDTO> getVCampLocationForUsingCampByBdnm(@PathVariable String bdnm) {
        RestResult<VUseCampLocationDTO> restResult = new RestResult<>()
        List<VUseCampLocationDTO> results = vUseCampLocationService.getVUsingCampCampLocationByBdnm(bdnm)
        restResult.setEndpoint("/v-camp-location/using-camp/" + bdnm)
        restResult.setCampLocations(results)
        return restResult
    }

    @GetMapping(value = "/v-camp-location/dknm/{dknm}")
    VCampLocation getVCampLocationByDknm(@PathVariable String dknm) {
        return vCampLocationService.getByDknm(dknm)
    }

    @PostMapping(value = "/v-camp-location/customquery")
    RestResult<VCampLocationDTO> queryVCampLocationByCustomFields(
            @RequestBody CustomFields customFields) {
        RestResult<VCampLocationDTO> restResult = new RestResult<>()
        List<VCampLocationDTO> results = vCampLocationService.queryVCampLocationByCustomFields(customFields)
        final String endpoint = "/v-camp-location/customquery"
        restResult.setEndpoint(endpoint)
        restResult.setCampLocations(results)
        return restResult
    }

    @PostMapping(value = "/v-camp-location/polygonquery")
    RestResult<VCampLocationDTO> queryCampLocationByPolygon(@RequestBody String json) {
        RestResult<VCampLocationDTO> restResult = new RestResult<>()
        try {
            GeometryJSON gtjson = new GeometryJSON()
            Polygon polygon = gtjson.readPolygon(new StringReader(json))
            List<VCampLocationDTO> results = vCampLocationService.queryCampLocationByPolygon(polygon)
            final String endpoint = "/v-camp-location/polygonquery?" + json
            restResult.setEndpoint(endpoint)
            restResult.setCampLocations(results)
        } catch (IOException e) {
            e.printStackTrace()
        }
        return restResult
    }

    @GetMapping(value = "/v-camp-location/circlequery")
    RestResult<VCampLocationDTO> queryCampLocationByCircle(
            @RequestParam Double lat,
            @RequestParam Double lng,
            @RequestParam Double radius) {
        RestResult<VCampLocationDTO> restResult = new RestResult<>()
        List<VCampLocationDTO> results = vCampLocationService.queryCampLocationByCircle(lat, lng, radius)
        final String endpoint =
                String.format("/v-camp-location/circlequery?lat=%s&lng=%s&radius=%s", lat, lng, radius)
        restResult.setEndpoint(endpoint)
        restResult.setCampLocations(results)
        return restResult
    }
}
