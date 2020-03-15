package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampWarehouseMaterial
import org.springframework.data.jpa.repository.JpaRepository

interface CampWarehouseMaterialRepository extends JpaRepository<CampWarehouseMaterial, String> {

	List<CampWarehouseMaterial> findByWarehouseId(String warehouseId)
}
