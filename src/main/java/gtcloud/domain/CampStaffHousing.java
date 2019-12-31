package gtcloud.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CampStaffHousing {

	@Id
	private String jlbm;

	private String campId;

	private String apartId;

	private String cellNum;

	private String houseNum;

	private String staffKind;

	private String houseKind;

	private String houseStandardGrade;

	private float houseStandardArea;

	@Column(name = "STUFF_NAME")
	private String staffName;

	private String workingUnit;

	private String mobilePhone;

	private String usualResidentNum;

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

	public String getApartId() {
		return apartId;
	}

	public void setApartId(String apartId) {
		this.apartId = apartId;
	}

	public String getCellNum() {
		return cellNum;
	}

	public void setCellNum(String cellNum) {
		this.cellNum = cellNum;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getStaffKind() {
		return staffKind;
	}

	public void setStaffKind(String staffKind) {
		this.staffKind = staffKind;
	}

	public String getHouseKind() {
		return houseKind;
	}

	public void setHouseKind(String houseKind) {
		this.houseKind = houseKind;
	}

	public String getHouseStandardGrade() {
		return houseStandardGrade;
	}

	public void setHouseStandardGrade(String houseStandardGrade) {
		this.houseStandardGrade = houseStandardGrade;
	}

	public float getHouseStandardArea() {
		return houseStandardArea;
	}

	public void setHouseStandardArea(float houseStandardArea) {
		this.houseStandardArea = houseStandardArea;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getWorkingUnit() {
		return workingUnit;
	}

	public void setWorkingUnit(String workingUnit) {
		this.workingUnit = workingUnit;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getUsualResidentNum() {
		return usualResidentNum;
	}

	public void setUsualResidentNum(String usualResidentNum) {
		this.usualResidentNum = usualResidentNum;
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
