package gtcloud.yqbjgh.converters

import com.fasterxml.jackson.databind.ObjectMapper
import gtcloud.yqbjgh.domain.CampCoordinate
import gtcloud.yqbjgh.domain.VApartCoordinateJson
import gtcloud.yqbjgh.domain.VUseCampLocation
import gtcloud.yqbjgh.model.ApartInfo
import gtcloud.yqbjgh.model.VUseCampLocationDTO
import gtcloud.yqbjgh.repositories.CampCoordinateRepository
import gtcloud.yqbjgh.repositories.VApartCoordinateJsonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

import static java.util.stream.Collectors.toList

@Component
class VUseCampLocationToVUseCampLocationDTO implements Converter<VUseCampLocation, VUseCampLocationDTO> {

    @Autowired
    CampCoordinateRepository campCoordinateRepository

    @Autowired
    VApartCoordinateJsonRepository vApartCoordinateJsonRepository

    @Autowired
    ObjectMapper objectMapper

    @Override
    VUseCampLocationDTO convert(VUseCampLocation source) {
        final String dknm = source.dknm
        final String bdnm = source.bdnm
        VUseCampLocationDTO target = new VUseCampLocationDTO()
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
        final List<CampCoordinate> campCoordinates = campCoordinateRepository
                .findByFid(dknm, Sort.by("coordinateNum"))
        if (campCoordinates.size() > 0) {
            final CampCoordinate campCoordinate = campCoordinates.get(0)
            target.centerX = campCoordinate.centerX
            target.centerY = campCoordinate.centerY
        }

        List<VApartCoordinateJson> vApartCoordinateJsons = vApartCoordinateJsonRepository.findByCampId(dknm)
        List<ApartInfo> aparts = vApartCoordinateJsons.stream()
                .map { vApartCoordinateJson ->
            deserializeApart(vApartCoordinateJson)
        }.collect(toList())
        target.aparts = aparts

        target.lineColor = source.lineColor
        target.fillColor = source.fillColor
        target.fillOpacity = source.fillOpacity

        target.useBdnm = source.useBdnm
        target.useBdmc = source.useBdmc
        target.realorvirtual = source.realorvirtual

        return target
    }

    ApartInfo deserializeApart(VApartCoordinateJson vApartCoordinateJson) {
        String apartInfo = vApartCoordinateJson.apartInfo
        ApartInfo apart = objectMapper.readValue(apartInfo, ApartInfo)
        return apart
    }
}
