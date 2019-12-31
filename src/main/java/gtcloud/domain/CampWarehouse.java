package gtcloud.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CampWarehouse {

	@Id
	private String jlbm;

	private String apartId;

	private String warKind;

	private String warName;

	private String campId;

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

	public String getApartId() {
		return apartId;
	}

	public void setApartId(String apartId) {
		this.apartId = apartId;
	}

	public String getWarKind() {
		return warKind;
	}

	public void setWarKind(String warKind) {
		this.warKind = warKind;
	}

	public String getWarName() {
		return warName;
	}

	public void setWarName(String warName) {
		this.warName = warName;
	}

	public String getCampId() {
		return campId;
	}

	public void setCampId(String campId) {
		this.campId = campId;
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
