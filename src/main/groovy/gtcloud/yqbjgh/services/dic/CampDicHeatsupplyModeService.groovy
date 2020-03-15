package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.CampDicHeatsupplyMode

interface CampDicHeatsupplyModeService {

    CampDicHeatsupplyMode getById(String id)

    List<CampDicHeatsupplyMode> listAll()
}
