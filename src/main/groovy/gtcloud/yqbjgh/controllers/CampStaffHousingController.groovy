package gtcloud.yqbjgh.controllers

import gtcloud.yqbjgh.model.CampStaffHousingDTO
import gtcloud.yqbjgh.services.CampStaffHousingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CampStaffHousingController {

    @Autowired
    CampStaffHousingService service

    @GetMapping(value = "/camp-staff-housing/{apartId}")
    List<CampStaffHousingDTO> getCampStaffHousing(@PathVariable String apartId) {
        return service.getCampStaffHousing(apartId)
    }
}
