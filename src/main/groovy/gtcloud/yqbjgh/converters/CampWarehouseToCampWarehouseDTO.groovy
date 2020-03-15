package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampWarehouse
import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.domain.dic.CampDicWarKind
import gtcloud.yqbjgh.model.CampWarehouseDTO
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import gtcloud.yqbjgh.repositories.dic.CampDicWarKindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampWarehouseToCampWarehouseDTO implements Converter<CampWarehouse, CampWarehouseDTO> {

	@Autowired
    private CampDicWarKindRepository campDicWarKindRepository

    @Autowired
    private TxzhTsBddwmlRepository txzhTsBddwmlRepository

	@Override
	CampWarehouseDTO convert(CampWarehouse source) {
		CampWarehouseDTO target = new CampWarehouseDTO()
		target.jlbm = source.jlbm
		target.apartId = source.apartId

        Optional<CampDicWarKind> optionalCampDicWarKind =
                campDicWarKindRepository.findById(source.warKind)
        optionalCampDicWarKind.ifPresent{campDicWarKind ->
                target.warKind = campDicWarKind.mc}

		target.warName = source.warName
		target.campId = source.campId

        Optional<TxzhTsBddwml> optionalTxzhtsBddwml =
                txzhTsBddwmlRepository.findById(source.managementUnit)
        optionalTxzhtsBddwml.ifPresent{txzhTsBddwml ->
                target.managementUnit = txzhTsBddwml.mc}

		target.sjcjry = source.sjcjry
		target.sjcjsj = source.sjcjsj

		return target
	}

}
