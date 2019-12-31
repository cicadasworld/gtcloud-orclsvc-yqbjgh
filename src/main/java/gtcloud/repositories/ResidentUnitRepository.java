package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.ResidentUnit;

public interface ResidentUnitRepository extends JpaRepository<ResidentUnit, String> {

	List<ResidentUnit> findByBdnm(String bdnm);
}
