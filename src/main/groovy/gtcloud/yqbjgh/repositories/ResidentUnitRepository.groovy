package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.ResidentUnit
import org.springframework.data.jpa.repository.JpaRepository

interface ResidentUnitRepository extends JpaRepository<ResidentUnit, String> {

    List<ResidentUnit> findByBdnm(String bdnm)

    List<ResidentUnit> findByUsingCampId(String campId)

}
