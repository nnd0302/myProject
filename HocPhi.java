package model;

public class HocPhi {
    private String MaSV;
    private String TenSV;
    private String Lop;
    private String Khoa;
    private int HocPhiDaNop;
    private int HocPhiConLai;

    public HocPhi() {
        super();
    }

    public HocPhi(String maSV, String tenSV, String lop, String khoa, int hocPhiDaNop, int hocPhiConLai) {
        MaSV = maSV;
        TenSV = tenSV;
        Lop = lop;
        Khoa = khoa;
        HocPhiDaNop = hocPhiDaNop;
        HocPhiConLai = hocPhiConLai;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }

    public int getHocPhiDaNop() {
        return HocPhiDaNop;
    }

    public void setHocPhiDaNop(int hocPhiDaNop) {
        HocPhiDaNop = hocPhiDaNop;
    }

    public int getHocPhiConLai() {
        return HocPhiConLai;
    }

    public void setHocPhiConLai(int hocPhiConLai) {
        HocPhiConLai = hocPhiConLai;
    }
}
