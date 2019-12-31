package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.ResidentUnit;
import gtcloud.domain.TxzhTsBddwml;
import gtcloud.domain.dic.ResidentDicAdminDivision;
import gtcloud.domain.dic.ResidentDicUnitGrade;
import gtcloud.domain.dic.ResidentDicUnitKind;
import gtcloud.model.ResidentUnitDTO;
import gtcloud.services.TxzhTsBddwmlService;
import gtcloud.services.dic.ResidentDicAdminDivisionService;
import gtcloud.services.dic.ResidentDicUnitGradeService;
import gtcloud.services.dic.ResidentDicUnitKindService;

@Component
public class ResidentUnitToResidentUnitDTO implements Converter<ResidentUnit, ResidentUnitDTO> {

	@Autowired
	private TxzhTsBddwmlService txzhTsBddwmlSvc;

    @Autowired
    private ResidentDicUnitGradeService gradeSvc;

    @Autowired
    private ResidentDicAdminDivisionService adminDivisionSvc;

    @Autowired
    private ResidentDicUnitKindService unitKindSvc;

    @Override
    public ResidentUnitDTO convert(ResidentUnit source) {
        ResidentUnitDTO target = new ResidentUnitDTO();
        target.setBdnm(source.getBdnm());
        target.setDetailAddress(source.getDetailAddress());
        target.setJlbm(source.getJlbm());
        target.setMission(source.getMission());
        target.setSjcjry(source.getSjcjry());
        target.setSjcjsj(source.getSjcjsj());

        TxzhTsBddwml txzhTsBddwml = txzhTsBddwmlSvc.getById(source.getBdnm());
        if (txzhTsBddwml != null) {
        	target.setMc(txzhTsBddwml.getMc());
        }

        ResidentDicUnitGrade grade = gradeSvc.getById(source.getGrade());
        target.setGrade(grade.getMc());

        ResidentDicAdminDivision adminDivision = adminDivisionSvc.getById(source.getAdminDivision());
        target.setAdminDivision(adminDivision.getMc());

        ResidentDicUnitKind unitKind = unitKindSvc.getById(source.getUnitKind());
        target.setUnitKind(unitKind.getMc());

        return target;
    }

}
