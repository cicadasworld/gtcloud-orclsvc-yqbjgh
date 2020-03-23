package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.CampDicBarrackUseClass

interface CampDicBarrackUseClassService {

    CampDicBarrackUseClass getById(String id)

    List<CampDicBarrackUseClass> listAll()
}
