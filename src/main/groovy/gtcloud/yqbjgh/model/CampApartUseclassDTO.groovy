package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampApartUseclassDTO {

    String jlbm

    String apartId

    String apartName

    String barrackUseClass

    Float barrackUseArea

    String barrackUseUnit

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

}
