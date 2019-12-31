package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.ResidentStaffCondition;

public interface ResidentStaffConditionRepository extends JpaRepository<ResidentStaffCondition, String> {

	List<ResidentStaffCondition> findByBdnm(String bdnm);
}
