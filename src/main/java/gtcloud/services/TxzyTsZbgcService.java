package gtcloud.services;

import java.util.List;

import gtcloud.domain.CampLocation;
import gtcloud.domain.TxzyTsZbgc;

public interface TxzyTsZbgcService {

    List<TxzyTsZbgc> listAll();

    TxzyTsZbgc getById(String id);

    List<TxzyTsZbgc> getBySjcjdwnm(String sjcjdwnm);

    List<CampLocation> getCampLocation(String sjcjdwnm);

    boolean existsBySjcjdwnm(String Sjcjdwnm);
}
