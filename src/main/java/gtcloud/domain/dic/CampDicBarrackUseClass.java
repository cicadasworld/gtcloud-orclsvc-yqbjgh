package gtcloud.domain.dic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CampDicBarrackUseClass {

	@Id
	private String nm;

	private int xh;

	private String mc;

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public int getXh() {
		return xh;
	}

	public void setXh(int xh) {
		this.xh = xh;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}
}
