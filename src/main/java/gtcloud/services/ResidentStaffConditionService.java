package gtcloud.services;

import java.util.List;

import gtcloud.domain.ResidentStaffCondition;

public interface ResidentStaffConditionService {

    List<ResidentStaffCondition> listAll();

    ResidentStaffCondition getById(String id);

    List<ResidentStaffCondition> getByBdnm(String bdnm);
}
