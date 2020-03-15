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
    private CampWarehouseRepository repository

    @Autowired
    private CampWarehouseToCampWarehouseDTO converter

    @Override
    List<CampWarehouseDTO> getCampWarehouse(String campId) {
        List<CampWarehouse> campWarehouses = this.getByCampId(campId)
        return campWarehouses.stream()
                .map{campWarehouse -> converter.convert(campWarehouse)}
                .collect(toList())
    }

    List<CampWarehouse> getByCampId(String campId) {
        return repository.findByCampId(campId)
    }
}
