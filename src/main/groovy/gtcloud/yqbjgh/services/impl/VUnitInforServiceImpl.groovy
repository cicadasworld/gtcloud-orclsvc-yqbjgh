package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.VUnitInforToVUnitInforDTO
import gtcloud.yqbjgh.domain.VUnitInfor
import gtcloud.yqbjgh.model.BddwmlNode
import gtcloud.yqbjgh.model.StaffStatistics
import gtcloud.yqbjgh.model.VUnitInforDTO
import gtcloud.yqbjgh.repositories.TxzhTsBddwmlRepository
import gtcloud.yqbjgh.repositories.VUnitInforRepository
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import gtcloud.yqbjgh.services.VUnitInforService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static java.util.stream.Collectors.toList

@Service
class VUnitInforServiceImpl implements VUnitInforService {

    @Autowired
    TxzhTsBddwmlService bddwmlService

    @Autowired
    VUnitInforRepository vUnitInforRepository

    @Autowired
    VUnitInforToVUnitInforDTO converter

    @Autowired
    TxzhTsBddwmlRepository bddwmlRepository

    @Override
    VUnitInforDTO getVUnitInforBybdnm(String bdnm) {
        boolean isRootUnit = bddwmlService.isRootUnit(bdnm)
        if (isRootUnit) {
            VUnitInfor source = new VUnitInfor()
            BddwmlNode bddwml = bddwmlService.getRootUnit(bdnm)
            source.xh = bddwml?.xh
            source.bdnm = bddwml?.nm
            source.bdjc = bddwml?.bdjc
            source.parentnm = bddwml?.parentnm
            return converter.convert(source)
        } else {
            VUnitInfor source = vUnitInforRepository.findByBdnm(bdnm).orElse(null)
            return converter.convert(source)
        }
    }

    @Override
    StaffStatistics getVUnitInforByCampId(String campId) {
        List<VUnitInfor> vUnitInfors = vUnitInforRepository.findByUsingCampId(campId)
        List<String> bdnms = vUnitInfors.stream().
                flatMap { u -> bddwmlRepository.findBdnmFamily(u.bdnm).stream() }.
                collect(toList())
        List<VUnitInfor> allUnits = bdnms.stream().
                map { bdnm -> vUnitInforRepository.findByBdnm(bdnm)?.get() }.
                collect(toList())
        List<VUnitInfor> filterUnits = allUnits.stream().
                filter { u -> u.usingCampId == campId }.
                collect(toList())
        StaffStatistics s = new StaffStatistics()
        setTotalNums(filterUnits, s)
        return s
    }

    private static void setTotalNums(List<VUnitInfor> filterUnits, StaffStatistics s) {
        s.totalSoldierAuthorizedNum = filterUnits.stream().mapToInt { u -> u.soldierAuthorizedNum ?: 0 }.sum()
        s.totalSoldierRealityNum = filterUnits.stream().mapToInt { u -> u.soldierRealityNum ?: 0 }.sum()
        s.totalEmployeeAuthorizedNum = filterUnits.stream().mapToInt { u -> u.employeeAuthorizedNum ?: 0 }.sum()
        s.totalEmployeeRealityNum = filterUnits.stream().mapToInt { u -> u.employeeRealityNum ?: 0 }.sum()
        s.totalOfficerorAuthorizedNum = filterUnits.stream().mapToInt { u -> u.officerorAuthorizedNum ?: 0 }.sum()
        s.totalOfficerRealityNum = filterUnits.stream().mapToInt { u -> u.officerRealityNum ?: 0 }.sum()
        s.totalCivilAuthorizedNum = filterUnits.stream().mapToInt { u -> u.civilAuthorizedNum ?: 0 }.sum()
        s.totalCivilRealityNum = filterUnits.stream().mapToInt { u -> u.civilRealityNum ?: 0 }.sum()
    }

    @Override
    StaffStatistics getVUnitInforByApartNum(String apartNum) {
        List<VUnitInfor> vUnitInfors = vUnitInforRepository.findByUsingApartNum(apartNum)
        List<String> bdnms = vUnitInfors.stream().
                flatMap { u -> bddwmlRepository.findBdnmFamily(u.bdnm).stream() }.
                collect(toList())
        List<VUnitInfor> allUnits = bdnms.stream().
                map { bdnm -> vUnitInforRepository.findByBdnm(bdnm)?.get() }.
                collect(toList())
        List<VUnitInfor> filterUnits = allUnits.stream().
                filter { u -> u.usingApartNum == apartNum }.
                collect(toList())
        StaffStatistics s = new StaffStatistics()
        setTotalNums(filterUnits, s)
        return s
    }
}
