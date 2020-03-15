package gtcloud.yqbjgh.model

import com.fasterxml.jackson.annotation.JsonFormat

class CampWarehouseMaterialDTO {

	String jlbm

	Float warArea

	String materialKind

	String dangerousAttr

	String warehouseId

	Float ccwzsl

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	Date sjcjsj

	String sjcjry

	String campId

}
