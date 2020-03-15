package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.VCampLocation
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface VCampLocationRepository extends JpaRepository<VCampLocation, String>, JpaSpecificationExecutor<VCampLocation> {

    @Query(value = "select t from VCampLocation t where t.bdnm = :bdnm")
    List<VCampLocation> findByBdnm(@Param("bdnm") String bdnm, Sort sort)

    @Query(value = "select max(t.campArea) from VCampLocation t")
    Float findMaxCampArea()
}
