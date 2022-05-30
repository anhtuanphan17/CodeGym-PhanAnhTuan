package com.dethimodule5backend.model;

import javax.persistence.*;

@Entity
public class Tin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vungMien;
    private String daiDien;
    private String loaiBaiViet;
    private String tinhTrang;
    private String diaChi;
    private Integer dienTich;
    private String huong;
    private String tuaDe;
    @Column(columnDefinition = "LONGTEXT")
    private String noiDung;
    private Integer gia;
    @Column(columnDefinition = "date")
    private String ngayDang;
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "danh_muc_id", referencedColumnName = "danhMucId")
    private DanhMuc danhMuc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVungMien() {
        return vungMien;
    }

    public void setVungMien(String vungMien) {
        this.vungMien = vungMien;
    }

    public String getDaiDien() {
        return daiDien;
    }

    public void setDaiDien(String daiDien) {
        this.daiDien = daiDien;
    }

    public String getLoaiBaiViet() {
        return loaiBaiViet;
    }

    public void setLoaiBaiViet(String loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getDienTich() {
        return dienTich;
    }

    public void setDienTich(Integer dienTich) {
        this.dienTich = dienTich;
    }

    public String getHuong() {
        return huong;
    }

    public void setHuong(String huong) {
        this.huong = huong;
    }

    public String getTuaDe() {
        return tuaDe;
    }

    public void setTuaDe(String tuaDe) {
        this.tuaDe = tuaDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
