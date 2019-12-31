package gtcloud.convertors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.CampCoordinate;
import gtcloud.model.CampCoordinateDTO;

@Component
public class CampCoordinateToCampCoordinateDTO implements Converter<CampCoordinate, CampCoordinateDTO> {

	@Override
	public CampCoordinateDTO convert(CampCoordinate source) {
		CampCoordinateDTO target = new CampCoordinateDTO();
		target.setJlbm(source.getJlbm());
		target.setFid(source.getFid());
		target.setCoordinateNum(String.valueOf(source.getCoordinateNum()));
		target.setCoorX(source.getCoorX());
		target.setCoorY(source.getCoorY());
		target.setCenterX(source.getCenterX());
		target.setCenterY(source.getCenterY());

		return target;
	}
}
