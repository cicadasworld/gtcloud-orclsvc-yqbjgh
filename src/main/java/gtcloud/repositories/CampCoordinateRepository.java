package gtcloud.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampCoordinate;
import org.springframework.data.jpa.repository.Query;

public interface CampCoordinateRepository extends JpaRepository<CampCoordinate, String> {

	List<CampCoordinate> findByFid(String fid, Sort sort);

}
