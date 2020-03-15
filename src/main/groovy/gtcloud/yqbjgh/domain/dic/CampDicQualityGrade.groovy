package gtcloud.yqbjgh.domain.dic

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CampDicQualityGrade {

	@Id
	String nm

	String xh

	String mc
}