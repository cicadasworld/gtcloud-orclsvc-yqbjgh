package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.CampDicSiteKind

interface CampDicSiteKindService {

    CampDicSiteKind getById(String id)

    List<CampDicSiteKind> listAll()
}
