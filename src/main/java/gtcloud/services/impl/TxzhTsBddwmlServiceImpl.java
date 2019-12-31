package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gtcloud.repositories.TxzyTsZbgcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.TxzhTsBddwml;
import gtcloud.repositories.TxzhTsBddwmlRepository;
import gtcloud.services.TxzhTsBddwmlService;

@Service
public class TxzhTsBddwmlServiceImpl implements TxzhTsBddwmlService {

	@Autowired
    private TxzhTsBddwmlRepository bddwmlRepo;

	@Autowired
    private TxzyTsZbgcRepository zbgcRepo;

    @Override
    public List<TxzhTsBddwml> listAll() {
        List<TxzhTsBddwml> results = new ArrayList<>();
        bddwmlRepo.findAll().forEach(results::add);
        return results;
    }

    @Override
    public TxzhTsBddwml getById(String id) {
        return bddwmlRepo.findById(id).orElse(null);
    }

	@Override
	public List<TxzhTsBddwml> getByParentnm(String id) {
		List<TxzhTsBddwml> results = new ArrayList<>();
        bddwmlRepo.findByParentnm(id).forEach(results::add);
		return results;
	}

    @Override
    public List<String> getChildren(String id, List<String> results) {
        results.add(id);
        final List<TxzhTsBddwml> bddwmls = bddwmlRepo.findByParentnm(id);
        for (TxzhTsBddwml bddwml : bddwmls) {
            String nm = bddwml.getNm();
            results.add(nm);
            this.getChildren(nm, results);
        }
        return results;
    }
}
