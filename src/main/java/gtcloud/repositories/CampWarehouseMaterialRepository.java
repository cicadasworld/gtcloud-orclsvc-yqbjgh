package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampWarehouseMaterial;

public interface CampWarehouseMaterialRepository extends JpaRepository<CampWarehouseMaterial, String> {

	List<CampWarehouseMaterial> findByWarehouseId(String warehouseId);
}
