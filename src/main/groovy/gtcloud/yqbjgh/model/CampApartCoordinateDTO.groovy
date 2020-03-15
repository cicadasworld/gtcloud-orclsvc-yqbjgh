package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Column

class CampApartCoordinateDTO {

	String jlbm

	String apartId

	String apartName

	String coordinateNum

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
