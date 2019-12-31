package gtcloud.controllers;

import gtcloud.convertors.TxzhTsBddwmlEntityToTxzhTsBddwmlNode;
import gtcloud.domain.TxzhTsBddwml;
import gtcloud.model.TxzhTsBddwmlNode;
import gtcloud.services.TxzhTsBddwmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TxzhTsBddwmlController {

	@Autowired
    private TxzhTsBddwmlService bddwmlSvc;

	@Autowired
	private TxzhTsBddwmlEntityToTxzhTsBddwmlNode converter;

	@GetMapping(value = "/txzh-ts-ddwml/list")
	@CrossOrigin
	public List<TxzhTsBddwml> list() {
		List<TxzhTsBddwml> listAll = bddwmlSvc.listAll();
		return listAll;
	}

	@GetMapping(value = "/txzh-ts-ddwml/{id}")
	@CrossOrigin
	public TxzhTsBddwml getTxzhTsBddwml(@PathVariable String id) {
		TxzhTsBddwml result = bddwmlSvc.getById(id);
		return result;
	}

	@GetMapping(value = "/txzh-ts-ddwml/catalogue/{nm}")
	@CrossOrigin
	public List<TxzhTsBddwmlNode> getCatalogueBynm(@PathVariable String id) {
		List<TxzhTsBddwmlNode> nodes = new ArrayList<>();
		TxzhTsBddwmlNode node = new TxzhTsBddwmlNode();
		final TxzhTsBddwml entity = bddwmlSvc.getById(id);
		node.setNm(entity.getNm());
		node.setMc(entity.getMc());
		node.setXh(entity.getXh());
		node.setBdhfnm(entity.getBdhfnm());
		node.setBdhf(entity.getBdhf());
		node.setBdjc(entity.getBdjc());
		node.setBzxh(entity.getBzxh());
		node.setBzfh(entity.getBzfh());
		node.setBzjc(entity.getBzjc());
		node.setZzbd(entity.getZzbd());
		node.setParentnm(entity.getParentnm());
		node.setCamp(entity.getCamp());
		node.setResident(entity.getResident());

		List<TxzhTsBddwmlNode> childrenNode = new ArrayList<>();
		List<TxzhTsBddwml> childenEntity = bddwmlSvc.getByParentnm(entity.getNm());
		for (TxzhTsBddwml e : childenEntity) {
			TxzhTsBddwmlNode childNode = converter.convert(e);
			childrenNode.add(childNode);
		}
		node.setChildren(childrenNode);
		nodes.add(node);
		return nodes;
	}

	@GetMapping(value = "/txzh-ts-ddwml/catalogue")
	@CrossOrigin
	public List<TxzhTsBddwmlNode> getCatalogue() {
		List<TxzhTsBddwmlNode> nodes = new ArrayList<>();
		List<TxzhTsBddwml> TxzhTsBddwmls = bddwmlSvc.getByParentnm(null); // 'parent=null' are roots
		for (TxzhTsBddwml txzhTsBddwml : TxzhTsBddwmls) {
			String nm = txzhTsBddwml.getNm();
			TxzhTsBddwmlNode node = new TxzhTsBddwmlNode();
            final TxzhTsBddwml entity = bddwmlSvc.getById(nm);
            node.setNm(entity.getNm());
			node.setMc(entity.getMc());
			node.setXh(entity.getXh());
			node.setBdhfnm(entity.getBdhfnm());
			node.setBdhf(entity.getBdhf());
			node.setBdjc(entity.getBdjc());
			node.setBzxh(entity.getBzxh());
			node.setBzfh(entity.getBzfh());
			node.setBzjc(entity.getBzjc());
			node.setZzbd(entity.getZzbd());
			node.setParentnm(entity.getParentnm());
			node.setCamp(entity.getCamp());
			node.setResident(entity.getResident());

			List<TxzhTsBddwmlNode> childrenNode = new ArrayList<>();
			final List<TxzhTsBddwml> childenEntity = bddwmlSvc.getByParentnm(entity.getNm());
			for (TxzhTsBddwml e : childenEntity) {
                TxzhTsBddwmlNode childNode = converter.convert(e);
                if (childNode != null) {
                    childrenNode.add(childNode);
                }
			}
			node.setChildren(childrenNode);

			nodes.add(node);
		}

		return nodes;
	}
}
