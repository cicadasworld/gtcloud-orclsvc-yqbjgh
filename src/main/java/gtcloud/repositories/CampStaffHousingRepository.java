package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampStaffHousing;

public interface CampStaffHousingRepository extends JpaRepository<CampStaffHousing, String> {

	List<CampStaffHousing> findByApartId(String apartId);
}
