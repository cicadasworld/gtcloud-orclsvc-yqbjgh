package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampApartBuilding;

public interface CampApartBuildingRepository extends JpaRepository<CampApartBuilding, String> {

	List<CampApartBuilding> findByCampId(String campId);

	CampApartBuilding findByApartNum(String apartId);
}
