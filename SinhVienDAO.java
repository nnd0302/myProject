package DAO;

import com.mysql.cj.conf.url.FailoverConnectionUrl;
import database.JDBCUtil;
import model.SinhVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SinhVienDAO implements DAOInterface <SinhVien>{
    public static SinhVienDAO getInstance() {
        return new SinhVienDAO();
    }
    @Override
    public int insert(SinhVien t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO thongtinsinhvien(MaSV,TenSV, Lop, HeHoc, TinhTrang, Khoa) " +
                    " VALUES ('" +  t.getMaSV() + "','" + t.getTenSV() + "','" + t.getLop()
                    + "','" + t.getHeHoc() + "','" + t.getTinhTrang() + "','" + t.getKhoa() + "')";
            ketQua = st.executeUpdate(sql);
            if (ketQua > 0) {
                System.out.println("Bạn đã thực thi" + sql);
                System.out.println("Có " + ketQua + " dòng bị thay đổi!");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(SinhVien t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "UPDATE thongtinsinhvien SET MaSV = '" + t.getMaSV() + "', TenSV = '" + t.getTenSV() +
                    "', Lop = '"  + t.getLop() + "', HeHoc = '"+ t.getHeHoc()
                    + "',TinhTrang = '"+ t.getTinhTrang() + "',Khoa = '"+ t.getKhoa()  + "'" +
            " WHERE MaSV = '" + t.getMaSV() + "'";
            ketQua = st.executeUpdate(sql);
            if (ketQua > 0) {
                System.out.println("Bạn đã thực thi" + sql);
                System.out.println("Có " + ketQua + " dòng bị thay đổi!");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(SinhVien t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE FROM thongtinsinhvien WHERE MaSV = '" + t.getMaSV() + "'";
            ketQua = st.executeUpdate(sql);
            if (ketQua > 0) {
                System.out.println("Bạn đã thực thi" + sql);
                System.out.println("Có " + ketQua + " dòng bị thay đổi!");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<SinhVien> selectAll() {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM thongtinsinhvien";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSV = rs.getString("MaSV");
                String TenSV = rs.getString("TenSV");
                String Lop = rs.getString("Lop");
                String HeHoc = rs.getString("HeHoc");
                String TinhTrang = rs.getString("TinhTrang");
                String Khoa = rs.getString("Khoa");
                SinhVien sinhVien = new SinhVien( MaSV,TenSV, Lop, HeHoc, TinhTrang, Khoa);
                ketQua.add(sinhVien);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public SinhVien selectById(SinhVien t) {
        SinhVien ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM thongtinsinhvien WHERE MaSV = '" + t.getMaSV() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ketQua = new SinhVien(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<SinhVien> selectByCondition(String Condition) {
        return null;
    }
}
