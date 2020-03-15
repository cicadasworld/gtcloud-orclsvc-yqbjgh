package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampApartBuilding
import gtcloud.yqbjgh.domain.CampApartCoordinate
import gtcloud.yqbjgh.model.CampApartCoordinateDTO
import gtcloud.yqbjgh.repositories.CampApartBuildingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampApartCoordinateToCampApartCoordinateDTO implements Converter<CampApartCoordinate, CampApartCoordinateDTO> {

	@Autowired
	private CampApartBuildingRepository campApartBuildingRepository

	@Override
	CampApartCoordinateDTO convert(CampApartCoordinate source) {
		CampApartCoordinateDTO target = new CampApartCoordinateDTO()
		target.apartId = source.apartId
		target.coordinateNum = String.valueOf(source.coordinateNum)
		target.coorHeigh = source.coorHeigh
		target.coorLength = source.coorLength
		target.coorX = source.coorX
		target.coorY = source.coorY
		target.jlbm = source.jlbm
		target.sjcjry = source.sjcjry
		target.sjcjsj = source.sjcjsj
        Optional<CampApartBuilding> optionalCampApartBuilding =
                campApartBuildingRepository.findById(source.apartId)
        optionalCampApartBuilding.ifPresent{campApartBuilding ->
                target.apartName = campApartBuilding.apartName}
		return target
	}

}
