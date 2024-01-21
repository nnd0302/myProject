package controller;

import view.QLHPView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLHPListener implements ActionListener {
    private QLHPView ql;

    public QLHPListener(QLHPView ql) {
        this.ql = ql;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Thêm")) {
            ql.them();
        }
        if (src.equals("Xoá")) {
            ql.deleteSelectedRow();
        }
        if (src.equals("Tìm kiếm")) {
            ql.search();
        }
        if (src.equals("Sửa thông tin")) {
            ql.sua();
        }
        if (src.equals("Refresh")) {
            ql.Refresh();
        }
    }
}
