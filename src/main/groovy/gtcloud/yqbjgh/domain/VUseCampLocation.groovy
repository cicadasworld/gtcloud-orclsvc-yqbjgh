package gtcloud.yqbjgh.domain

import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "V_USE_CAMP_LOCATION")
class VUseCampLocation {

    String bdnm

    String bdmc

    String jlbm

    @Id
    String dknm

    String dkmc

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

    String lineColor

    String fillColor

    String fillOpacity

    String useBdnm

    String useBdmc

    String realorvirtual

}
