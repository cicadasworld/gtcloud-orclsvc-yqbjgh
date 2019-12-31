package gtcloud.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "RESIDENT_STAFF_CONDICTION")
public class ResidentStaffCondition {

	@Id
	private String jlbm;

	private String bdnm;

	private String staffKind;

	private Integer compileNum;

	private Integer realityNum;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

	public String getStaffKind() {
		return staffKind;
	}

	public void setStaffKind(String staffKind) {
		this.staffKind = staffKind;
	}

	public Integer getCompileNum() {
		return compileNum;
	}

	public void setCompileNum(Integer compileNum) {
		this.compileNum = compileNum;
	}

	public Integer getRealityNum() {
		return realityNum;
	}

	public void setRealityNum(Integer realityNum) {
		this.realityNum = realityNum;
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
