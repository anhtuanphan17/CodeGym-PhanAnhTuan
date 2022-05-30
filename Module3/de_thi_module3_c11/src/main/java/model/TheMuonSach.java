package model;

public class TheMuonSach {
    private Integer theMuonSachId;
    private String maMuonSach;
    private Sach sachId;
    private HocSinh hocSinhId;
    private boolean trangThai;
    private String ngayMuon;
    private String ngayTra;

    public TheMuonSach(Integer theMuonSachId, String maMuonSach, Sach sachId, HocSinh hocSinhId, boolean trangThai, String ngayMuon, String ngayTra) {
        this.theMuonSachId = theMuonSachId;
        this.maMuonSach = maMuonSach;
        this.sachId = sachId;
        this.hocSinhId = hocSinhId;
        this.trangThai = trangThai;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public Integer getTheMuonSachId() {
        return theMuonSachId;
    }

    public void setTheMuonSachId(Integer theMuonSachId) {
        this.theMuonSachId = theMuonSachId;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public Sach getSachId() {
        return sachId;
    }

    public void setSachId(Sach sachId) {
        this.sachId = sachId;
    }

    public HocSinh getHocSinhId() {
        return hocSinhId;
    }

    public void setHocSinhId(HocSinh hocSinhId) {
        this.hocSinhId = hocSinhId;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}
