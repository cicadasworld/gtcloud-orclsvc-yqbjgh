package gtcloud.convertors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.CampWarehouseMaterial;
import gtcloud.model.CampWarehouseMaterialDTO;

@Component
public class CampWarehouseMaterialToCampWarehouseMaterialDTO implements Converter<CampWarehouseMaterial, CampWarehouseMaterialDTO> {

//	@Autowired
//	private CampApartBuildingService service;

	@Override
	public CampWarehouseMaterialDTO convert(CampWarehouseMaterial source) {
		CampWarehouseMaterialDTO target = new CampWarehouseMaterialDTO();
		target.setJlbm(source.getJlbm());
		target.setWarArea(source.getWarArea());
		target.setMaterialKind(source.getMaterialKind());
		target.setDangerousAttr(source.getDangerousAttr());
		target.setWarehouseId(source.getWarehouseId());
		target.setCcwzsl(source.getCcwzsl());
		target.setSjcjsj(source.getSjcjsj());
		target.setSjcjry(source.getSjcjry());

//		CampApartBuilding campApartBuilding = service.getById(source.getApartId());
//		if (campApartBuilding != null) {
//			target.setApartName(campApartBuilding.getApartName());
//		}

		return target;
	}

}
