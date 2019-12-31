package gtcloud.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResidentUnitCampusingDTO {

	private String jlbm;

	private String bdnm;

	private String mc;

	private String campId;

	private String remarks;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sjcjsj;

	private String sjcjry;

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

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getCampId() {
		return campId;
	}

	public void setCampId(String campId) {
		this.campId = campId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
