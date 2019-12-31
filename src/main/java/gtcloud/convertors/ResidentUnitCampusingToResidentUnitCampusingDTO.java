package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.ResidentUnitCampusing;
import gtcloud.domain.TxzhTsBddwml;
import gtcloud.model.ResidentUnitCampusingDTO;
import gtcloud.services.TxzhTsBddwmlService;

@Component
public class ResidentUnitCampusingToResidentUnitCampusingDTO implements Converter<ResidentUnitCampusing, ResidentUnitCampusingDTO> {

	@Autowired
	private TxzhTsBddwmlService service;

	@Override
	public ResidentUnitCampusingDTO convert(ResidentUnitCampusing source) {
		ResidentUnitCampusingDTO target = new ResidentUnitCampusingDTO();
		target.setBdnm(source.getBdnm());
		target.setCampId(source.getCampId());
		target.setJlbm(source.getJlbm());
		target.setRemarks(source.getRemarks());
		target.setSjcjry(source.getSjcjry());
		target.setSjcjsj(source.getSjcjsj());

		TxzhTsBddwml txzhTsBddwml = service.getById(source.getBdnm());
		if (txzhTsBddwml != null) {
			target.setMc(txzhTsBddwml.getMc()); // 增加单位名称
		}

		return target;
	}

}
