package gtcloud.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TxzhTsBddwml {

	@Id
	private String nm;

	private String mc;

	private String xh;

	private String bdhfnm;

	private String bdhf;

	private String bdjc;

	private String bzxh;

	private String bzfh;

	private String bzjc;

	private String zzbd;

	private String parentnm;

	private String camp;

	private String resident;

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getBdhfnm() {
		return bdhfnm;
	}

	public void setBdhfnm(String bdhfnm) {
		this.bdhfnm = bdhfnm;
	}

	public String getBdhf() {
		return bdhf;
	}

	public void setBdhf(String bdhf) {
		this.bdhf = bdhf;
	}

	public String getBdjc() {
		return bdjc;
	}

	public void setBdjc(String bdjc) {
		this.bdjc = bdjc;
	}

	public String getBzxh() {
		return bzxh;
	}

	public void setBzxh(String bzxh) {
		this.bzxh = bzxh;
	}

	public String getBzfh() {
		return bzfh;
	}

	public void setBzfh(String bzfh) {
		this.bzfh = bzfh;
	}

	public String getBzjc() {
		return bzjc;
	}

	public void setBzjc(String bzjc) {
		this.bzjc = bzjc;
	}

	public String getZzbd() {
		return zzbd;
	}

	public void setZzbd(String zzbd) {
		this.zzbd = zzbd;
	}

	public String getParentnm() {
		return parentnm;
	}

	public void setParentnm(String parentnm) {
		this.parentnm = parentnm;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

}
