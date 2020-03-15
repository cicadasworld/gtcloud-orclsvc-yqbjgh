package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampWarehouseMaterial
import gtcloud.yqbjgh.domain.dic.CampDicDangerousAttr
import gtcloud.yqbjgh.domain.dic.CampDicMaterialKind
import gtcloud.yqbjgh.model.CampWarehouseMaterialDTO
import gtcloud.yqbjgh.repositories.dic.CampDicDangerousAttrRepository
import gtcloud.yqbjgh.repositories.dic.CampDicMaterialKindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampWarehouseMaterialToCampWarehouseMaterialDTO implements Converter<CampWarehouseMaterial, CampWarehouseMaterialDTO> {

    @Autowired
    private CampDicMaterialKindRepository campDicMaterialKindRepository

    @Autowired
    private CampDicDangerousAttrRepository campDicDangerousAttrRepository

	@Override
	CampWarehouseMaterialDTO convert(CampWarehouseMaterial source) {
		CampWarehouseMaterialDTO target = new CampWarehouseMaterialDTO()
		target.jlbm = source.jlbm
		target.warArea = source.warArea

        Optional<CampDicMaterialKind> optionalCampDicMaterialKind =
                campDicMaterialKindRepository.findById(source.materialKind)
        optionalCampDicMaterialKind.ifPresent{campDicMaterialKind ->
                target.materialKind = campDicMaterialKind.mc}

        Optional<CampDicDangerousAttr> optionalCampDicDangerousAttr =
                campDicDangerousAttrRepository.findById(source.dangerousAttr)
        optionalCampDicDangerousAttr.ifPresent{campDicDangerousAttr ->
                target.dangerousAttr = campDicDangerousAttr.mc}

		target.warehouseId = source.warehouseId
		target.ccwzsl = source.ccwzsl
		target.sjcjsj = source.sjcjsj
		target.sjcjry = source.sjcjry
		target.campId = source.campId
		return target;
	}

}
