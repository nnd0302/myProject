package DAO;


import database.JDBCUtil;
import model.HocPhi;
import model.SinhVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class HocPhiDAO implements DAOInterface<HocPhi>{
    public static HocPhiDAO getInstance() {
        return new HocPhiDAO();
    }

    @Override
    public int insert(HocPhi t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO hocphi(MaSV,TenSV, Lop, Khoa, HocPhiDaNop, HocPhiConLai) " +
                    " VALUES ('" +  t.getMaSV() + "','" + t.getTenSV() + "','" + t.getLop()
                    + "','" + t.getKhoa() + "','" + t.getHocPhiDaNop() + "','" + t.getHocPhiConLai() + "')";
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
    public int update(HocPhi t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "UPDATE hocphi SET MaSV = '" + t.getMaSV() + "', TenSV = '" + t.getTenSV() +
                    "', Lop = '"  + t.getLop() + "', Khoa = '"+ t.getKhoa()
                    + "',HocPhiDaNop = '"+ t.getHocPhiDaNop() + "', HocPhiConLai = '"+ t.getHocPhiConLai()  + "'" +
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
    public int delete(HocPhi t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE FROM hocphi WHERE MaSV = '" + t.getMaSV() + "'";
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
    public ArrayList<HocPhi> selectAll() {
        ArrayList<HocPhi> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM hocphi";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSV = rs.getString("MaSV");
                String TenSV = rs.getString("TenSV");
                String Lop = rs.getString("Lop");
                String Khoa = rs.getString("Khoa");
                int HocPhiDaNop = rs.getInt("HocPhiDaNop");
                int HocPhiConLai = rs.getInt("HocPhiConLai");
                HocPhi hocPhi = new HocPhi( MaSV,TenSV, Lop, Khoa, HocPhiDaNop, HocPhiConLai);
                ketQua.add(hocPhi);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public HocPhi selectById(HocPhi t) {
        HocPhi ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM hocphi WHERE MaSV = '" + t.getMaSV() + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ketQua = new HocPhi(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getInt(5),rs.getInt(6));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HocPhi> selectByCondition(String Condition) {
        return null;
    }
}
