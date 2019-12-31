package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtcloud.domain.CampApartUseclass;

public interface CampApartUseclassRepository extends JpaRepository<CampApartUseclass, String> {

	List<CampApartUseclass> findByApartId(String apartId);
}
