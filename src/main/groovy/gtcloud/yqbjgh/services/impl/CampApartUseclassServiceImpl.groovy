package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampApartUseclassToCampApartUseclassDTO
import gtcloud.yqbjgh.domain.CampApartBuilding
import gtcloud.yqbjgh.domain.CampApartUseclass
import gtcloud.yqbjgh.model.CampApartUseclassDTO
import gtcloud.yqbjgh.repositories.CampApartBuildingRepository
import gtcloud.yqbjgh.repositories.CampApartUseclassRepository
import gtcloud.yqbjgh.services.CampApartUseclassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.groupingBy
import static java.util.stream.Collectors.toList

@Service
class CampApartUseclassServiceImpl implements CampApartUseclassService {

    @Autowired
    CampApartUseclassRepository repository

    @Autowired
    CampApartUseclassToCampApartUseclassDTO converter

    @Autowired
    CampApartBuildingRepository apartBuildingRepository

    @Override
    CampApartUseclass getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampApartUseclassDTO> getCampApartUseClass(String apartId) {
        List<CampApartUseclass> campApartUseclasses = repository.findByApartId(apartId)
        return campApartUseclasses.stream().
                map { campApartUseclass -> converter.convert(campApartUseclass) }.
                collect(toList())
    }

    @Override
    Map<String, Double> getAreaStatistics(String campId) {
        List<CampApartBuilding> apartBuildings = apartBuildingRepository.findByCampId(campId)
        List<CampApartUseclass> apartUseclasses = apartBuildings.stream().
                flatMap { b -> repository.findByApartId(b.jlbm).stream() }.
                collect(toList())
        Map<String, List<Object>> map = apartUseclasses.stream().
                collect(groupingBy { CampApartUseclass u -> u.barrackUseClass ?: "" })

        Map<String, Double> result = new HashMap<>()
        map.forEach { k, v ->
            Double totalArea = v.stream().
                    mapToDouble() { CampApartUseclass u -> u.barrackUseArea as Double }.sum()
            result.put(k, totalArea)
        }
        return result
    }
}
