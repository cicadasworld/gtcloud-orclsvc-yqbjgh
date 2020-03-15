package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.VUseCampLocationToVUseCampLocationDTO
import gtcloud.yqbjgh.domain.VUseCampLocation
import gtcloud.yqbjgh.model.BddwmlNode
import gtcloud.yqbjgh.model.VUseCampLocationDTO
import gtcloud.yqbjgh.repositories.VUseCampLocationRepository
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import gtcloud.yqbjgh.services.VUseCampLocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import java.util.stream.Stream

import static java.util.stream.Collectors.toList

@Service
class VUseCampLocationServiceImpl implements VUseCampLocationService {

    @Autowired
    private TxzhTsBddwmlService bddwmlService

    @Autowired
    private VUseCampLocationRepository vUseCampLocationRepository

    @Autowired
    private VUseCampLocationToVUseCampLocationDTO converter

    @Override
    List<VUseCampLocationDTO> getVUsingCampCampLocationByBdnm(String id) {
        List<String> bdnms = bddwmlService.getBdnmFamily(id)
        return bdnms.stream().
                flatMap{bdnm -> getVUseCampLocationDTO(bdnm).stream()}.
                collect(toList())
    }

    List<VUseCampLocationDTO> getVUseCampLocationDTO(String bdnm) {
        List<VUseCampLocation> vUseCampLocations
        boolean isRootUnit = bddwmlService.isRootUnit(bdnm)
        if (isRootUnit) {
            vUseCampLocations = vUseCampLocationRepository.findAll()
        } else {
            vUseCampLocations = vUseCampLocationRepository.findByBdnm(bdnm, Sort.by("dknm"))
        }

        return vUseCampLocations.stream().
                map{vUseCampLocation -> converter.convert(vUseCampLocation)}.
                collect(toList())
    }

    private static Stream<BddwmlNode> stream(BddwmlNode parentNode) {
        if (parentNode.isLeaf) {
            return Stream.of(parentNode)
        } else parentNode.children.stream().
                map{childNode -> stream(childNode)}.
                reduce(Stream.of(parentNode), {n1, n2 -> Stream.concat(n1, n2)})
    }
}
