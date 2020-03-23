package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.domain.TxzyTsZbgc
import gtcloud.yqbjgh.repositories.TxzyTsZbgcRepository
import gtcloud.yqbjgh.services.TxzyTsZbgcService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TxzyTsZbgcServiceImpl implements TxzyTsZbgcService {

    @Autowired
    TxzyTsZbgcRepository txzyTsZbgcRepo

    @Override
    TxzyTsZbgc getById(String id) {
        return txzyTsZbgcRepo.findById(id).orElse(null)
    }

    @Override
    List<TxzyTsZbgc> getBySjcjdwnm(String sjcjdwnm) {
        return txzyTsZbgcRepo.findBySjcjdwnm(sjcjdwnm)
    }
}
