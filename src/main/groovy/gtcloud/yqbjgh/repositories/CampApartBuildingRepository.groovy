package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampApartBuilding
import org.springframework.data.jpa.repository.JpaRepository

interface CampApartBuildingRepository extends JpaRepository<CampApartBuilding, String> {

	List<CampApartBuilding> findByCampId(String campId)

}
