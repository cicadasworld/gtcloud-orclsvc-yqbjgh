package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampTrainingField;

public interface CampTrainingFieldRepository extends JpaRepository<CampTrainingField, String> {

	List<CampTrainingField> findByCampId(String campId);

}
