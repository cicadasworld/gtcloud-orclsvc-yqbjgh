package gtcloud.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CampApartUseclassDTO {

	private String jlbm;

	private String apartId;

	private String apartName;

	private String barrackUseClass;

	private Float barrackUseArea;

	private String barrackUseUnit;

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

	public String getBarrackUseClass() {
		return barrackUseClass;
	}

	public void setBarrackUseClass(String barrackUseClass) {
		this.barrackUseClass = barrackUseClass;
	}

	public Float getBarrackUseArea() {
		return barrackUseArea;
	}

	public void setBarrackUseArea(Float barrackUseArea) {
		this.barrackUseArea = barrackUseArea;
	}

	public String getBarrackUseUnit() {
		return barrackUseUnit;
	}

	public void setBarrackUseUnit(String barrackUseUnit) {
		this.barrackUseUnit = barrackUseUnit;
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
