package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.ResidentStaffCondition;
import gtcloud.domain.dic.ResidentDicStaffKind;
import gtcloud.model.ResidentStaffConditionDTO;
import gtcloud.services.dic.ResidentDicStaffKindService;

@Component
public class ResidentStaffConditionToResidentStaffConditionDTO implements Converter<ResidentStaffCondition, ResidentStaffConditionDTO> {

	@Autowired
	private ResidentDicStaffKindService service;

	@Override
	public ResidentStaffConditionDTO convert(ResidentStaffCondition source) {
		ResidentStaffConditionDTO target = new ResidentStaffConditionDTO();
		target.setBdnm(source.getBdnm());
		target.setCompileNum(source.getCompileNum());
		target.setJlbm(source.getJlbm());
		target.setRealityNum(source.getRealityNum());
		target.setSjcjry(source.getSjcjry());
		target.setSjcjsj(source.getSjcjsj());

		ResidentDicStaffKind staffKind = service.getById(source.getStaffKind());
		target.setStaffKind(staffKind.getMc());

		return target;
	}

}
