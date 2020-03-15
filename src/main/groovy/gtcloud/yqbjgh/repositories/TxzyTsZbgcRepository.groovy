package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.TxzyTsZbgc
import org.springframework.data.jpa.repository.JpaRepository

interface TxzyTsZbgcRepository extends JpaRepository<TxzyTsZbgc, String> {

	List<TxzyTsZbgc> findBySjcjdwnm(String sjcjdwnm)

    boolean existsBySjcjdwnm(String id)

}
