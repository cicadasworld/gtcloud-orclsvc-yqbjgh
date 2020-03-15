package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class BddwmlNode {

    String nm
    String mc
    String xh
    String bdjc
    String parentnm

    List<BddwmlNode> children

    boolean show

    boolean hasManagedCamp

    boolean hasUsingCamp

    boolean isLeaf

    String unitKind
    String adminDivision
    String detailAddress
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

    Integer totalSoldierAuthorizedNum
    Integer totalSoldierRealityNum
    Integer totalEmployeeAuthorizedNum
    Integer totalEmployeeRealityNum
    Integer totalOfficerorAuthorizedNum
    Integer totalOfficerRealityNum
    Integer totalCivilAuthorizedNum
    Integer totalCivilRealityNum
}
