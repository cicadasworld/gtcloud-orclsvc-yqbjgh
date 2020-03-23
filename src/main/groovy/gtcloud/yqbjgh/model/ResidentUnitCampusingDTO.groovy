package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class ResidentUnitCampusingDTO {

    String jlbm

    String bdnm

    String mc

    String campId

    String remarks

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

}
