package gtcloud.yqbjgh.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "V_APART_COORDINATE_JSON")
class VApartCoordinateJson {

    String campId

    @Id
    String apartId

    String apartInfo

}
