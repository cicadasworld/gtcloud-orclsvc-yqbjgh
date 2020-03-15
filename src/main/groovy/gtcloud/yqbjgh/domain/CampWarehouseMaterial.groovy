package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampWarehouseMaterial {

	@Id
	String jlbm

	Float warArea

	String materialKind

	String dangerousAttr

	String warehouseId

	Float ccwzsl

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date sjcjsj

	String sjcjry

	String campId

}
