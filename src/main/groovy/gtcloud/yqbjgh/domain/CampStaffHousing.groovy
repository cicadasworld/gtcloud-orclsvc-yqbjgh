package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampStaffHousing {

    @Id
    String jlbm

    String apartId

    String houseKind

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

    String staffKind

    String houseStandardGrade

    Float houseStandardArea

    @Column(name = "STUFF_NAME")
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
