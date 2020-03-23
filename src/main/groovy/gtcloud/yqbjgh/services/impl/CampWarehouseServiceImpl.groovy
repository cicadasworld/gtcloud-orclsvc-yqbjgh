package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampWarehouseToCampWarehouseDTO
import gtcloud.yqbjgh.domain.CampWarehouse
import gtcloud.yqbjgh.model.CampWarehouseDTO
import gtcloud.yqbjgh.repositories.CampWarehouseRepository
import gtcloud.yqbjgh.services.CampWarehouseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampWarehouseServiceImpl implements CampWarehouseService {

    @Autowired
    CampWarehouseRepository repository

    @Autowired
    CampWarehouseToCampWarehouseDTO converter

    @Override
    List<CampWarehouseDTO> getCampWarehouse(String campId) {
        List<CampWarehouse> campWarehouses = repository.findByCampId(campId)
        return campWarehouses.stream().
                map { campWarehouse -> converter.convert(campWarehouse) }.
                collect(toList())
    }
}
