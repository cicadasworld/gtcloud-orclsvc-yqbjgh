package gtcloud.model;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CampApartCoordinateDTO {

	private String jlbm;

	private String apartId;

	private String apartName;

	private String coordinateNum;

	@Column(name = "COOR_X")
	private String coorX;

	@Column(name = "COOR_Y")
	private String coorY;

	private String coorLength;

	private String coorHeigh;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	public String getApartName() {
		return apartName;
	}

	public void setApartName(String apartName) {
		this.apartName = apartName;
	}

	public String getCoordinateNum() {
		return coordinateNum;
	}

	public void setCoordinateNum(String coordinateNum) {
		this.coordinateNum = coordinateNum;
	}

	public String getCoorX() {
		return coorX;
	}

	public void setCoorX(String coorX) {
		this.coorX = coorX;
	}

	public String getCoorY() {
		return coorY;
	}

	public void setCoorY(String coorY) {
		this.coorY = coorY;
	}

	public String getCoorLength() {
		return coorLength;
	}

	public void setCoorLength(String coorLength) {
		this.coorLength = coorLength;
	}

	public String getCoorHeigh() {
		return coorHeigh;
	}

	public void setCoorHeigh(String coorHeigh) {
		this.coorHeigh = coorHeigh;
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
