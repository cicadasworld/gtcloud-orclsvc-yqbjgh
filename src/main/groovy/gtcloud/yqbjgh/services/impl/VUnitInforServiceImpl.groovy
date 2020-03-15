package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.converters.VUnitInforToVUnitInforDTO
import gtcloud.yqbjgh.domain.VUnitInfor
import gtcloud.yqbjgh.model.BddwmlNode
import gtcloud.yqbjgh.model.VUnitInforDTO
import gtcloud.yqbjgh.repositories.VUnitInforRepository
import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import gtcloud.yqbjgh.services.VUnitInforService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VUnitInforServiceImpl implements VUnitInforService {

    @Autowired
    private TxzhTsBddwmlService bddwmlService

    @Autowired
    private VUnitInforRepository vUnitInforRepository

    @Autowired
    private VUnitInforToVUnitInforDTO converter

    @Override
    VUnitInforDTO getVUnitInforBybdnm(String bdnm) {
        boolean isRootUnit = bddwmlService.isRootUnit(bdnm)
        if (isRootUnit) {
            VUnitInfor source = new VUnitInfor()
            BddwmlNode bddwml = bddwmlService.getRootUnit(bdnm)
            source.xh = bddwml.xh
            source.bdnm = bddwml.nm
            source.bdjc = bddwml.bdjc
            source.parentnm = bddwml.parentnm
            return converter.convert(source)
        } else {
            VUnitInfor source = vUnitInforRepository.findByBdnm(bdnm).orElse(null)
            return converter.convert(source)
        }
    }
}
