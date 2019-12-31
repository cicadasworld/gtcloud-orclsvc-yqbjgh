package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.TxzyTsZbgc;

public interface TxzyTsZbgcRepository extends JpaRepository<TxzyTsZbgc, String> {

	List<TxzyTsZbgc> findBySjcjdwnm(String sjcjdwnm);

    boolean existsBySjcjdwnm(String sjcjdwnm);

}
