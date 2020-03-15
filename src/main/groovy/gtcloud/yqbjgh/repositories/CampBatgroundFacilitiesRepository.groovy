package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampBatgroundFacilities
import org.springframework.data.jpa.repository.JpaRepository

interface CampBatgroundFacilitiesRepository extends JpaRepository<CampBatgroundFacilities, String> {

	List<CampBatgroundFacilities> findByCampId(String campId)
}