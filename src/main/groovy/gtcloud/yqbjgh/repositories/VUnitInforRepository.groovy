package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.VUnitInfor
import org.springframework.data.jpa.repository.JpaRepository

interface VUnitInforRepository extends JpaRepository<VUnitInfor, String> {

	List<VUnitInfor> findAll()

    Optional<VUnitInfor> findByBdnm(String bdnm)

}
