package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.domain.TxzyTsZbgc
import gtcloud.yqbjgh.services.TxzyTsZbgcService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TxzyTsZbgcController {

    @Autowired
    TxzyTsZbgcService service

    @GetMapping(value = "/txzy-ts-zbgc/{sjcjdwnm}")
    List<TxzyTsZbgc> getCampTxzyTsZbgcBySjcjdwnm(@PathVariable String sjcjdwnm) {
        return service.getBySjcjdwnm(sjcjdwnm)
    }
}
