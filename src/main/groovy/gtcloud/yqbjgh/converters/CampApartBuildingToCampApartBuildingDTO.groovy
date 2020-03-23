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
    CampDicBuildingStructureRepository campDicBuildingStructureRepository

    @Autowired
    CampDicQualityGradeRepository campDicQualityGradeRepository

    @Autowired
    CampDicUsingStatusRepository campDicUsingStatusRepository

    @Autowired
    CampApartCoordinateRepository apartCoordinateRepository

    @Override
    CampApartBuildingDTO convert(CampApartBuilding source) {
        CampApartBuildingDTO target = new CampApartBuildingDTO()
        target.apartName = source.apartName
        target.apartNum = source.apartNum

        // buildingStructure -> buildingStructureÃû³Æ
        String buildingStructure = source.buildingStructure
        Optional<CampDicBuildingStructure> optBuildingStructure =
                campDicBuildingStructureRepository.findById(buildingStructure ?: "")
        optBuildingStructure.ifPresent { dic -> target.buildingStructure = dic.mc }

        target.campId = source.campId
        target.elevatorNum = source.elevatorNum
        target.floorArea = source.floorArea
        target.floorlevelDown = source.floorlevelDown
        target.floorlevelUp = source.floorlevelUp
        target.floorYear = source.floorYear
        target.jlbm = source.jlbm

        // qualityGrade -> qualityGradeÃû³Æ
        String qualityGrade = source.qualityGrade
        Optional<CampDicQualityGrade> optQualityGrade =
                campDicQualityGradeRepository.findById(qualityGrade ?: "")
        optQualityGrade.ifPresent { dic -> target.qualityGrade = dic.mc }

        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj

        // usingStatus -> usingStatusÃû³Æ
        String usingStatus = source.usingStatus
        Optional<CampDicUsingStatus> optUsingStatus =
                campDicUsingStatusRepository.findById(usingStatus ?: "")
        optUsingStatus.ifPresent { dic -> target.usingStatus = dic.mc }

        List<CampApartCoordinate> campApartCoordinates =
                apartCoordinateRepository.findByApartId(source.jlbm)
        for (CampApartCoordinate campApartCoordinate : campApartCoordinates) {
            // coordinateId(CAMP_APARIT_BUILDING) -> jlbm(CAMP_APART_COORIDINATE)
            target.coorX = campApartCoordinate.coorX
            target.coordinateId = campApartCoordinate.jlbm
            target.coorY = campApartCoordinate.coorY
        }
        return target
    }
}
