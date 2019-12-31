package gtcloud.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResidentUnitDTO {

	private String jlbm;

	private String bdnm;

	private String mission;

	private String grade;

	private String adminDivision;

	private String detailAddress;

	private String unitKind;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sjcjsj;

	private String sjcjry;

	private String mc;

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getJlbm() {
		return jlbm;
	}

	public void setJlbm(String jlbm) {
		this.jlbm = jlbm;
	}

	public String getBdnm() {
		return bdnm;
	}

	public void setBdnm(String bdnm) {
		this.bdnm = bdnm;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

	public String getUnitKind() {
		return unitKind;
	}

	public void setUnitKind(String unitKind) {
		this.unitKind = unitKind;
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
