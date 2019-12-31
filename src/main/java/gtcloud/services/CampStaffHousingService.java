package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampStaffHousing;

public interface CampStaffHousingService {

    List<CampStaffHousing> listAll();

    CampStaffHousing getById(String id);

    List<CampStaffHousing> getByApartId(String apartId);
}
