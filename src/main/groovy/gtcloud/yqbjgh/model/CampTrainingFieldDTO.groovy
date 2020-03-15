package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampTrainingFieldDTO {

    String jlbm

    String campId

    String traName

    String traKind

    Float traArea

    String traUsingCondition

    String managementUnit

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

}
