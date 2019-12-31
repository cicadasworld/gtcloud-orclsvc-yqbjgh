package gtcloud.services;

import gtcloud.domain.ResidentUnit;

import java.util.List;

public interface ResidentUnitService {

    List<ResidentUnit> listAll();

    ResidentUnit getById(String id);

    List<ResidentUnit> getByBdnm(String bdnm);
}
