package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampWarehouse
import org.springframework.data.jpa.repository.JpaRepository

interface CampWarehouseRepository extends JpaRepository<CampWarehouse, String> {

    List<CampWarehouse> findByCampId(String campId)
}
