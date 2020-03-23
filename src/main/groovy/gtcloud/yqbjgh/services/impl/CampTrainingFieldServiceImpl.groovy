package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampTrainingFieldToCampTrainingFieldDTO
import gtcloud.yqbjgh.domain.CampTrainingField
import gtcloud.yqbjgh.model.CampTrainingFieldDTO
import gtcloud.yqbjgh.repositories.CampTrainingFieldRepository
import gtcloud.yqbjgh.services.CampTrainingFieldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampTrainingFieldServiceImpl implements CampTrainingFieldService {

    @Autowired
    CampTrainingFieldRepository repository

    @Autowired
    CampTrainingFieldToCampTrainingFieldDTO converter

    @Override
    List<CampTrainingFieldDTO> getCampTrainingField(String campId) {
        final List<CampTrainingField> campTrainingFields = repository.findByCampId(campId)
        return campTrainingFields.stream().
                map { campTrainingField -> converter.convert(campTrainingField) }.
                collect(toList())
    }
}
