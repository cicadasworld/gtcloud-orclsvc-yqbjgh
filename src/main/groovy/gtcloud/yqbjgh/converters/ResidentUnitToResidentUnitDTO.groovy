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
	private TxzhTsBddwmlRepository bddwmlRepository

    @Autowired
    private ResidentDicUnitGradeRepository residentDicUnitGradeRepository

    @Autowired
    private ResidentDicAdminDivisionRepository residentDicAdminDivisionRepository

    @Autowired
    private ResidentDicUnitKindRepository residentDicUnitKindRepository

    @Override
    ResidentUnitDTO convert(ResidentUnit source) {
        ResidentUnitDTO target = new ResidentUnitDTO()
        target.bdnm = source.bdnm
        target.detailAddress = source.detailAddress
        target.jlbm = source.jlbm
        target.mission = source.mission
        target.sjcjry = source.sjcjry
        target.sjcjsj = source.sjcjsj
        target.useingCampId = source.useingCampId
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

        Optional<TxzhTsBddwml> optionalBddwml = bddwmlRepository.findById(source.bdnm)
        optionalBddwml.ifPresent{txzhTsBddwml ->
                target.mc = txzhTsBddwml.mc}

        Optional<ResidentDicUnitGrade> optionalResidentDicUnitGrade =
                residentDicUnitGradeRepository.findById(source.unitGrade)
        optionalResidentDicUnitGrade.ifPresent{residentDicUnitGrade ->
                target.unitGrade = residentDicUnitGrade.mc}

        Optional<ResidentDicAdminDivision> optionalResidentDicAdminDivision =
                residentDicAdminDivisionRepository.findById(source.adminDivision)
        optionalResidentDicAdminDivision.ifPresent{residentDicAdminDivision ->
                target.adminDivision = residentDicAdminDivision.mc}

        Optional<ResidentDicUnitKind> optionalResidentDicUnitKind =
                residentDicUnitKindRepository.findById(source.unitKind)
        optionalResidentDicUnitKind.ifPresent{residentDicUnitKind ->
                target.unitKind = residentDicUnitKind.mc}

        return target
    }

}
