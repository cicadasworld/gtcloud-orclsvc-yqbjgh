package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "V_UNIT_INFOR")
class VUnitInfor {

    String xh

    @Id
    String bdnm

    String mc

    String bdjc

    String parentnm

    String jlbm

    String adminDivision

    String detailAddress

    String unitKind

    String unitGrade

    String useingCampId

    Integer soldierAuthorizedNum

    Integer soldierRealityNum

    Integer employeeAuthorizedNum

    Integer employeeRealityNum

    Integer officerorAuthorizedNum

    Integer officerRealityNum

    Integer civilAuthorizedNum

    Integer civilRealityNum

    String mission

    String missionEx

    String remark

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry
}
