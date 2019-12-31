package gtcloud.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtcloud.domain.CampLocation;
import gtcloud.domain.TxzyTsZbgc;
import gtcloud.repositories.CampLocationRepository;
import gtcloud.repositories.TxzyTsZbgcRepository;
import gtcloud.services.TxzyTsZbgcService;

@Service
public class TxzyTsZbgcServiceImpl implements TxzyTsZbgcService {

	@Autowired
    private TxzyTsZbgcRepository txzyTsZbgcRepo;

	@Autowired
	private CampLocationRepository campLocationRepo;

    @Override
    public List<TxzyTsZbgc> listAll() {
        List<TxzyTsZbgc> results = new ArrayList<>();
        txzyTsZbgcRepo.findAll().forEach(results::add);
        return results;
    }

    @Override
    public TxzyTsZbgc getById(String id) {
        return txzyTsZbgcRepo.findById(id).orElse(null);
    }

	@Override
	public List<TxzyTsZbgc> getBySjcjdwnm(String sjcjdwnm) {
		List<TxzyTsZbgc> results = new ArrayList<>();
		txzyTsZbgcRepo.findBySjcjdwnm(sjcjdwnm).forEach(results::add);
		return results;
	}

	@Override
	public List<CampLocation> getCampLocation(String sjcjdwnm) {
		List<CampLocation> results = new ArrayList<>();
		List<TxzyTsZbgc> txzyTsZbgcs = txzyTsZbgcRepo.findBySjcjdwnm(sjcjdwnm);
		for (TxzyTsZbgc txzyTsZbgc : txzyTsZbgcs) {
			String nm = txzyTsZbgc.getNm();
			List<CampLocation> campLocations = campLocationRepo.findByNm(nm);
			results.addAll(campLocations);
		}
		return results;
	}

    @Override
    public boolean existsBySjcjdwnm(String sjcjdwnm) {
        return txzyTsZbgcRepo.existsBySjcjdwnm(sjcjdwnm);
    }
}
