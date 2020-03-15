package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.CampDicElecsupplyMode

interface CampDicElecsupplyModeService {

    CampDicElecsupplyMode getById(String id)

    List<CampDicElecsupplyMode> listAll()
}
