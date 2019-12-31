package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.TxzhTsBddwml;

public interface TxzhTsBddwmlRepository extends JpaRepository<TxzhTsBddwml, String> {

	List<TxzhTsBddwml> findByParentnm(String id);

}
