package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampApartCoordinate {

	@Id
	String jlbm

	String apartId

	Integer coordinateNum

	@Column(name = "COOR_X")
	String coorX

	@Column(name = "COOR_Y")
	String coorY

	String coorLength

	String coorHeigh

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	Date sjcjsj

	String sjcjry

}
