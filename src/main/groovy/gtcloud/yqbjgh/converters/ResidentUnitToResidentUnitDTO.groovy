package gtcloud.yqbjgh.converters

import gtcloud.yqbjgh.domain.ResidentUnit
import gtcloud.yqbjgh.domain.TxzhTsBddwml
import gtcloud.yqbjgh.domain.dic.ResidentDicAdminDivision
import gtcloud.yqbjgh.domain.dic.ResidentDicUnitGrade
import gtcloud.yqbjgh.domain.dic.ResidentDicUnitKind
import gtcloud.yqbjgh.model.ResidentUnitDTO
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicAdminDivisionRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitGradeRepository
import gtcloud.yqbjgh.repositories.dic.ResidentDicUnitKindRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class ResidentUnitToResidentUnitDTO implements Converter<ResidentUnit, ResidentUnitDTO> {

    @Autowired
    TxzhTsBddwmlRepository bddwmlRepository

    @Autowired
    ResidentDicUnitGradeRepository residentDicUnitGradeRepository

    @Autowired
    ResidentDicAdminDivisionRepository residentDicAdminDivisionRepository

    @Autowired
    ResidentDicUnitKindRepository residentDicUnitKindRepository

    @Override
    ResidentUnitDTO convert(ResidentUnit source) {
        ResidentUnitDTO target = new ResidentUnitDTO()
        String bdnm = source.bdnm
        target.bdnm = bdnm
        target.detailAddress = source.detailAddress
        target.jlbm = source.jlbm
        target.mission = source.mission
        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj
        target.usingCampId = source.usingCampId
        target.officerRealityNum = source.officerRealityNum
        target.soldierRealityNum = source.soldierRealityNum
        target.soldierAuthorizedNum = source.soldierAuthorizedNum
        target.civilRealityNum = source.civilRealityNum
        target.civilAuthorizedNum = source.civilAuthorizedNum
        target.employeeRealityNum = source.employeeRealityNum
        target.employeeAuthorizedNum = source.employeeAuthorizedNum
        target.officerorAuthorizedNum = source.officerorAuthorizedNum
        target.missionEx = source.missionEx
        target.remark = source.remark
        target.usingApartNum = source.usingApartNum

        // bdnm -> bd名称
        Optional<TxzhTsBddwml> optionalBddwml = bddwmlRepository.findById(bdnm ?: "")
        optionalBddwml.ifPresent { txzhTsBddwml ->
            target.mc = txzhTsBddwml.mc
        }

        // unitGrade -> unitGrade名称
        String unitGrade = source.unitGrade
        Optional<ResidentDicUnitGrade> optUnitGrade =
                residentDicUnitGradeRepository.findById(unitGrade ?: "")
        optUnitGrade.ifPresent { dic ->
            target.unitGrade = dic.mc
        }

        // adminDivision -> adminDivision名称
        String adminDivision = source.adminDivision
        Optional<ResidentDicAdminDivision> optAdminDivision =
                residentDicAdminDivisionRepository.findById(adminDivision ?: "")
        optAdminDivision.ifPresent { dic -> target.adminDivision = dic.mc }

        // unitKind -> unitKind名称
        String unitKind = source.unitKind
        Optional<ResidentDicUnitKind> optUnitKind = residentDicUnitKindRepository.findById(unitKind ?: "")
        optUnitKind.ifPresent { dic -> target.unitKind = dic.mc }

        return target
    }

}
