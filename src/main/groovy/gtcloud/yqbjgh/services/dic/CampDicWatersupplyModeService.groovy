package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.CampDicWatersupplyMode

interface CampDicWatersupplyModeService {

    CampDicWatersupplyMode getById(String id)

    List<CampDicWatersupplyMode> listAll()
}
