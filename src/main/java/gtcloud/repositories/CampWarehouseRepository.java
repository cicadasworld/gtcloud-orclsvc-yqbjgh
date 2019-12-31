package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampWarehouse;

public interface CampWarehouseRepository extends JpaRepository<CampWarehouse, String> {

	List<CampWarehouse> findByCampId(String campId);
}
