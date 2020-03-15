package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampBatgroundFacilitiesDTO {

    String jlbm

    String campId

    String batName

    String batKind

    Float batArea

    String batFunction

    String managementUnit

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

}
