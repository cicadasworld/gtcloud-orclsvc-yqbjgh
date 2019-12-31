package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.CampStaffHousingToCampStaffHousingDTO;
import gtcloud.domain.CampStaffHousing;
import gtcloud.model.CampStaffHousingDTO;
import gtcloud.services.CampStaffHousingService;

@RestController
public class CampStaffHousingController {

    @Autowired
    private CampStaffHousingService service;

    @Autowired
    private CampStaffHousingToCampStaffHousingDTO convertor;

    @GetMapping(value = "/camp-staff-housing/list")
    @CrossOrigin
    public List<CampStaffHousing> list() {
        List<CampStaffHousing> listAll = service.listAll();
        return listAll;
    }

    @GetMapping(value = "/camp-staff-housing/{id}")
    @CrossOrigin
    public List<CampStaffHousingDTO> getCampStaffHousing(@PathVariable String id) {
        List<CampStaffHousingDTO> results = new ArrayList<>();
        List<CampStaffHousing> campStaffHousings = service.getByApartId(id);
        for (CampStaffHousing campStaffHousing : campStaffHousings) {
            CampStaffHousingDTO dto = convertor.convert(campStaffHousing);
            results.add(dto);
        }
        return results;
    }
}
