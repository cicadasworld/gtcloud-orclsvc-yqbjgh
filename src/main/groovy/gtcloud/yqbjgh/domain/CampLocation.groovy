package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampLocation {

	@Id
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

}
