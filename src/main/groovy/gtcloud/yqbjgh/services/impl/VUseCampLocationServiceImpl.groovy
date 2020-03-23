package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.VUseCampLocationToVUseCampLocationDTO
import gtcloud.yqbjgh.domain.VUseCampLocation
import gtcloud.yqbjgh.model.VUseCampLocationDTO
import gtcloud.yqbjgh.repositories.VUseCampLocationRepository
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import gtcloud.yqbjgh.services.VUseCampLocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class VUseCampLocationServiceImpl implements VUseCampLocationService {

    @Autowired
    TxzhTsBddwmlService bddwmlService

    @Autowired
    VUseCampLocationRepository vUseCampLocationRepository

    @Autowired
    VUseCampLocationToVUseCampLocationDTO converter

    @Override
    List<VUseCampLocationDTO> getVUsingCampCampLocationByBdnm(String id) {
        List<String> bdnms = bddwmlService.getBdnmFamily(id)
        return bdnms.stream().
                flatMap { bdnm -> getVUseCampLocationDTO(bdnm).stream() }.
                collect(toList())
    }

    List<VUseCampLocationDTO> getVUseCampLocationDTO(String bdnm) {
        List<VUseCampLocation> vUseCampLocations
        boolean isRootUnit = bddwmlService.isRootUnit(bdnm)
        if (isRootUnit) {
            vUseCampLocations = vUseCampLocationRepository.findAll()
        } else {
            vUseCampLocations = vUseCampLocationRepository.findByUseBdnm(bdnm, Sort.by("dknm"))
        }

        return vUseCampLocations.stream().
                map { vUseCampLocation -> converter.convert(vUseCampLocation) }.
                collect(toList())
    }
}
