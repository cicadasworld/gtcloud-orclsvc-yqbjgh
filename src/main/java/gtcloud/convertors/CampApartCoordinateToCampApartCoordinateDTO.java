package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.CampApartBuilding;
import gtcloud.domain.CampApartCoordinate;
import gtcloud.model.CampApartCoordinateDTO;
import gtcloud.services.CampApartBuildingService;

@Component
public class CampApartCoordinateToCampApartCoordinateDTO implements Converter<CampApartCoordinate, CampApartCoordinateDTO> {

	@Autowired
	private CampApartBuildingService service;

	@Override
	public CampApartCoordinateDTO convert(CampApartCoordinate source) {
		CampApartCoordinateDTO target = new CampApartCoordinateDTO();
		target.setApartId(source.getApartId());
		target.setCoordinateNum(String.valueOf(source.getCoordinateNum()));
		target.setCoorHeigh(source.getCoorHeigh());
		target.setCoorLength(source.getCoorLength());
		target.setCoorX(source.getCoorX());
		target.setCoorY(source.getCoorY());
		target.setJlbm(source.getJlbm());
		target.setSjcjry(source.getSjcjry());
		target.setSjcjsj(source.getSjcjsj());

		CampApartBuilding campApartBuilding = service.getById(source.getApartId());
		if (campApartBuilding != null) {
			target.setApartName(campApartBuilding.getApartName());
		}

		return target;
	}

}
