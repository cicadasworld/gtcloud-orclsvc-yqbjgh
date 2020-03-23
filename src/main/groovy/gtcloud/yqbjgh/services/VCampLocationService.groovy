package gtcloud.yqbjgh.services

import gtcloud.yqbjgh.domain.VCampLocation
import gtcloud.yqbjgh.model.CustomFields
import gtcloud.yqbjgh.model.VCampLocationDTO
import org.locationtech.jts.geom.Polygon

interface VCampLocationService {

    List<VCampLocationDTO> queryVCampLocationByCustomFields(CustomFields customFields)

    VCampLocation getByDknm(String dknm)

    List<VCampLocationDTO> getVManagedCampLocationsByBdnm(String id)

    List<VCampLocationDTO> queryCampLocationByPolygon(Polygon polygon)

    List<VCampLocationDTO> queryCampLocationByCircle(Double lat, Double lng, Double radius)
}
