package gtcloud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gtcloud.domain.VCampLocation;

public interface VCampLocationRepository extends JpaRepository<VCampLocation, String>, JpaSpecificationExecutor<VCampLocation> {

	List<VCampLocation> findByBdnm(String bdnm);

}
