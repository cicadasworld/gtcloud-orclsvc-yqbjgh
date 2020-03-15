package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampTrainingField
import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.domain.dic.CampDicTraUsingCondition
import gtcloud.yqbjgh.domain.dic.CampDicTrafieldKind
import gtcloud.yqbjgh.model.CampTrainingFieldDTO
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import gtcloud.yqbjgh.repositories.dic.CampDicTraUsingConditionRepository
import gtcloud.yqbjgh.repositories.dic.CampDicTrafieldKindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampTrainingFieldToCampTrainingFieldDTO implements Converter<CampTrainingField, CampTrainingFieldDTO> {

	@Autowired
	private CampDicTrafieldKindRepository campDicTrafieldKindRepository

	@Autowired
    private CampDicTraUsingConditionRepository campDicTraUsingConditionRepository

    @Autowired
    private TxzhTsBddwmlRepository txzhTsBddwmlRepository

	@Override
	CampTrainingFieldDTO convert(CampTrainingField source) {
        CampTrainingFieldDTO target = new CampTrainingFieldDTO()
        target.campId = source.campId
        target.jlbm = source.jlbm

        Optional<TxzhTsBddwml> optionalTxzhTsBddwml =
                txzhTsBddwmlRepository.findById(source.managementUnit)
        optionalTxzhTsBddwml.ifPresent{txzhTsBddwml ->
                target.managementUnit = txzhTsBddwml.mc}

        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj
        target.traArea = source.traArea

        Optional<CampDicTrafieldKind> optionalCampDicTrafieldKind =
                campDicTrafieldKindRepository.findById(source.traKind)
        optionalCampDicTrafieldKind.ifPresent{campDicTrafieldKind ->
                target.traKind = campDicTrafieldKind.mc}

        target.traName = source.traName

        Optional<CampDicTraUsingCondition> optionalCampDicTraUsingCondition =
                campDicTraUsingConditionRepository.findById(source.traUsingCondition)
        optionalCampDicTraUsingCondition.ifPresent{campDicTraUsingCondition ->
                target.traUsingCondition = campDicTraUsingCondition.mc}

		return target
	}

}
