package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampWarehouseDTO {

    String jlbm

    String apartId

    String apartName

    String warKind

    String warName

    String campId

    String managementUnit

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

}
