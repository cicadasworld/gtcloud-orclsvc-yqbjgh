package gtcloud.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CampApartBuilding {

	@Id
	private String jlbm;

	private String campId;

	private String apartNum;

	private String apartName;

	private Float floorArea;

	private String usingStatus;

	private String floorYear;

	private Integer floorlevelUp;

	private Integer floorlevelDown;

	private String buildingStructure;

	private String qualityGrade;

	private Integer elevatorNum;

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

	public String getApartNum() {
		return apartNum;
	}

	public void setApartNum(String apartNum) {
		this.apartNum = apartNum;
	}

	public String getApartName() {
		return apartName;
	}

	public void setApartName(String apartName) {
		this.apartName = apartName;
	}

	public Float getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Float floorArea) {
		this.floorArea = floorArea;
	}

	public String getUsingStatus() {
		return usingStatus;
	}

	public void setUsingStatus(String usingStatus) {
		this.usingStatus = usingStatus;
	}

	public String getFloorYear() {
		return floorYear;
	}

	public void setFloorYear(String floorYear) {
		this.floorYear = floorYear;
	}

	public Integer getFloorlevelUp() {
		return floorlevelUp;
	}

	public void setFloorlevelUp(Integer floorlevelUp) {
		this.floorlevelUp = floorlevelUp;
	}

	public Integer getFloorlevelDown() {
		return floorlevelDown;
	}

	public void setFloorlevelDown(Integer floorlevelDown) {
		this.floorlevelDown = floorlevelDown;
	}

	public String getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(String buildingStructure) {
		this.buildingStructure = buildingStructure;
	}

	public String getQualityGrade() {
		return qualityGrade;
	}

	public void setQualityGrade(String qualityGrade) {
		this.qualityGrade = qualityGrade;
	}

	public Integer getElevatorNum() {
		return elevatorNum;
	}

	public void setElevatorNum(Integer elevatorNum) {
		this.elevatorNum = elevatorNum;
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
