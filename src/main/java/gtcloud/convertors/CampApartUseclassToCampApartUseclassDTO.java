package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.CampApartBuilding;
import gtcloud.domain.CampApartUseclass;
import gtcloud.model.CampApartUseclassDTO;
import gtcloud.services.CampApartBuildingService;

@Component
public class CampApartUseclassToCampApartUseclassDTO implements Converter<CampApartUseclass, CampApartUseclassDTO> {

	@Autowired
	private CampApartBuildingService service;

	@Override
	public CampApartUseclassDTO convert(CampApartUseclass source) {
		CampApartUseclassDTO target = new CampApartUseclassDTO();
		target.setApartId(source.getApartId());
		target.setBarrackUseArea(source.getBarrackUseArea());
		target.setBarrackUseClass(source.getBarrackUseClass());
		target.setBarrackUseUnit(source.getBarrackUseUnit());
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
