package gtcloud.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CampBatgroundFacilities {

	@Id
	private String jlbm;

	private String campId;

	private String batName;

	private String batKind;

	private Float batArea;

	private String batFunction;

	private String managementUnit;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sjcjsj;

	private String sjcjry;

	public String getJlbm() {
		return jlbm;
	}

	public void setJlbm(String jlbm) {
		this.jlbm = jlbm;
	}

	public String getCampId() {
		return campId;
	}

	public void setCampId(String campId) {
		this.campId = campId;
	}

	public String getBatName() {
		return batName;
	}

	public void setBatName(String batName) {
		this.batName = batName;
	}

	public String getBatKind() {
		return batKind;
	}

	public void setBatKind(String batKind) {
		this.batKind = batKind;
	}

	public Float getBatArea() {
		return batArea;
	}

	public void setBatArea(Float batArea) {
		this.batArea = batArea;
	}

	public String getBatFunction() {
		return batFunction;
	}

	public void setBatFunction(String batFunction) {
		this.batFunction = batFunction;
	}

	public String getManagementUnit() {
		return managementUnit;
	}

	public void setManagementUnit(String managementUnit) {
		this.managementUnit = managementUnit;
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
