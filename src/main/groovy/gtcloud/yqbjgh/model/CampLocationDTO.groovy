package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampLocationDTO {

    String jlbm

    String nm

    String campWord

    String campCode

    String campKind

    String adminDivision

    String detailAddress

    Float campArea

    String siteKind

    String watersupplyMode

    String elecsupplyMode

    String gassupplyMode

    String heatsupplyMode

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

    String mc

    String realorvirtual

}
