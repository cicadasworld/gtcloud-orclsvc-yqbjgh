package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampApartBuilding {

    @Id
    String jlbm

    String apartName

    Float floorArea

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

    String usingStatus

    Integer floorlevelUp

    Integer floorlevelDown

    String buildingStructure

    String apartNum

    String qualityGrade

    Integer elevatorNum

    Integer houseAmount

    Integer apartCellAmount

    String floorYear

    String campId

    String usecalss1

    Float useclassArea2

    Float useclassArea1

    String usecalss2

}
