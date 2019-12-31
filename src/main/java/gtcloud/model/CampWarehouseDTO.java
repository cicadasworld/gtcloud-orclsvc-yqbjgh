package gtcloud.model;

import java.util.Date;

public class CampWarehouseDTO {

    private String jlbm;

    private String apartId;

    private String apartName;

    private String warKind;

    private String warName;

    private String campId;

    private String managementUnit;

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
