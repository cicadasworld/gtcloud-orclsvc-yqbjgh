package gtcloud.convertors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gtcloud.domain.TxzyTsZbgc;
import gtcloud.model.TxzyTsZbgcNode;
import gtcloud.services.TxzyTsZbgcService;

@Component
public class TxzyTsZbgcEntityToTxzyTsZbgcNode implements Converter<TxzyTsZbgc, TxzyTsZbgcNode> {

	@Autowired
	public TxzyTsZbgcService service;


	@Override
	public TxzyTsZbgcNode convert(TxzyTsZbgc entity) {
		TxzyTsZbgcNode node = new TxzyTsZbgcNode();
		node.setDh(entity.getDh());
		node.setMc(entity.getMc());
		node.setNm(entity.getNm());
		node.setParentnm(entity.getParentnm());
		node.setSfjd(entity.getSfjd());
		node.setSfysj(entity.getSfysj());
		node.setSjcjdwnm(entity.getSjcjdwnm());
		node.setSjcjdwxh(entity.getSjcjdwxh());
		node.setSjcjr(entity.getSjcjr());
		node.setSjcjsj(entity.getSjcjsj());
		node.setXh(entity.getXh());

		List<TxzyTsZbgcNode> childrenNode = new ArrayList<>();

		List<TxzyTsZbgc> childenEntity = service.getBySjcjdwnm(entity.getNm());
		for (TxzyTsZbgc e : childenEntity) {
			TxzyTsZbgcNode childNode = convert(e);
			childrenNode.add(childNode);
		}

		node.setChildren(childrenNode);
		return node;
	}

}
