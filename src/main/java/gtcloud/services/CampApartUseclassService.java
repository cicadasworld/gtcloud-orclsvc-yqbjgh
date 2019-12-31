package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampApartUseclass;

public interface CampApartUseclassService {

    List<CampApartUseclass> listAll();

    CampApartUseclass getById(String id);

    List<CampApartUseclass> getByApartId(String apartId);
}
