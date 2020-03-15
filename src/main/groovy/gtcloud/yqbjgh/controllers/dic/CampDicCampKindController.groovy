package gtcloud.yqbjgh.controllers.dic

import gtcloud.yqbjgh.domain.dic.CampDicCampKind
import gtcloud.yqbjgh.services.dic.CampDicCampKindService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CampDicCampKindController {

    @Autowired
    private CampDicCampKindService service

	@GetMapping(value = "/camp-dic-camp-kind")
	List<CampDicCampKind> getCampDicCampKindList() {
        return service.listAll()
	}
}
