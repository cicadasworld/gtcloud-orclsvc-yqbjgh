package gtcloud.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CampWarehouseMaterial {

	@Id
	private String jlbm;

	private Float warArea;

	private String materialKind;

	private String dangerousAttr;

	private String warehouseId;

	private float ccwzsl;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sjcjsj;

	private String sjcjry;

	public String getJlbm() {
		return jlbm;
	}

	public void setJlbm(String jlbm) {
		this.jlbm = jlbm;
	}

	public Float getWarArea() {
		return warArea;
	}

	public void setWarArea(Float warArea) {
		this.warArea = warArea;
	}

	public String getMaterialKind() {
		return materialKind;
	}

	public void setMaterialKind(String materialKind) {
		this.materialKind = materialKind;
	}

	public String getDangerousAttr() {
		return dangerousAttr;
	}

	public void setDangerousAttr(String dangerousAttr) {
		this.dangerousAttr = dangerousAttr;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public float getCcwzsl() {
		return ccwzsl;
	}

	public void setCcwzsl(float ccwzsl) {
		this.ccwzsl = ccwzsl;
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
