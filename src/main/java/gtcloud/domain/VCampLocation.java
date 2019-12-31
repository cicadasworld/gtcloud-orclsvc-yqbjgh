package gtcloud.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "V_CAMP_LOCATION")
public class VCampLocation {

	private String bdnm;

	private String bdmc;

	private String jlbm;

    @Id
	private String dknm;

	private String dkmc;

	private String campWord;

	private String campCode;

	private String campKind;

	private String adminDivision;

	private String detailAddress;

	private Float campArea;

	private String siteKind;

	private String watersupplyMode;

	private String elecsupplyMode;

	private String gassupplyMode;

	private String heatsupplyMode;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sjcjsj;

	private String sjcjry;

	public String getBdnm() {
		return bdnm;
	}

	public void setBdnm(String bdnm) {
		this.bdnm = bdnm;
	}

	public String getBdmc() {
		return bdmc;
	}

	public void setBdmc(String bdmc) {
		this.bdmc = bdmc;
	}

	public String getJlbm() {
		return jlbm;
	}

	public void setJlbm(String jlbm) {
		this.jlbm = jlbm;
	}

	public String getDknm() {
		return dknm;
	}

	public void setDknm(String dknm) {
		this.dknm = dknm;
	}

	public String getDkmc() {
		return dkmc;
	}

	public void setDkmc(String dkmc) {
		this.dkmc = dkmc;
	}

	public String getCampWord() {
		return campWord;
	}

	public void setCampWord(String campWord) {
		this.campWord = campWord;
	}

	public String getCampCode() {
		return campCode;
	}

	public void setCampCode(String campCode) {
		this.campCode = campCode;
	}

	public String getCampKind() {
		return campKind;
	}

	public void setCampKind(String campKind) {
		this.campKind = campKind;
	}

	public String getAdminDivision() {
		return adminDivision;
	}

	public void setAdminDivision(String adminDivision) {
		this.adminDivision = adminDivision;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Float getCampArea() {
		return campArea;
	}

	public void setCampArea(Float campArea) {
		this.campArea = campArea;
	}

	public String getSiteKind() {
		return siteKind;
	}

	public void setSiteKind(String siteKind) {
		this.siteKind = siteKind;
	}

	public String getWatersupplyMode() {
		return watersupplyMode;
	}

	public void setWatersupplyMode(String watersupplyMode) {
		this.watersupplyMode = watersupplyMode;
	}

	public String getElecsupplyMode() {
		return elecsupplyMode;
	}

	public void setElecsupplyMode(String elecsupplyMode) {
		this.elecsupplyMode = elecsupplyMode;
	}

	public String getGassupplyMode() {
		return gassupplyMode;
	}

	public void setGassupplyMode(String gassupplyMode) {
		this.gassupplyMode = gassupplyMode;
	}

	public String getHeatsupplyMode() {
		return heatsupplyMode;
	}

	public void setHeatsupplyMode(String heatsupplyMode) {
		this.heatsupplyMode = heatsupplyMode;
	}

	public Date getSjcjsj() {
		return sjcjsj;
	}

	public void setSjcjsj(Date sjcjsj) {
		this.sjcjsj = sjcjsj;
	}

	public String getSjcjry() {
		return sjcjry;
	}

	public void setSjcjry(String sjcjry) {
		this.sjcjry = sjcjry;
	}
}
