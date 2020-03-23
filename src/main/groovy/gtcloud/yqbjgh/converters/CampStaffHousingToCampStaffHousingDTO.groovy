package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.CampStaffHousing
import gtcloud.yqbjgh.domain.dic.CampDicHouseStandardGrade
import gtcloud.yqbjgh.domain.dic.CampDicStaffKind
import gtcloud.yqbjgh.model.CampStaffHousingDTO
import gtcloud.yqbjgh.repositories.dic.CampDicHouseStandardGradeRepository
import gtcloud.yqbjgh.repositories.dic.CampDicStaffKindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CampStaffHousingToCampStaffHousingDTO implements Converter<CampStaffHousing, CampStaffHousingDTO> {

    @Autowired
    CampDicHouseStandardGradeRepository campDicHouseStandardGradeRepository

    @Autowired
    CampDicStaffKindRepository campDicStaffKindRepository

    @Override
    CampStaffHousingDTO convert(CampStaffHousing source) {
        CampStaffHousingDTO target = new CampStaffHousingDTO()
        target.apartId = source.apartId
        target.campId = source.campId
        target.cellNum = source.cellNum
        target.houseKind = source.houseKind
        target.houseNum = source.houseNum
        target.houseStandardArea = source.houseStandardArea

        // houseStandardGrade -> houseStandardGradeÃû³Æ
        String houseStandardGrade = source.houseStandardGrade
        Optional<CampDicHouseStandardGrade> optHouseStandardGrade =
                campDicHouseStandardGradeRepository.findById(houseStandardGrade ?: "")
        optHouseStandardGrade.ifPresent { dic -> target.houseStandardGrade = dic.mc }

        target.jlbm = source.jlbm
        target.mobilePhone = source.mobilePhone
        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj

        // staffKind -> staffKindÃû³Æ
        String staffKind = source.staffKind
        Optional<CampDicStaffKind> optStaffKind =
                campDicStaffKindRepository.findById(staffKind ?: "")
        optStaffKind.ifPresent { dic -> target.staffKind = dic.mc }

        target.staffName = source.staffName
        target.usualResidentNum = source.usualResidentNum
        target.workingUnit = source.workingUnit
        target.armyNum = source.armyNum
        target.employeeDbNum = source.employeeDbNum
        target.idNum = source.idNum
        target.isHousingreform = source.isHousingreform
        target.sex = source.sex

        return target
    }

}
