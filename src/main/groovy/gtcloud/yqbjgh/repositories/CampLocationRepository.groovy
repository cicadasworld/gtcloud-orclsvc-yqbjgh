package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampLocation
import org.springframework.data.jpa.repository.JpaRepository

interface CampLocationRepository extends JpaRepository<CampLocation, String> {
}
