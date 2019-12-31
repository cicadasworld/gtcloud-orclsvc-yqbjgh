package gtcloud.controllers;

import gtcloud.convertors.CampLocationToCampLocationDTO;
import gtcloud.domain.CampCoordinate;
import gtcloud.domain.CampLocation;
import gtcloud.domain.VCampLocation;
import gtcloud.model.CampLocationDTO;
import gtcloud.model.VCampLocationDTO;
import gtcloud.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CampLocationController {

    @Autowired
    private CampLocationService campLocationSvc;

    @Autowired
    private TxzyTsZbgcService txzyTsZbgcSvc;

    @Autowired
    private VCampLocationService vCampLocationSvc;

    @Autowired
    private TxzhTsBddwmlService bddwmlSvc;

    @Autowired
    private CampLocationToCampLocationDTO convertor;

    @Autowired
    private CampCoordinateService campCoordinateSvc;

    @GetMapping(value = "/camp-location/list")
    @CrossOrigin
    public List<CampLocation> list() {
        List<CampLocation> listAll = campLocationSvc.listAll();
        return listAll;
    }

    @GetMapping(value = "/camp-location/{id}")
    @CrossOrigin
    public List<CampLocationDTO> getCampLocationByNm(@PathVariable String id) {
        List<CampLocationDTO> results = new ArrayList<>();
        List<CampLocation> locations = campLocationSvc.getByNm(id);
        for (CampLocation location : locations) {
            CampLocationDTO dto = convertor.convert(location);
            results.add(dto);
        }
        return results;
    }

    @GetMapping(value = "/txzy-ts-zbgc/{id}/camp-location")
    @CrossOrigin
    public List<CampLocationDTO> getCampLocationBySjcjdwnm(@PathVariable String id) {
        List<CampLocationDTO> results = new ArrayList<>();
        List<CampLocation> campLocations = txzyTsZbgcSvc.getCampLocation(id);
        for (CampLocation campLocation : campLocations) {
            CampLocationDTO dto = this.convertor.convert(campLocation);
            results.add(dto);
        }
        return results;
    }

    @GetMapping(value = "/v-camp-location/list")
    @CrossOrigin
    public List<VCampLocation> getAllVCampLocation() {
        List<VCampLocation> results = vCampLocationSvc.listAll();
        return results;
    }

    @GetMapping(value = "/v-camp-location/bdnm/{bdnm}")
    @CrossOrigin
    public List<VCampLocationDTO> getVCampLocationByBdnm(@PathVariable String bdnm) {
        List<VCampLocationDTO> results = new ArrayList<>();
        List<VCampLocation> vCampLocations = vCampLocationSvc.getByBdnm(bdnm);
        for (VCampLocation vCampLocation : vCampLocations) {
            VCampLocationDTO dto = new VCampLocationDTO();
            dto.setAdminDivision(vCampLocation.getAdminDivision());
            dto.setBdmc(vCampLocation.getBdmc());
            dto.setCampArea(vCampLocation.getCampArea());
            dto.setCampCode(vCampLocation.getCampCode());
            dto.setCampKind(vCampLocation.getCampKind());
            dto.setCampWord(vCampLocation.getCampWord());
            dto.setDetailAddress(vCampLocation.getDetailAddress());
            dto.setDkmc(vCampLocation.getDkmc());
            dto.setDknm(vCampLocation.getDknm());
            dto.setElecsupplyMode(vCampLocation.getElecsupplyMode());
            dto.setGassupplyMode(vCampLocation.getGassupplyMode());
            dto.setHeatsupplyMode(vCampLocation.getHeatsupplyMode());
            dto.setWatersupplyMode(vCampLocation.getWatersupplyMode());

            results.add(dto);
        }
        return results;
    }

    @GetMapping(value = "/v-camp-location/bdnm2/{bdnm}")
    @CrossOrigin
    public List<VCampLocationDTO> getVCampLocationByBdnm2(@PathVariable String bdnm) {
        List<VCampLocationDTO> results = new ArrayList<>();

        List<String> bdnms = new ArrayList<>();
        bddwmlSvc.getChildren(bdnm, bdnms);
        for (String e : bdnms) {
            List<VCampLocation> vCampLocations = vCampLocationSvc.getByBdnm(e);
            for (VCampLocation vCampLocation : vCampLocations) {
                VCampLocationDTO dto = new VCampLocationDTO();
                dto.setAdminDivision(vCampLocation.getAdminDivision());
                dto.setBdmc(vCampLocation.getBdmc());
                dto.setCampArea(vCampLocation.getCampArea());
                dto.setCampCode(vCampLocation.getCampCode());
                dto.setCampKind(vCampLocation.getCampKind());
                dto.setCampWord(vCampLocation.getCampWord());
                dto.setDetailAddress(vCampLocation.getDetailAddress());
                dto.setDkmc(vCampLocation.getDkmc());
                dto.setDknm(vCampLocation.getDknm());
                dto.setElecsupplyMode(vCampLocation.getElecsupplyMode());
                dto.setGassupplyMode(vCampLocation.getGassupplyMode());
                dto.setHeatsupplyMode(vCampLocation.getHeatsupplyMode());
                dto.setWatersupplyMode(vCampLocation.getWatersupplyMode());

                results.add(dto);
            }
        }
        return results;
    }

    @GetMapping(value = "/v-camp-location/query")
    @CrossOrigin
    public List<VCampLocationDTO> queryCampLocation(@RequestParam String key) {
        List<VCampLocationDTO> results = new ArrayList<>();
        Page<VCampLocation> vCampLocations = vCampLocationSvc.queryCampLocation(key, PageRequest.of(0, 100));
        for (VCampLocation vCampLocation : vCampLocations) {
            VCampLocationDTO dto = new VCampLocationDTO();
            dto.setAdminDivision(vCampLocation.getAdminDivision());
            dto.setBdmc(vCampLocation.getBdmc());
            dto.setCampArea(vCampLocation.getCampArea());
            dto.setCampCode(vCampLocation.getCampCode());
            dto.setCampKind(vCampLocation.getCampKind());
            dto.setCampWord(vCampLocation.getCampWord());
            dto.setDetailAddress(vCampLocation.getDetailAddress());
            dto.setDkmc(vCampLocation.getDkmc());
            dto.setDknm(vCampLocation.getDknm());
            dto.setElecsupplyMode(vCampLocation.getElecsupplyMode());
            dto.setGassupplyMode(vCampLocation.getGassupplyMode());
            dto.setHeatsupplyMode(vCampLocation.getHeatsupplyMode());
            dto.setWatersupplyMode(vCampLocation.getWatersupplyMode());

            CampCoordinate campCoordinate = campCoordinateSvc.getOneByFid(vCampLocation.getDknm());
            if (campCoordinate != null) {
                dto.setCenterX(campCoordinate.getCenterX());
                dto.setCenterY(campCoordinate.getCenterY());
            }

            results.add(dto);
        }
        return results;
    }

    @GetMapping(value = "/v-camp-location/dknm/{dknm}")
    @CrossOrigin
    public VCampLocation getVCampLocationByDknm(@PathVariable String dknm) {
        return vCampLocationSvc.getByDknm(dknm);
    }
}
