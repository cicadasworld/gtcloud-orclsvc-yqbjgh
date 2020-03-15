package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.Bdf2User
import org.springframework.data.jpa.repository.JpaRepository

interface Bdf2UserRepository extends JpaRepository<Bdf2User, String> {

    Bdf2User findByUsername(String username)

}
