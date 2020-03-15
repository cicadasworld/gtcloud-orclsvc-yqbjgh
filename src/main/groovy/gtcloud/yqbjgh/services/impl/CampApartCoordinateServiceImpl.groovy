package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.CampApartCoordinateToCampApartCoordinateDTO
import gtcloud.yqbjgh.domain.CampApartCoordinate
import gtcloud.yqbjgh.model.CampApartCoordinateDTO
import gtcloud.yqbjgh.repositories.CampApartCoordinateRepository
import gtcloud.yqbjgh.services.CampApartCoordinateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class CampApartCoordinateServiceImpl implements CampApartCoordinateService {

	@Autowired
    private CampApartCoordinateRepository repository

    @Autowired
    private CampApartCoordinateToCampApartCoordinateDTO converter

    @Override
    CampApartCoordinate getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<CampApartCoordinateDTO> getCampApartCoordinate(String apartId) {
        List<CampApartCoordinate> campApartCoordinates = repository.findByApartId(apartId)
        return campApartCoordinates.stream()
                .map{campApartCoordinate -> converter.convert(campApartCoordinate)}
                .collect(toList())
    }

    @Override
    CampApartCoordinateDTO createCampApartCoordinate(CampApartCoordinateDTO dto) {
        CampApartCoordinate campApartCoordinate = new CampApartCoordinate()
        String jlbm = dto.getJlbm()
        if (jlbm == null || jlbm.isEmpty()) {
            jlbm = UUID.randomUUID().toString().replace("-", "")
        }
        dto.setJlbm(jlbm)
        campApartCoordinate.setJlbm(jlbm)
        campApartCoordinate.setApartId(dto.getApartId())
        campApartCoordinate.setCoorX(dto.getCoorX())
        campApartCoordinate.setCoorY(dto.getCoorY())
        campApartCoordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()))
        campApartCoordinate.setCoorHeigh(dto.getCoorHeigh())
        campApartCoordinate.setCoorLength(dto.getCoorLength())
        campApartCoordinate.setSjcjry(dto.getSjcjry())
        campApartCoordinate.setSjcjsj(dto.getSjcjsj())
        repository.save(campApartCoordinate)
        return dto
    }

    @Override
    CampApartCoordinateDTO updateCampApartCoordinate(String jlbm, CampApartCoordinateDTO dto) {
        CampApartCoordinate campApartCoordinate = new CampApartCoordinate()
        campApartCoordinate.setJlbm(jlbm)
        campApartCoordinate.setApartId(dto.getApartId())
        campApartCoordinate.setCoorX(dto.getCoorX())
        campApartCoordinate.setCoorY(dto.getCoorY())
        campApartCoordinate.setCoordinateNum(Integer.valueOf(dto.getCoordinateNum()))
        campApartCoordinate.setCoorHeigh(dto.getCoorHeigh())
        campApartCoordinate.setCoorLength(dto.getCoorLength())
        campApartCoordinate.setSjcjry(dto.getSjcjry())
        campApartCoordinate.setSjcjsj(dto.getSjcjsj())
        repository.save(campApartCoordinate)
        return dto
    }

    @Override
    List<CampApartCoordinateDTO> deleteCampApartCoordinate(String apartId) {
        List<CampApartCoordinate> campApartCoordinates = repository.findByApartId(apartId)
        return campApartCoordinates.stream()
                .map{campApartCoordinate ->
                    deleteAndReturn(repository, campApartCoordinate)
                }
                .collect(toList())
    }

    CampApartCoordinateDTO deleteAndReturn(CampApartCoordinateRepository repository,
                                           CampApartCoordinate campApartCoordinate) {
        repository.delete(campApartCoordinate)
        CampApartCoordinateDTO dto = converter.convert(campApartCoordinate)
        return dto
    }
}
