package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.CampApartUseclassToCampApartUseclassDTO;
import gtcloud.domain.CampApartUseclass;
import gtcloud.model.CampApartUseclassDTO;
import gtcloud.services.CampApartUseclassService;

@RestController
public class CampApartUseclassController {

    @Autowired
    private CampApartUseclassService service;

    @Autowired
    private CampApartUseclassToCampApartUseclassDTO convertor;

    @GetMapping(value = "/camp-apart-useclass/list")
    @CrossOrigin
    public List<CampApartUseclass> list() {
        List<CampApartUseclass> listAll = service.listAll();
        return listAll;
    }

    @GetMapping(value = "/camp-apart-useclass/{id}")
    @CrossOrigin
    public List<CampApartUseclassDTO> getCampApartUseclass(@PathVariable String id) {
        List<CampApartUseclassDTO> results = new ArrayList<>();
        List<CampApartUseclass> campApartUseclasses = service.getByApartId(id);
        for (CampApartUseclass campApartUseclass : campApartUseclasses) {
            CampApartUseclassDTO dto = convertor.convert(campApartUseclass);
            results.add(dto);
        }
        return results;
    }
}
