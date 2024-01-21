package testDAO;

import DAO.SinhVienDAO;
import database.JDBCUtil;
import model.SinhVien;

import java.util.Random;

public class test {
    public static void main(String[] args) {

        for (int i = 81; i <= 90; i++) {
            SinhVien s = new SinhVien("23IT.B0" + i+200,"Phạm Văn " + (char)i
                    ,"23IT2B","Chính Quy","Đã nộp học phí","Kỹ thuật máy tính");
            SinhVienDAO.getInstance().insert(s);
        }
        /*SinhVien s = new SinhVien("23IT.B034","Hoàng Đức Chính"
                ,"23IT3B","Chính Quy","Chưa nộp học phí","An toàn thông tin");
        SinhVienDAO.getInstance().insert(s);*/
    }
}
