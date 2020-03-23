package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampTrainingField
import org.springframework.data.jpa.repository.JpaRepository

interface CampTrainingFieldRepository extends JpaRepository<CampTrainingField, String> {

    List<CampTrainingField> findByCampId(String campId)

}
