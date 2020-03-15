package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.VApartCoordinateJson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface VApartCoordinateJsonRepository extends JpaRepository<VApartCoordinateJson, String>, JpaSpecificationExecutor<VApartCoordinateJson> {

    @Query(value = "select t from VApartCoordinateJson t where t.campId = :id")
    List<VApartCoordinateJson> findByCampId(@Param("id") String id)

}
