package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class ResidentUnit {

    String bdnm

    @Id
    String jlbm

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

    String mission

    String adminDivision

    String detailAddress

    String unitKind

    Integer officerRealityNum

    Integer soldierRealityNum

    Integer soldierAuthorizedNum

    Integer civilAuthorizedNum

    Integer employeeAuthorizedNum

    Integer employeeRealityNum

    Integer civilRealityNum

    String useingCampId

    Integer officerorAuthorizedNum

    String missionEx

    String remark

    String unitGrade

}
