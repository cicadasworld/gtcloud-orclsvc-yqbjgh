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
    CampDicBatKindRepository campDicBatKindRepository

    @Autowired
    TxzhTsBddwmlRepository txzhTsBddwmlRepository

    @Override
    CampBatgroundFacilitiesDTO convert(CampBatgroundFacilities source) {
        CampBatgroundFacilitiesDTO target = new CampBatgroundFacilitiesDTO()
        target.batArea = source.batArea
        target.batFunction = source.batFunction

        // batKind -> batKindÃû³Æ
        String batKind = source.batKind
        Optional<CampDicBatKind> optCampDicBatKind = campDicBatKindRepository.findById(batKind ?: "")
        optCampDicBatKind.ifPresent { dic -> target.batKind = dic.mc }

        target.batName = source.batName
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
        return target
    }

}
