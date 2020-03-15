package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampStaffHousingDTO {

    String jlbm

    String apartId

    String houseKind

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

    String staffKind

    String houseStandardGrade

    Float houseStandardArea

    String staffName

    String sex

    String idNum

    String armyNum

    String employeeDbNum

    String workingUnit

    String mobilePhone

    String isHousingreform

    String usualResidentNum

    String houseNum

    String cellNum

    String campId

}
