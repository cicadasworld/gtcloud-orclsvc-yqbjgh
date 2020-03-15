package gtcloud.yqbjgh.services.dic

import gtcloud.yqbjgh.domain.dic.ResidentDicAdminDivision

interface ResidentDicAdminDivisionService {

    ResidentDicAdminDivision getById(String id)

    List<ResidentDicAdminDivision> listAll()
}
