package gtcloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.convertors.CampWarehouseToCampWarehouseDTO;
import gtcloud.domain.CampWarehouse;
import gtcloud.model.CampWarehouseDTO;
import gtcloud.services.CampWarehouseService;

@RestController
public class CampWarehouseController {

    @Autowired
    private CampWarehouseService service;

    @Autowired
    private CampWarehouseToCampWarehouseDTO convertor;

    @GetMapping(value = "/camp-warehouse/list")
    @CrossOrigin
    public List<CampWarehouse> list() {
        List<CampWarehouse> listAll = service.listAll();
        return listAll;
    }

    @GetMapping(value = "/camp-warehouse/{id}")
    @CrossOrigin
    public List<CampWarehouseDTO> getCampWarehouse(@PathVariable String id) {
        List<CampWarehouseDTO> results = new ArrayList<>();

        List<CampWarehouse> campWarehouses = service.getByCampId(id);
        for (CampWarehouse campWarehouse : campWarehouses) {
            CampWarehouseDTO dto = convertor.convert(campWarehouse);
            results.add(dto);
        }
        return results;
    }
}
