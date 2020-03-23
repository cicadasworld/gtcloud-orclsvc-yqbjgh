package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampWarehouse {

    @Id
    String jlbm

    String apartId

    String warKind

    String warName

    String campId

    String managementUnit

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date sjcjsj

    String sjcjry

}
