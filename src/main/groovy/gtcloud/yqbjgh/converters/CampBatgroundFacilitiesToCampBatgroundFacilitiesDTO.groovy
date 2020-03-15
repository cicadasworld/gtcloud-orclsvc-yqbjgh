package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampBatgroundFacilities
import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.domain.dic.CampDicBatKind
import gtcloud.yqbjgh.model.CampBatgroundFacilitiesDTO
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import gtcloud.yqbjgh.repositories.dic.CampDicBatKindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampBatgroundFacilitiesToCampBatgroundFacilitiesDTO implements Converter<CampBatgroundFacilities, CampBatgroundFacilitiesDTO> {

	@Autowired
    private CampDicBatKindRepository campDicBatKindRepository

	@Autowired
    private TxzhTsBddwmlRepository txzhTsBddwmlRepository

	@Override
	CampBatgroundFacilitiesDTO convert(CampBatgroundFacilities source) {
        CampBatgroundFacilitiesDTO target = new CampBatgroundFacilitiesDTO()
        target.batArea = source.batArea
        target.batFunction = source.batFunction

        Optional<CampDicBatKind> optionalCampDicBatKind =
                campDicBatKindRepository.findById(source.batKind)
        optionalCampDicBatKind.ifPresent{campDicBatKind ->
                target.batKind = campDicBatKind.mc}

        target.batName = source.batName
        target.campId = source.campId
        target.jlbm = source.jlbm

        Optional<TxzhTsBddwml> optionalTxzhTsBddwml =
                txzhTsBddwmlRepository.findById(source.managementUnit)
        optionalTxzhTsBddwml.ifPresent{txzhTsBddwml ->
                target.managementUnit = txzhTsBddwml.mc}

        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj
		return target
	}

}
