package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampCoordinate
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository

interface CampCoordinateRepository extends JpaRepository<CampCoordinate, String> {

	List<CampCoordinate> findByFid(String fid, Sort sort)

}
