package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampApartCoordinate
import org.springframework.data.jpa.repository.JpaRepository

interface CampApartCoordinateRepository extends JpaRepository<CampApartCoordinate, String> {

	List<CampApartCoordinate> findByApartId(String apartId)

}
