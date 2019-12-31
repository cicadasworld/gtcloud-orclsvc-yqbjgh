package gtcloud.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CampTrainingField {

	@Id
	private String jlbm;

	private String campId;

	private String traName;

	private String traKind;

	private Float traArea;

	private String traUsingCondition;

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

	public String getTraName() {
		return traName;
	}

	public void setTraName(String traName) {
		this.traName = traName;
	}

	public String getTraKind() {
		return traKind;
	}

	public void setTraKind(String traKind) {
		this.traKind = traKind;
	}

	public Float getTraArea() {
		return traArea;
	}

	public void setTraArea(Float traArea) {
		this.traArea = traArea;
	}

	public String getTraUsingCondition() {
		return traUsingCondition;
	}

	public void setTraUsingCondition(String traUsingCondition) {
		this.traUsingCondition = traUsingCondition;
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
