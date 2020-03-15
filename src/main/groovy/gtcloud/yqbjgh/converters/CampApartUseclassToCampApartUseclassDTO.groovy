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
	private CampApartBuildingRepository campApartBuildingRepository

    @Autowired
    private CampDicBarrackUseClassRepository campDicBarrackUseClassRepository

    @Autowired
    private TxzhTsBddwmlRepository txzhTsBddwmlRepository

	@Override
	CampApartUseclassDTO convert(CampApartUseclass source) {
		CampApartUseclassDTO target = new CampApartUseclassDTO()
		target.apartId = source.apartId
		target.barrackUseArea = source.barrackUseArea

        Optional<CampDicBarrackUseClass> optionalCampDicBarrackUseClass =
                campDicBarrackUseClassRepository.findById(source.barrackUseClass)
        optionalCampDicBarrackUseClass.ifPresent{campDicBarrackUseClass ->
                    target.barrackUseClass = campDicBarrackUseClass.mc}

        Optional<TxzhTsBddwml> optionalTxzhTsBddwml =
                txzhTsBddwmlRepository.findById(source.barrackUseUnit)
        optionalTxzhTsBddwml.ifPresent{txzhTsBddwml ->
                target.barrackUseUnit = txzhTsBddwml.mc}  // barrackUseUnit -> bdnm

		target.jlbm = source.jlbm
		target.sjcjry = source.sjcjry
		target.sjcjsj = source.sjcjsj

        Optional<CampApartBuilding> optionalCampApartBuilding =
                campApartBuildingRepository.findById(source.apartId)
        optionalCampApartBuilding.ifPresent{campApartBuilding ->
                    target.apartName = campApartBuilding.apartName}
		return target
	}

}
