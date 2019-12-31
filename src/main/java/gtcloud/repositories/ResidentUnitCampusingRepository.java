package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.ResidentUnitCampusing;

public interface ResidentUnitCampusingRepository extends JpaRepository<ResidentUnitCampusing, String> {

	List<ResidentUnitCampusing> findByCampId(String campId);
}
