package model;

public class HocSinh {
    private Integer hocSinhId;
    private String maHocSinh;
    private String tenHocSinh;
    private String lopHocSinh;


    public HocSinh(Integer hocSinhId, String maHocSinh, String tenHocSinh, String lopHocSinh) {
        this.hocSinhId = hocSinhId;
        this.maHocSinh = maHocSinh;
        this.tenHocSinh = tenHocSinh;
        this.lopHocSinh = lopHocSinh;
    }

    public Integer getHocSinhId() {
        return hocSinhId;
    }

    public void setHocSinhId(Integer hocSinhId) {
        this.hocSinhId = hocSinhId;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public String getLopHocSinh() {
        return lopHocSinh;
    }

    public void setLopHocSinh(String lopHocSinh) {
        this.lopHocSinh = lopHocSinh;
    }
}
