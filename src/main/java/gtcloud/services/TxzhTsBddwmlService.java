package gtcloud.services;

import java.util.List;

import gtcloud.domain.TxzhTsBddwml;

public interface TxzhTsBddwmlService {

    List<TxzhTsBddwml> listAll();

    TxzhTsBddwml getById(String id);

    List<TxzhTsBddwml> getByParentnm(String id);

    List<String> getChildren(String id, List<String> results);
}
