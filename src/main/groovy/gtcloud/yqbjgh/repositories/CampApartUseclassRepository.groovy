package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.CampApartUseclass
import org.springframework.data.jpa.repository.JpaRepository

interface CampApartUseclassRepository extends JpaRepository<CampApartUseclass, String> {

    List<CampApartUseclass> findByApartId(String apartId)
}
