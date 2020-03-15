package gtcloud.yqbjgh.services.dic.impl

import gtcloud.yqbjgh.domain.dic.ResidentDicAdminDivision
import gtcloud.yqbjgh.repositories.dic.ResidentDicAdminDivisionRepository
import gtcloud.yqbjgh.services.dic.ResidentDicAdminDivisionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResidentDicAdminDivisionServiceImpl implements ResidentDicAdminDivisionService {

    @Autowired
    private ResidentDicAdminDivisionRepository repository

    @Override
    ResidentDicAdminDivision getById(String id) {
        return repository.findById(id).orElse(null)
    }

    @Override
    List<ResidentDicAdminDivision> listAll() {
        return repository.findAll()
    }
}
