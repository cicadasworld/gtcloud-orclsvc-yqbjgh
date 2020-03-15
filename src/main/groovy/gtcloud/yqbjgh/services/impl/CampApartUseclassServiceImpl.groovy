package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampApartUseclassToCampApartUseclassDTO
import gtcloud.yqbjgh.domain.CampApartUseclass
import gtcloud.yqbjgh.model.CampApartUseclassDTO
import gtcloud.yqbjgh.repositories.CampApartUseclassRepository
import gtcloud.yqbjgh.services.CampApartUseclassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampApartUseclassServiceImpl implements CampApartUseclassService {

    @Autowired
    private CampApartUseclassRepository repository

    @Autowired
    private CampApartUseclassToCampApartUseclassDTO converter

    @Override
    CampApartUseclass getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampApartUseclassDTO> getCampApartUseClass(String apartId) {
        List<CampApartUseclass> campApartUseclasses = repository.findByApartId(apartId)
        return campApartUseclasses.stream()
                .map{campApartUseclass -> converter.convert(campApartUseclass)}
                .collect(toList())
    }
}
