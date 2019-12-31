package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampBatgroundFacilities;

public interface CampBatgroundFacilitiesRepository extends JpaRepository<CampBatgroundFacilities, String> {

	List<CampBatgroundFacilities> findByCampId(String campId);
}
