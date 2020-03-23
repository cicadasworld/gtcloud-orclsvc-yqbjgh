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
    CampDicMaterialKindRepository campDicMaterialKindRepository

    @Autowired
    CampDicDangerousAttrRepository campDicDangerousAttrRepository

    @Override
    CampWarehouseMaterialDTO convert(CampWarehouseMaterial source) {
        CampWarehouseMaterialDTO target = new CampWarehouseMaterialDTO()
        target.jlbm = source.jlbm
        target.warArea = source.warArea

        // materialKind -> materialKindÃû³Æ
        String materialKind = source.materialKind
        Optional<CampDicMaterialKind> optMaterialKind =
                campDicMaterialKindRepository.findById(materialKind ?: "")
        optMaterialKind.ifPresent { dic -> target.materialKind = dic.mc }

        // dangerousAttr -> dangerousAttrÃû³Æ
        String dangerousAttr = source.dangerousAttr
        Optional<CampDicDangerousAttr> optDangerousAttr =
                campDicDangerousAttrRepository.findById(dangerousAttr ?: "")
        optDangerousAttr.ifPresent { dic -> target.dangerousAttr = dic.mc }

        target.warehouseId = source.warehouseId
        target.ccwzsl = source.ccwzsl
        target.sjcjsj = source.sjcjsj
        target.sjcjry = source.sjcjry
        target.campId = source.campId
        return target
    }

}
