package gtcloud.yqbjgh.converters

import com.fasterxml.jackson.databind.ObjectMapper
import gtcloud.yqbjgh.domain.VApartCoordinateJson
import gtcloud.yqbjgh.domain.VCampLocation
import gtcloud.yqbjgh.model.ApartInfo
import gtcloud.yqbjgh.model.VCampLocationDTO
import gtcloud.yqbjgh.repositories.VApartCoordinateJsonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

import static java.util.stream.Collectors.toList

@Component
class VCampLocationToVCampLocationDTO implements Converter<VCampLocation, VCampLocationDTO> {

    @Autowired
    VApartCoordinateJsonRepository vApartCoordinateJsonRepository

    @Autowired
    ObjectMapper objectMapper

    @Override
    VCampLocationDTO convert(VCampLocation source) {
        final String dknm = source.getDknm()
        final String bdnm = source.getBdnm()
        VCampLocationDTO target = new VCampLocationDTO()
        target.adminDivision = source.adminDivision
        target.bdnm = bdnm
        target.bdmc = source.bdmc
        target.jlbm = source.jlbm
        target.campArea = source.campArea
        target.campCode = source.campCode
        target.campKind = source.campKind
        target.campWord = source.campWord
        target.detailAddress = source.detailAddress
        target.dkmc = source.dkmc
        target.dknm = dknm
        target.elecsupplyMode = source.elecsupplyMode
        target.gassupplyMode = source.gassupplyMode
        target.heatsupplyMode = source.heatsupplyMode
        target.watersupplyMode = source.watersupplyMode
        target.siteKind = source.siteKind

        List<VApartCoordinateJson> vApartCoordinateJsons = vApartCoordinateJsonRepository.findByCampId(dknm)
        List<ApartInfo> aparts = vApartCoordinateJsons.stream().map { vApartCoordinateJson ->
            deserializeApart(vApartCoordinateJson)
        }.collect(toList())
        target.aparts = aparts

        target.lineColor = source.lineColor
        target.fillColor = source.fillColor
        target.fillOpacity = source.fillOpacity
        target.realorvirtual = source.realorvirtual

        return target
    }

    ApartInfo deserializeApart(VApartCoordinateJson vApartCoordinateJson) {
        String apartInfo = vApartCoordinateJson.getApartInfo()
        ApartInfo apart = objectMapper.readValue(apartInfo, ApartInfo)
        return apart
    }
}
