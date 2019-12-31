package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.CampApartBuilding;
import gtcloud.domain.CampStaffHousing;
import gtcloud.model.CampStaffHousingDTO;
import gtcloud.services.CampApartBuildingService;

@Component
public class CampStaffHousingToCampStaffHousingDTO implements Converter<CampStaffHousing, CampStaffHousingDTO> {

	@Autowired
	private CampApartBuildingService service;

	@Override
	public CampStaffHousingDTO convert(CampStaffHousing source) {
		CampStaffHousingDTO target = new CampStaffHousingDTO();
		target.setApartId(source.getApartId());
		target.setCampId(source.getCampId());
		target.setCellNum(source.getCellNum());
		target.setHouseKind(source.getHouseKind());
		target.setHouseNum(source.getHouseNum());
		target.setHouseStandardArea(source.getHouseStandardArea());
		target.setHouseStandardGrade(source.getHouseStandardGrade());
		target.setJlbm(source.getJlbm());
		target.setMobilePhone(source.getMobilePhone());
		target.setSjcjry(source.getSjcjry());
		target.setSjcjsj(source.getSjcjsj());
		target.setStaffKind(source.getStaffKind());
		target.setStaffName(source.getStaffName());
		target.setUsualResidentNum(source.getUsualResidentNum());
		target.setWorkingUnit(source.getWorkingUnit());

		CampApartBuilding campApartBuilding = service.getById(source.getApartId());
		if (campApartBuilding != null) {
			target.setApartName(campApartBuilding.getApartName());
		}

		return target;
	}

}
