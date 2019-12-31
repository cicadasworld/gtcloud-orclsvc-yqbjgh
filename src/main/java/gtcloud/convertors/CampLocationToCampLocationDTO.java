package gtcloud.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.CampLocation;
import gtcloud.domain.TxzyTsZbgc;
import gtcloud.domain.dic.CampDicCampKind;
import gtcloud.model.CampLocationDTO;
import gtcloud.services.TxzyTsZbgcService;
import gtcloud.services.dic.CampDicCampKindService;

@Component
public class CampLocationToCampLocationDTO implements Converter<CampLocation, CampLocationDTO> {

	@Autowired
	private CampDicCampKindService campKindSvc;

	@Autowired
	private TxzyTsZbgcService txzyTsZbgcSvc;

	@Override
	public CampLocationDTO convert(CampLocation source) {
		CampLocationDTO target = new CampLocationDTO();
		target.setJlbm(source.getJlbm());
		target.setNm(source.getNm());
		target.setCampWord(source.getCampWord());
		target.setCampCode(source.getCampCode());
		target.setCampKind(source.getCampKind());
		target.setAdminDivision(source.getAdminDivision());
		target.setDetailAddress(source.getDetailAddress());
		target.setCampArea(source.getCampArea());
		target.setSiteKind(source.getSiteKind());
		target.setWatersupplyMode(source.getWatersupplyMode());
		target.setElecsupplyMode(source.getElecsupplyMode());
		target.setGassupplyMode(source.getGassupplyMode());
		target.setHeatsupplyMode(source.getHeatsupplyMode());
		target.setSjcjry(source.getSjcjry());
		target.setSjcjsj(source.getSjcjsj());

		CampDicCampKind campKind = campKindSvc.getById(source.getCampKind());
		if (campKind != null) {
			target.setCampKind(campKind.getMc());
		}

		TxzyTsZbgc txzyTsZbgc = txzyTsZbgcSvc.getById(source.getNm());
		if (txzyTsZbgc != null) {
			target.setMc(txzyTsZbgc.getMc());
		}

		return target;
	}

}
