package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampApartUseclass {

    @Id
    String jlbm

    String apartId

    String barrackUseClass

    Float barrackUseArea

    String barrackUseUnit

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

}
