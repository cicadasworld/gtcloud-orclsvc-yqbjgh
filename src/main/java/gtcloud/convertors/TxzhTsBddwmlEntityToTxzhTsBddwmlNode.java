package gtcloud.convertors;

import java.util.ArrayList;
import java.util.List;

import gtcloud.services.TxzyTsZbgcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.TxzhTsBddwml;
import gtcloud.model.TxzhTsBddwmlNode;
import gtcloud.services.TxzhTsBddwmlService;

@Component
public class TxzhTsBddwmlEntityToTxzhTsBddwmlNode implements Converter<TxzhTsBddwml, TxzhTsBddwmlNode> {

	@Autowired
	public TxzhTsBddwmlService bddwmlSvc;

	@Autowired
    public TxzyTsZbgcService zbgcSvc;

	@Override
	public TxzhTsBddwmlNode convert(TxzhTsBddwml entity) {
		TxzhTsBddwmlNode node = new TxzhTsBddwmlNode();
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

		// 叶子节点且没有地块的情况
        if (childenEntity.size() == 0 && !zbgcSvc.existsBySjcjdwnm(entity.getNm())) {
            return null;
        }

		for (TxzhTsBddwml e : childenEntity) {
			TxzhTsBddwmlNode childNode = this.convert(e);
            if (childNode != null) {
                childrenNode.add(childNode);
            }
		}
		node.setChildren(childrenNode);

		return node;
	}

}
