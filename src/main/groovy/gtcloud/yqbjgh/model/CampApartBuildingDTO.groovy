package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampApartBuildingDTO {

    String jlbm

    String campId

    String apartNum

    String apartName

    Float floorArea

    String usingStatus

    String floorYear

    Integer floorlevelUp

    Integer floorlevelDown

    String buildingStructure

    String qualityGrade

    Integer elevatorNum

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

    String coorX

    String coorY

    String coordinateId

}
