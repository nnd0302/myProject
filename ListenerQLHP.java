package controller;

import DAO.HocPhiDAO;
import model.HocPhi;
import model.SinhVien;
import view.QLHPView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListenerQLHP implements ActionListener {
    QLHPView l;
    public  ListenerQLHP(QLHPView l) {
        this.l = l;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String src = e.getActionCommand();
        if(src.equals("Search")) {
            l.tk();
        }
        if(src.equals("Thêm")) {
            l.luu();
        }
        if(src.equals("Sửa")){
            l.sua1();
        }
        if(src.equals("Xoá")){
            l.deleteSelectedRow1();
        }
    }
}
