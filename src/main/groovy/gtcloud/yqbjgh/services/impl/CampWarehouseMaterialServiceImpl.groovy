package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampWarehouseMaterialToCampWarehouseMaterialDTO
import gtcloud.yqbjgh.domain.CampWarehouseMaterial
import gtcloud.yqbjgh.model.CampWarehouseMaterialDTO
import gtcloud.yqbjgh.repositories.CampWarehouseMaterialRepository
import gtcloud.yqbjgh.services.CampWarehouseMaterialService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampWarehouseMaterialServiceImpl implements CampWarehouseMaterialService {

    @Autowired
    CampWarehouseMaterialRepository repository

    @Autowired
    CampWarehouseMaterialToCampWarehouseMaterialDTO converter

    @Override
    CampWarehouseMaterial getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampWarehouseMaterialDTO> getCampWarehouseMaterial(String warehouseId) {
        List<CampWarehouseMaterial> campWarehouseMaterials = repository.findByWarehouseId(warehouseId)
        return campWarehouseMaterials.stream().
                map { campWarehouseMaterial -> converter.convert(campWarehouseMaterial) }.
                collect(toList())
    }
}
