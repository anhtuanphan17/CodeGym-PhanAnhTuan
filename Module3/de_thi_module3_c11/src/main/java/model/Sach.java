package model;

public class Sach {
    private Integer sachId;
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String moTa;
    private Integer soLuong;

    public Sach(Integer sachId, String maSach, String tenSach, String tacGia, String moTa, Integer soLuong) {
        this.sachId = sachId;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    public Integer getSachId() {
        return sachId;
    }

    public void setSachId(Integer sachId) {
        this.sachId = sachId;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
