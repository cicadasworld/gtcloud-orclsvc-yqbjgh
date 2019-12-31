package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampTrainingField;

public interface CampTrainingFieldService {

    List<CampTrainingField> listAll();

    CampTrainingField getById(String id);

    List<CampTrainingField> getByCampId(String campId);
}
