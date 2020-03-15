package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampCoordinate
import gtcloud.yqbjgh.model.CampCoordinateDTO
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampCoordinateToCampCoordinateDTO implements Converter<CampCoordinate, CampCoordinateDTO> {

	@Override
	CampCoordinateDTO convert(CampCoordinate source) {
		CampCoordinateDTO target = new CampCoordinateDTO()
		target.jlbm = source.jlbm
		target.fid = source.fid
		target.coordinateNum = String.valueOf(source.coordinateNum)
		target.coorX = source.coorX
		target.coorY = source.coorY
		target.centerX = source.centerX
		target.centerY = source.centerY

		return target
	}
}
