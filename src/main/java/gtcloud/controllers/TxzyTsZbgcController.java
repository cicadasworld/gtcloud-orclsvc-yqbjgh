package gtcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gtcloud.domain.TxzyTsZbgc;
import gtcloud.services.TxzyTsZbgcService;

@RestController
public class TxzyTsZbgcController {

	@Autowired
    private TxzyTsZbgcService service;

	@GetMapping(value = "/txzy-ts-zbgc/list")
	@CrossOrigin
	public List<TxzyTsZbgc> list() {
		List<TxzyTsZbgc> listAll = service.listAll();
		return listAll;
	}

	@GetMapping(value = "/txzy-ts-zbgc/{id}")
	@CrossOrigin
	public List<TxzyTsZbgc> getCampTxzyTsZbgcBySjcjdwnm(@PathVariable String id) {
		List<TxzyTsZbgc> results = service.getBySjcjdwnm(id);
		return results;
	}
}
