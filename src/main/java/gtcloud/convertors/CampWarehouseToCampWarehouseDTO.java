package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.CampApartBuilding;
import gtcloud.domain.CampWarehouse;
import gtcloud.model.CampWarehouseDTO;
import gtcloud.services.CampApartBuildingService;

@Component
public class CampWarehouseToCampWarehouseDTO implements Converter<CampWarehouse, CampWarehouseDTO> {

	@Autowired
	private CampApartBuildingService service;

	@Override
	public CampWarehouseDTO convert(CampWarehouse source) {
		CampWarehouseDTO target = new CampWarehouseDTO();
		target.setJlbm(source.getJlbm());
		target.setApartId(source.getApartId());
		target.setWarKind(source.getWarKind());
		target.setWarName(source.getWarName());
		target.setCampId(source.getCampId());
		target.setManagementUnit(source.getManagementUnit());
		target.setSjcjry(source.getSjcjry());
		target.setSjcjsj(source.getSjcjsj());

		CampApartBuilding campApartBuilding = service.getById(source.getApartId());
		if (campApartBuilding != null) {
			target.setApartName(campApartBuilding.getApartName());
		}

		return target;
	}

}
