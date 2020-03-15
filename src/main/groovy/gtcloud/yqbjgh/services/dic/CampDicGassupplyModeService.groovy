package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.CampDicGassupplyMode

interface CampDicGassupplyModeService {

    CampDicGassupplyMode getById(String id)

    List<CampDicGassupplyMode> listAll()
}
