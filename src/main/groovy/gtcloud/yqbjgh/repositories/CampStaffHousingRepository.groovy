package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampStaffHousing
import org.springframework.data.jpa.repository.JpaRepository

interface CampStaffHousingRepository extends JpaRepository<CampStaffHousing, String> {

	List<CampStaffHousing> findByApartId(String apartId)
}
