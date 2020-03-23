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
    CampDicTrafieldKindRepository campDicTrafieldKindRepository

    @Autowired
    CampDicTraUsingConditionRepository campDicTraUsingConditionRepository

    @Autowired
    TxzhTsBddwmlRepository txzhTsBddwmlRepository

    @Override
    CampTrainingFieldDTO convert(CampTrainingField source) {
        CampTrainingFieldDTO target = new CampTrainingFieldDTO()
        target.campId = source.campId
        target.jlbm = source.jlbm

        // managementUnit -> bdÃû³Æ
        String managementUnit = source.managementUnit
        Optional<TxzhTsBddwml> optTxzhTsBddwml = txzhTsBddwmlRepository.findById(managementUnit ?: "")
        optTxzhTsBddwml.ifPresent { txzhTsBddwml ->
            target.managementUnit = txzhTsBddwml.mc
        }

        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj
        target.traArea = source.traArea

        // traKind -> traKindÃû³Æ
        String traKind = source.traKind
        Optional<CampDicTrafieldKind> optTrafieldKind = campDicTrafieldKindRepository.findById(traKind ?: "")
        optTrafieldKind.ifPresent { dic -> target.traKind = dic.mc }

        target.traName = source.traName

        // traUsingCondition -> traUsingConditionÃû³Æ
        String traUsingCondition = source.traUsingCondition
        Optional<CampDicTraUsingCondition> optTraUsingCondition =
                campDicTraUsingConditionRepository.findById(traUsingCondition ?: "")
        optTraUsingCondition.ifPresent { dic -> target.traUsingCondition = dic.mc }

        return target
    }

}
