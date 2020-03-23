package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampApartBuilding
import gtcloud.yqbjgh.domain.CampApartUseclass
import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.domain.dic.CampDicBarrackUseClass
import gtcloud.yqbjgh.model.CampApartUseclassDTO
import gtcloud.yqbjgh.repositories.CampApartBuildingRepository
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import gtcloud.yqbjgh.repositories.dic.CampDicBarrackUseClassRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampApartUseclassToCampApartUseclassDTO implements Converter<CampApartUseclass, CampApartUseclassDTO> {

    @Autowired
    CampApartBuildingRepository campApartBuildingRepository

    @Autowired
    CampDicBarrackUseClassRepository campDicBarrackUseClassRepository

    @Autowired
    TxzhTsBddwmlRepository txzhTsBddwmlRepository

    @Override
    CampApartUseclassDTO convert(CampApartUseclass source) {
        CampApartUseclassDTO target = new CampApartUseclassDTO()
        target.apartId = source.apartId
        target.barrackUseArea = source.barrackUseArea

        // barrackUseClass -> barrackUseClassÃû³Æ
        String barrackUseClass = source.barrackUseClass
        Optional<CampDicBarrackUseClass> optBarrackUseClass =
                campDicBarrackUseClassRepository.findById(barrackUseClass ?: "")
        optBarrackUseClass.ifPresent { dic -> target.barrackUseClass = dic.mc }

        // barrackUseUnit -> bdÃû³Æ
        String barrackUseUnit = source.barrackUseUnit
        Optional<TxzhTsBddwml> optTxzhTsBddwml =
                txzhTsBddwmlRepository.findById(barrackUseUnit ?: "")
        optTxzhTsBddwml.ifPresent { txzhTsBddwml ->
            target.barrackUseUnit = txzhTsBddwml.mc
        }

        target.jlbm = source.jlbm
        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj

        // apartId -> apartName
        String apartId = source.apartId
        Optional<CampApartBuilding> optCampApartBuilding =
                campApartBuildingRepository.findById(apartId ?: "")
        optCampApartBuilding.ifPresent { campApartBuilding ->
            target.apartName = campApartBuilding.apartName
        }

        return target
    }

}
