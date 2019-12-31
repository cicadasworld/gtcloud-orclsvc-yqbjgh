package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampLocation;

public interface CampLocationRepository extends JpaRepository<CampLocation, String> {

	List<CampLocation> findByNm(String nm);
}
