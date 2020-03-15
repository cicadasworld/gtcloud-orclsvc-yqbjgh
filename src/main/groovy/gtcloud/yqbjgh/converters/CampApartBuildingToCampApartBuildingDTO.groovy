package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampApartBuilding
import gtcloud.yqbjgh.domain.CampApartCoordinate
import gtcloud.yqbjgh.domain.dic.CampDicBuildingStructure
import gtcloud.yqbjgh.domain.dic.CampDicQualityGrade
import gtcloud.yqbjgh.domain.dic.CampDicUsingStatus
import gtcloud.yqbjgh.model.CampApartBuildingDTO
import gtcloud.yqbjgh.repositories.CampApartCoordinateRepository
import gtcloud.yqbjgh.repositories.dic.CampDicBuildingStructureRepository
import gtcloud.yqbjgh.repositories.dic.CampDicQualityGradeRepository
import gtcloud.yqbjgh.repositories.dic.CampDicUsingStatusRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampApartBuildingToCampApartBuildingDTO implements Converter<CampApartBuilding, CampApartBuildingDTO> {

    @Autowired
    private CampDicBuildingStructureRepository campDicBuildingStructureRepository

    @Autowired
    private CampDicQualityGradeRepository campDicQualityGradeRepository

    @Autowired
    private CampDicUsingStatusRepository campDicUsingStatusRepository

    @Autowired
    private CampApartCoordinateRepository apartCoordinateRepository

    @Override
	CampApartBuildingDTO convert(CampApartBuilding source) {
        CampApartBuildingDTO target = new CampApartBuildingDTO()
        target.apartName = source.apartName
        target.apartNum = source.apartNum
        Optional<CampDicBuildingStructure> optionalCampDicBuildingStructure =
                campDicBuildingStructureRepository.findById(source.buildingStructure)
        optionalCampDicBuildingStructure.ifPresent {campDicBuildingStructure ->
                target.buildingStructure = campDicBuildingStructure.mc}
        target.campId = source.campId
        target.elevatorNum = source.elevatorNum
        target.floorArea = source.floorArea
        target.floorlevelDown = source.floorlevelDown
        target.floorlevelUp = source.floorlevelUp
        target.floorYear = source.floorYear
        target.jlbm = source.jlbm
        Optional<CampDicQualityGrade> optionalCampDicQualityGrade =
                campDicQualityGradeRepository.findById(source.qualityGrade)
        optionalCampDicQualityGrade.ifPresent{campDicQualityGrade ->
                target.qualityGrade = campDicQualityGrade.mc}
        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj
        Optional<CampDicUsingStatus> optionalCampDicUsingStatus =
                campDicUsingStatusRepository.findById(source.usingStatus)
        optionalCampDicUsingStatus.ifPresent{campDicUsingStatus ->
                target.usingStatus = campDicUsingStatus.mc}
        List<CampApartCoordinate> campApartCoordinates =
                apartCoordinateRepository.findByApartId(source.jlbm)
        for (CampApartCoordinate campApartCoordinate : campApartCoordinates) {
            target.coordinateId = campApartCoordinate.jlbm // coordinateId(CAMP_APARIT_BUILDING) -> jlbm(CAMP_APART_COORIDINATE)
            target.coorX = campApartCoordinate.coorX
            target.coorY = campApartCoordinate.coorY
        }
		return target
	}
}
