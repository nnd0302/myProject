package model;

public class SinhVien {
    private String MaSV;
    private String TenSV;
    private String Lop;
    private String HeHoc;
    private String TinhTrang;
    private String Khoa;

    public SinhVien() {
        super();
    }

    public SinhVien(String maSV, String tenSV, String lop, String heHoc, String tinhTrang, String khoa) {
        MaSV = maSV;
        TenSV = tenSV;
        Lop = lop;
        HeHoc = heHoc;
        TinhTrang = tinhTrang;
        Khoa = khoa;
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

    public String getHeHoc() {
        return HeHoc;
    }

    public void setHeHoc(String heHoc) {
        HeHoc = heHoc;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getKhoa() {
        return Khoa;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }
}
