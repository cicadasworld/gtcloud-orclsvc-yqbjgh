package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.CampDicBarrackUseClass
import gtcloud.yqbjgh.services.dic.CampDicBarrackUseClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CampDicBarrackUseClassController {

    @Autowired
    CampDicBarrackUseClassService service

    @GetMapping(value = "/camp-dic-barrack-use-class")
    List<CampDicBarrackUseClass> getCampDicBarrackUseClassList() {
        return service.listAll()
    }
}
