package gtcloud.yqbjgh.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampCoordinate {

    @Id
    String jlbm

    String fid

    Integer coordinateNum

    @Column(name = "COOR_X")
    String coorX

    @Column(name = "COOR_Y")
    String coorY

    @Column(name = "CENTER_X")
    String centerX

    @Column(name = "CENTER_Y")
    String centerY

}
