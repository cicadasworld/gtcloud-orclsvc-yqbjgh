package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampApartCoordinate;

public interface CampApartCoordinateRepository extends JpaRepository<CampApartCoordinate, String> {

	List<CampApartCoordinate> findByApartId(String apartId);

}
