package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampLocation
import gtcloud.yqbjgh.domain.TxzyTsZbgc
import gtcloud.yqbjgh.domain.dic.CampDicCampKind
import gtcloud.yqbjgh.model.CampLocationDTO
import gtcloud.yqbjgh.repositories.TxzyTsZbgcRepository
import gtcloud.yqbjgh.repositories.dic.CampDicCampKindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampLocationToCampLocationDTO implements Converter<CampLocation, CampLocationDTO> {

	@Autowired
	private CampDicCampKindRepository campDicCampKindRepository

	@Autowired
	private TxzyTsZbgcRepository txzyTsZbgcRepository

	@Override
	CampLocationDTO convert(CampLocation source) {
		CampLocationDTO target = new CampLocationDTO()
		target.jlbm = source.jlbm
		target.nm = source.nm
		target.campWord = source.campWord
		target.campCode = source.campCode
		target.campKind = source.campKind
		target.adminDivision = source.adminDivision
		target.detailAddress = source.detailAddress
		target.campArea = source.campArea
		target.siteKind = source.siteKind
		target.watersupplyMode = source.watersupplyMode
		target.elecsupplyMode = source.elecsupplyMode
		target.gassupplyMode = source.gassupplyMode
		target.heatsupplyMode = source.heatsupplyMode
		target.sjcjry = source.sjcjry
		target.sjcjsj = source.sjcjsj

        Optional<CampDicCampKind> optionalCampDicCampKind =
                campDicCampKindRepository.findById(source.campKind)
        optionalCampDicCampKind.ifPresent{campDicCampKind -> target.campKind = campDicCampKind.mc}

        Optional<TxzyTsZbgc> optionalTxzyTsZbgc = txzyTsZbgcRepository.findById(source.nm)
        optionalTxzyTsZbgc.ifPresent{txzyTsZbgc -> target.mc = txzyTsZbgc.mc}

		return target
	}

}
