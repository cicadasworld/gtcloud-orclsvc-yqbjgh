package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.ResidentStaffCondition;
import gtcloud.repositories.ResidentStaffConditionRepository;
import gtcloud.services.ResidentStaffConditionService;

@Service
public class ResidentStaffConditionServiceImpl implements ResidentStaffConditionService {

	@Autowired
    private ResidentStaffConditionRepository repository;

    @Override
    public List<ResidentStaffCondition> listAll() {
        List<ResidentStaffCondition> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public ResidentStaffCondition getById(String id) {
        return repository.findById(id).orElse(null);
    }

	@Override
	public List<ResidentStaffCondition> getByBdnm(String bdnm) {
		List<ResidentStaffCondition> results = new ArrayList<>();
		repository.findByBdnm(bdnm).forEach(results::add);
		return results;
	}
}
