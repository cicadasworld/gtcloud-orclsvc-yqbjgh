package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.CampDicCampKind

interface CampDicCampKindService {

    CampDicCampKind getById(String id)

    List<CampDicCampKind> listAll()
}
