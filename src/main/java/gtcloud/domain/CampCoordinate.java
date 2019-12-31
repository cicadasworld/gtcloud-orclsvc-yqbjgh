package gtcloud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CampCoordinate {

    @Id
    private String jlbm;

    private String fid;

    private Integer coordinateNum;

    @Column(name = "COOR_X")
    private String coorX;

    @Column(name = "COOR_Y")
    private String coorY;

    @Column(name = "CENTER_X")
    private String centerX;

    @Column(name = "CENTER_Y")
    private String centerY;

    public String getJlbm() {
        return jlbm;
    }

    public void setJlbm(String jlbm) {
        this.jlbm = jlbm;
    }

    public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public Integer getCoordinateNum() {
        return coordinateNum;
    }

    public void setCoordinateNum(Integer coordinateNum) {
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

    public String getCenterX() {
        return centerX;
    }

    public void setCenterX(String centerX) {
        this.centerX = centerX;
    }

    public String getCenterY() {
        return centerY;
    }

    public void setCenterY(String centerY) {
        this.centerY = centerY;
    }
}
