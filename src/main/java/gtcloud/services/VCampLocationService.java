package gtcloud.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gtcloud.domain.VCampLocation;

public interface VCampLocationService {

	List<VCampLocation> listAll();

	List<VCampLocation> getByBdnm(String bdnm);

	Page<VCampLocation> queryCampLocation(String key, Pageable pageable);

    VCampLocation getByDknm(String dknm);
}
