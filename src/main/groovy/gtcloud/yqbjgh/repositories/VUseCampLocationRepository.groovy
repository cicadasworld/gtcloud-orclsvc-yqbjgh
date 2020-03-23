package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.VUseCampLocation
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface VUseCampLocationRepository extends JpaRepository<VUseCampLocation, String>, JpaSpecificationExecutor<VUseCampLocation> {

    List<VUseCampLocation> findByUseBdnm(String useBdnm, Sort sort)

    List<VUseCampLocation> findAll()

}
