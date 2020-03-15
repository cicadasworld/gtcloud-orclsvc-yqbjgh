package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.VUseCampLocation
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface VUseCampLocationRepository extends JpaRepository<VUseCampLocation, String>, JpaSpecificationExecutor<VUseCampLocation> {

    @Query(value = "select t from VUseCampLocation t where t.bdnm = :bdnm")
    List<VUseCampLocation> findByBdnm(@Param("bdnm") String bdnm, Sort sort)

    List<VUseCampLocation> findAll()

}
