package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampBatgroundFacilities {

	@Id
	String jlbm

	String campId

	String batName

	String batKind

	Float batArea

	String batFunction

	String managementUnit

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	Date sjcjsj

	String sjcjry

}
