package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.domain.CampLocation
import gtcloud.yqbjgh.repositories.CampLocationRepository
import gtcloud.yqbjgh.services.CampLocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampLocationServiceImpl implements CampLocationService {

	@Autowired
    private CampLocationRepository repository

    @Override
    CampLocation getById(String id) {
        return repository.findById(id).orElse(null)
    }
}
