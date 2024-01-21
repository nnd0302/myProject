package view;

import DAO.HocPhiDAO;
import DAO.SinhVienDAO;
import controller.ListenerQLHP;
import controller.QLHPListener;
import model.HocPhi;
import model.SinhVien;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class QLHPView extends JFrame {
    SinhVien sinhVien;
    //Panel Left
    JPanel pnLeft;
    JLabel lb_Title;
    JButton bt_SV;
    JButton bt_hocPhi;
    JLabel lb_iconthead;

    //Panel Center
    JPanel pnCenter;
    JTextField tf_MaSV;
    JTextField tf_TenSV;
    JTextField tf_Lop;
    JComboBox cb_HeDaoTao;
    JComboBox cb_TinhTrang;
    JComboBox cb_Khoa;
    JButton bt_thuTien;
    JButton bt_timKiem;
    JButton bt_luu;
    JButton bt_them;
    JButton bt_sua;
    JButton bt_xoa;
    JButton bt_refresh;
    DefaultTableModel dm;
    JTable table;
    public static JFrame jf;
    public static JFrame fj;

    //pnCenter_Center2
    JLabel cb_Search;
    JTextField tf_Search;
    JButton bt_Search;
    DefaultTableModel tableModel = new DefaultTableModel();
    JTable tb_Search;
    JLabel label_masv;
    JLabel label_tensv;
    JLabel label_lop;
    JLabel label_hocdanop;
    JLabel label_hocphiconlai;
    JLabel label_tonghocphi;
    JTextField textField_masv;
    JTextField textField_tensv;
    JTextField textField_lop;
    JFormattedTextField textField_hocdanop;
    JFormattedTextField textField_hocphiconlai;
    JFormattedTextField textField_tonghocphi;
    JButton bt_s;
    JButton bt_rf;
    JButton bt_update;
    JButton bt_delete;
    public QLHPView() throws ClassNotFoundException {
        setTitle("Chương trình quản lý chi phí trên các trang đào tạo");
        setSize(1400,778);
        setLocationRelativeTo(null);
        ActionListener ac = new QLHPListener(this);

        //Panel Left
        pnLeft = new JPanel();
        pnLeft.setLayout(new BorderLayout());
        JScrollPane js = new JScrollPane(pnLeft, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JPanel pnLeft_North = new JPanel();
        pnLeft_North.setLayout(new GridLayout(5,1));
        JPanel pn_title = new JPanel();
        pn_title.setPreferredSize(new Dimension(250,50));
        JLabel lb_image = new JLabel(new ImageIcon("C:\\image\\graduation.png"));
        lb_Title = new JLabel("<html><center>HỆ THỐNG QUẢN LÝ <br> HỌC PHÍ PARK CHAEYOUNG</center></html>");
        pn_title.add(lb_Title);
        lb_Title.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 15));
        bt_SV = new JButton("Sinh viên");
        bt_hocPhi = new JButton("Học phí");

        pnLeft_North.add(lb_image);
        pnLeft_North.add(pn_title);
        pnLeft_North.add(bt_SV);
        pnLeft_North.add(bt_hocPhi);

        pnLeft.add(pnLeft_North, BorderLayout.NORTH);

        //Panel Center
        pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout(50,50));

        //pnCenter North
        JPanel pnCenter_North = new JPanel();

        //pnCenter_North.setBackground(Color.white);
        pnCenter_North.setLayout(new FlowLayout());

        JLabel lb_User = new JLabel("HỆ THỐNG QUẢN LÝ HỌC PHÍ");
        lb_User.setFont(new Font("Arial", Font.BOLD, 20));
        pnCenter_North.add(lb_User );

        //pnCenter Center1
        JPanel pnCenter_Center1 = new JPanel();
        pnCenter_Center1.setLayout(new BorderLayout(25,25));

        //ACTIONLISTENER
        ActionListener ls = new ListenerQLHP(this);
        
        //pnCenter CENTER 2
        JPanel pnCenter_Center2 = new JPanel();
        pnCenter_Center2.setLayout(new BorderLayout());
        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        bt_s = new JButton("Thêm");
        bt_s.addActionListener(ls);
        bt_rf = new JButton("Refresh");
        bt_rf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                ArrayList<HocPhi> hphi = HocPhiDAO.getInstance().selectAll();
                for (HocPhi hocphi : hphi) {
                    tableModel.addRow(new String[]{hocphi.getMaSV(), hocphi.getTenSV(), hocphi.getLop(), hocphi.getKhoa()
                            , hocphi.getHocPhiDaNop()+"", hocphi.getHocPhiConLai()+""});
                }
            }
        });
        bt_rf.addActionListener(ls);
        bt_update = new JButton("Sửa");
        bt_update.addActionListener(ls);
        bt_delete = new JButton("Xoá");
        bt_delete.addActionListener(ls);
        pn2.add(bt_s);
        pn2.add(bt_update);
        pn2.add(bt_delete);
        pn2.add(bt_rf);

        JPanel pn3 = new JPanel();
        pn3.setPreferredSize(new Dimension(100,100));
        JPanel pn4 = new JPanel();
        pn4.setPreferredSize(new Dimension(100,100));

        JPanel pn5 = new JPanel();
        pn5.setLayout(new BorderLayout(30,30));
        JPanel pn5_TOP = new JPanel();
        pn5_TOP.setLayout(new BorderLayout(10,10));
        JPanel pn5Top_North = new JPanel();
        pn5Top_North.setLayout(new FlowLayout());
        cb_Search = new JLabel("Mã sinh viên:");
        tf_Search = new JTextField(25);
        bt_Search = new JButton("Search");
        bt_Search.addActionListener(ls);
        pn5Top_North.add(cb_Search);
        pn5Top_North.add(tf_Search);
        pn5Top_North.add(bt_Search);
        JPanel pn5TOP_Center = new JPanel();
        pn5TOP_Center.setPreferredSize(new Dimension(500,90));
        label_hocdanop = new JLabel("Học phí đã nộp:");
        label_hocphiconlai = new JLabel("Học phí còn lại:");
        label_tonghocphi = new JLabel("Tổng học phí");
        textField_hocdanop = new JFormattedTextField();
        textField_hocphiconlai = new JFormattedTextField();
        textField_tonghocphi = new JFormattedTextField();
        pn5TOP_Center.setLayout(new GridLayout(1,2));
        JPanel pn5TOP_Right = new JPanel();
        pn5TOP_Right.setLayout(new BorderLayout());
        JPanel pn5TOP_Right1 = new JPanel();
        pn5TOP_Right1.setLayout(new GridLayout(3,1,5,5));
        JPanel pn5TOP_Right2 = new JPanel();
        pn5TOP_Right2.setLayout(new GridLayout(3,1,5,5));
        pn5TOP_Right1.add(label_hocdanop);
        pn5TOP_Right1.add(label_hocphiconlai);
        pn5TOP_Right1.add(label_tonghocphi);
        pn5TOP_Right2.add(textField_hocdanop);
        pn5TOP_Right2.add(textField_hocphiconlai);
        pn5TOP_Right2.add(textField_tonghocphi);

        pn5TOP_Right.add(pn5TOP_Right1, BorderLayout.WEST);
        pn5TOP_Right.add(pn5TOP_Right2, BorderLayout.CENTER);

        JPanel pn5TOP_Left = new JPanel();
        pn5TOP_Left.setLayout(new BorderLayout());
        JPanel pn5TOP_Left1 = new JPanel();
        pn5TOP_Left1.setLayout(new GridLayout(3,1,5,5));
        JPanel pn5TOP_Left2 = new JPanel();
        pn5TOP_Left2.setLayout(new GridLayout(3,1,5,5));
        label_masv = new JLabel("Mã sinh viên:");
        label_tensv = new JLabel("Tên sinh viên:");
        label_lop = new JLabel("Lớp:");
        textField_masv = new JTextField();
        textField_tensv = new JTextField();
        textField_lop = new JTextField();
        pn5TOP_Left1.add(label_masv);
        pn5TOP_Left1.add(label_tensv);
        pn5TOP_Left1.add(label_lop);
        pn5TOP_Left2.add(textField_masv);
        pn5TOP_Left2.add(textField_tensv);
        pn5TOP_Left2.add(textField_lop);
        pn5TOP_Left.add(pn5TOP_Left1, BorderLayout.WEST);
        pn5TOP_Left.add(pn5TOP_Left2, BorderLayout.CENTER);

        JPanel pnDis = new JPanel();

        pn5TOP_Center.add(pn5TOP_Left, BorderLayout.WEST);
        pn5TOP_Center.add(pnDis, BorderLayout.CENTER);
        pn5TOP_Center.add(pn5TOP_Right, BorderLayout.EAST);

        pn5_TOP.add(pn5Top_North, BorderLayout.NORTH);
        pn5_TOP.add(pn5TOP_Center, BorderLayout.CENTER);
        JPanel pn5_BOT = new JPanel();

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Họ và tên");
        tableModel.addColumn("Lớp");
        tableModel.addColumn("Khoa");
        tableModel.addColumn("Học phí đã nộp");
        tableModel.addColumn("Học phí còn lại");
        tb_Search = new JTable(tableModel);
        ArrayList<HocPhi> hphi = HocPhiDAO.getInstance().selectAll();
        for (HocPhi hocphi : hphi) {
            tableModel.addRow(new String[]{hocphi.getMaSV(), hocphi.getTenSV(), hocphi.getLop(), hocphi.getKhoa()
            , hocphi.getHocPhiDaNop()+"", hocphi.getHocPhiConLai()+""});
        }
        DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tb_Search.getTableHeader().getDefaultRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        JScrollPane sc5 = new JScrollPane(tb_Search,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc5.setPreferredSize(new Dimension(900,480));
        pn5_BOT.add(sc5, BorderLayout.SOUTH);

        pn5.add(pn5_TOP, BorderLayout.NORTH);
        pn5.add(pn5_BOT, BorderLayout.CENTER);
        pnCenter_Center2.add(pn1, BorderLayout.NORTH);
        pnCenter_Center2.add(pn2, BorderLayout.SOUTH);
        pnCenter_Center2.add(pn3, BorderLayout.WEST);
        pnCenter_Center2.add(pn4, BorderLayout.EAST);
        pnCenter_Center2.add(pn5, BorderLayout.CENTER);


        // pn ChuaTop
        JPanel pnChuaTop = new JPanel();
        pnChuaTop.setLayout(new BorderLayout());
        //pnTop
        JPanel pnTop = new JPanel();
        JPanel pnN = new JPanel();
        pnN.setPreferredSize(new Dimension(100,30));
        JPanel pnDisL = new JPanel();
        pnDisL.setPreferredSize(new Dimension(80,100));
        JPanel pnDisM = new JPanel();
        pnDisM.setLayout(new GridLayout(1,1));
        JPanel pnDisR = new JPanel();
        pnDisR.setPreferredSize(new Dimension(80,100));
        pnTop.setLayout(new GridLayout(1,2,200,200));
        pnTop.setPreferredSize(new Dimension(800,100));
        JPanel pnTop_Left = new JPanel();
        pnTop_Left.setLayout(new GridLayout(1,2,10,10));

        pnDisM.add(pnTop);

        pnChuaTop.add(pnDisL, BorderLayout.WEST);
        pnChuaTop.add(pnDisM, BorderLayout.CENTER);
        pnChuaTop.add(pnDisR, BorderLayout.EAST);
        pnChuaTop.add(pnN, BorderLayout.NORTH);

        //TOP LEFT
        pnTop_Left.setLayout(new BorderLayout());
        JLabel lb_MaSV = new JLabel("Mã sinh viên:");
        JLabel lb_TenSV = new JLabel("Tên sinh viên:");
        JLabel lb_Lop = new JLabel("Lớp:");
        JPanel pnTopleft_L = new JPanel();
        pnTopleft_L.setLayout(new GridLayout(3,1,10,10));
        pnTopleft_L.add(lb_MaSV);
        pnTopleft_L.add(lb_TenSV);
        pnTopleft_L.add(lb_Lop);
        JPanel pnTopleft_R = new JPanel();
        pnTopleft_R.setLayout(new GridLayout(3,1,10,10));
        tf_TenSV = new JTextField();
        tf_MaSV = new JTextField();
        tf_Lop = new JTextField();
        pnTopleft_R.add(tf_MaSV);
        pnTopleft_R.add(tf_TenSV);
        pnTopleft_R.add(tf_Lop);
        pnTop_Left.add(pnTopleft_L, BorderLayout.WEST);
        pnTop_Left.add(pnTopleft_R, BorderLayout.CENTER);
        //TOP RIGHT
        JLabel lb_HeDaoTao = new JLabel("Hệ đào tạo:");
        JLabel lb_TinhTrang = new JLabel("Tình trạng:");
        JLabel lb_Khoa = new JLabel("Khoa:");
        cb_HeDaoTao = new JComboBox();
        cb_HeDaoTao.addItem("Chính Quy");
        cb_TinhTrang = new JComboBox();
        cb_TinhTrang.addItem("Đã nộp học phí");
        cb_TinhTrang.addItem("Chưa nộp học phí");
        cb_Khoa = new JComboBox();
        cb_Khoa.addItem("Khoa học máy tính");
        cb_Khoa.addItem("Kỹ thuật máy tính");
        cb_Khoa.addItem("An toàn thông tin");
        JPanel pnTop_Right = new JPanel();
        pnTop_Right.setLayout(new BorderLayout());
        JPanel pnTopRight_L = new JPanel();
        pnTopRight_L.add(lb_HeDaoTao);
        pnTopRight_L.add(lb_TinhTrang);
        pnTopRight_L.add(lb_Khoa);
        pnTopRight_L.setLayout(new GridLayout(3,1,10,10));
        JPanel pnTopRight_R = new JPanel();
        pnTopRight_R.add(cb_HeDaoTao);
        pnTopRight_R.add(cb_TinhTrang);
        pnTopRight_R.add(cb_Khoa);
        pnTopRight_R.setLayout(new GridLayout(3,1,10,10));
        pnTop_Right.add(pnTopRight_L, BorderLayout.WEST);
        pnTop_Right.add(pnTopRight_R, BorderLayout.CENTER);
        pnTop.add(pnTop_Left);
        pnTop.add(pnTop_Right);

        //pnMid
        JPanel pnMid = new JPanel();
        dm = new DefaultTableModel();
        dm.addColumn("Mã sinh viên");
        dm.addColumn("Họ và tên");
        dm.addColumn("Lớp");
        dm.addColumn("Hệ đào tạo");
        dm.addColumn("Tình trạng");
        dm.addColumn("Khoa");
        SinhVienDAO svd = new SinhVienDAO();
        svd.selectAll();
        for (SinhVien sinhVien : svd.selectAll()) {
            dm.addRow(new String[]{sinhVien.getMaSV(), sinhVien.getTenSV(), sinhVien.getLop(),
            sinhVien.getHeHoc(), sinhVien.getTinhTrang(), sinhVien.getKhoa()});
        }
        table = new JTable(dm);

        // Đặt title cột ra ở giữa
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        JScrollPane sc = new JScrollPane(table);
        sc.setPreferredSize(new Dimension(1000,476));
        pnMid.add(sc);

        //pnBot
        JPanel pnBot = new JPanel();
        pnBot.setLayout(new FlowLayout());

        bt_timKiem = new JButton("Tìm kiếm");
        bt_timKiem.addActionListener(ac);

        bt_them = new JButton("Thêm");
        bt_them.addActionListener(ac);
        bt_sua = new JButton("Sửa thông tin");
        bt_sua.addActionListener(ac);
        bt_xoa = new JButton("Xoá");
        bt_xoa.addActionListener(ac);
        bt_refresh = new JButton("Refresh");
        bt_refresh.addActionListener(ac);

        pnBot.add(bt_timKiem);

        pnBot.add(bt_them);
        pnBot.add(bt_sua);
        pnBot.add(bt_xoa);
        pnBot.add(bt_refresh);
        //pnCenter Center ADD
        pnCenter_Center1.add(pnChuaTop, BorderLayout.NORTH);
        pnCenter_Center1.add(pnMid, BorderLayout.CENTER);
        pnCenter_Center1.add(pnBot, BorderLayout.SOUTH);

        //CardLayout
        JPanel pnCard = new JPanel();
        pnCard.setLayout(new CardLayout());
        bt_hocPhi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) pnCard.getLayout();
                cardLayout.show(pnCard, "mycard2");

            }
        });
        bt_SV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) pnCard.getLayout();
                cardLayout.show(pnCard, "mycard1");
            }
        });



        pnCard.add(pnCenter_Center1, "mycard1");
        pnCard.add(pnCenter_Center2, "mycard2");
        pnCenter.add(pnCenter_North, BorderLayout.NORTH);
        pnCenter.add(pnCard, BorderLayout.CENTER);

        // Slpit pane
        JSplitPane j = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnCenter_North, pnCard);
        j.setDividerSize(2);
        j.setEnabled(false);

        // this.Add
        this.add(js, BorderLayout.WEST);
        this.getContentPane().add(j, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void Refresh() {
        dm.setRowCount(0);
        SinhVienDAO svd = new SinhVienDAO();
        svd.selectAll();
        for (SinhVien sinhVien : svd.selectAll()) {
            dm.addRow(new String[]{sinhVien.getMaSV(), sinhVien.getTenSV(), sinhVien.getLop(),
                    sinhVien.getHeHoc(), sinhVien.getTinhTrang(), sinhVien.getKhoa()});
        }
    }

    //cửa sổ thông báo mã sinh viên đã tồn tại
    class exist extends JFrame {
        public exist() {
            fj = new JFrame();
            fj.setTitle("Mã sinh viên đã tồn tại");
            fj.setLocation(500,300);
            fj.setSize(400,200);
            JLabel label = new JLabel("Mã sinh viên đã tồn tại");
            label.setIcon(new ImageIcon("C:\\image\\exist.png"));
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JPanel pn1 = new JPanel();
            pn1.setPreferredSize(new Dimension(50,50));
            JPanel pn2 = new JPanel();
            pn2.setPreferredSize(new Dimension(50,50));
            JPanel pn3 = new JPanel();
            pn3.setPreferredSize(new Dimension(90,50));
            JPanel pn4 = new JPanel();
            pn4.setPreferredSize(new Dimension(50,50));
            fj.setLayout(new BorderLayout());
            fj.add(pn1, BorderLayout.NORTH);
            fj.add(pn2, BorderLayout.SOUTH);
            fj.add(pn3, BorderLayout.WEST);
            fj.add(pn4, BorderLayout.EAST);
            fj.add(label, BorderLayout.CENTER);
            fj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            fj.setVisible(true);
            fj.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    fj = null;
                }
            });
        }
    }

    //HIỂN THỊ THÔNG BÁO MÃ SINH VIÊN KHÔNG TỒN TẠI
    class notExist extends JFrame{
        public notExist() {
            fj = new JFrame();
            fj.setTitle("Không tồn tại mã sinh viên");
            fj.setLocation(500,300);
            fj.setSize(500,200);
            JLabel label = new JLabel("Không tồn tại mã sinh viên");
            label.setIcon(new ImageIcon("C:\\image\\exist.png"));
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JPanel pn1 = new JPanel();
            pn1.setPreferredSize(new Dimension(50,50));
            JPanel pn2 = new JPanel();
            pn2.setPreferredSize(new Dimension(50,50));
            JPanel pn3 = new JPanel();
            pn3.setPreferredSize(new Dimension(90,50));
            JPanel pn4 = new JPanel();
            pn4.setPreferredSize(new Dimension(50,50));
            fj.setLayout(new BorderLayout());
            fj.add(pn1, BorderLayout.NORTH);
            fj.add(pn2, BorderLayout.SOUTH);
            fj.add(pn3, BorderLayout.WEST);
            fj.add(pn4, BorderLayout.EAST);
            fj.add(label, BorderLayout.CENTER);
            fj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            fj.setVisible(true);
            fj.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    fj = null;
                }
            });
        }
    }

    //CỬA SỔ TÌM KIẾM SINH VIÊN
    class timKiem extends JFrame {
        public timKiem() {
            jf = new JFrame();
            JPanel pnCenter = new JPanel();
            pnCenter.setLayout(new BorderLayout());

            //PANEL Dis_north
            JPanel pnDisNorth = new JPanel();
            pnDisNorth.setPreferredSize(new Dimension(10,10));

            //PANEL CHỨA SOUTH
            JPanel pnSouth = new JPanel();
            pnSouth.setLayout(new BorderLayout(50,50));
            JLabel label_image = new JLabel(new ImageIcon("C:\\image\\Gboy.png"));
            JLabel lb_nhapMa = new JLabel("Nhập mã sinh viên");
            lb_nhapMa.setFont(new Font("Arial", Font.BOLD, 16));
            pnSouth.add(label_image, BorderLayout.NORTH);

            //PANEL CHỨA IN4 STUDENT
            JPanel pnInfor = new JPanel();
            pnInfor.setLayout(new BorderLayout(50,50));
            JPanel pnInfor_North = new JPanel();
            pnInfor_North.setLayout(new BoxLayout(pnInfor_North,BoxLayout.Y_AXIS));
            JPanel pnInfor_Center = new JPanel();
            pnInfor_Center.setLayout(new BorderLayout());
            JTextField tf_search = new JTextField();
            JButton bt_seach = new JButton(new ImageIcon("C:\\image\\seo.png"));
            JPanel pnInfor_North1 = new JPanel();
            pnInfor_North1.setLayout(new FlowLayout());

            pnInfor_North1.add(lb_nhapMa);
            JPanel pnInfor_North2 = new JPanel();
            pnInfor_North2.setLayout(new BorderLayout(10,10));
            pnInfor_North2.add(tf_search, BorderLayout.CENTER);
            pnInfor_North2.add(bt_seach, BorderLayout.EAST);

            JPanel pnInfor_CenterL = new JPanel();
            pnInfor_CenterL.setLayout(new GridLayout(6,1,50,50));
            JLabel lb_MaSV = new JLabel("Mã sinh viên:");
            JLabel lb_TenSV = new JLabel("Họ và Tên:");
            JLabel lb_Lop = new JLabel("Lớp:");
            JLabel lb_HeHoc = new JLabel("Hệ đào tạo:");
            JLabel lb_TinhTrang = new JLabel("Tình trạng:");
            JLabel lb_Khoa = new JLabel("Khoa:");
            pnInfor_CenterL.add(lb_MaSV);
            pnInfor_CenterL.add(lb_TenSV);
            pnInfor_CenterL.add(lb_Lop);
            pnInfor_CenterL.add(lb_HeHoc);
            pnInfor_CenterL.add(lb_TinhTrang);
            pnInfor_CenterL.add(lb_Khoa);

            JPanel pnInfor_CenterR = new JPanel();
            pnInfor_CenterR.setLayout(new GridLayout(6,1,50,50));
            JTextField tf_masv = new JTextField();
            JTextField tf_ten = new JTextField();
            JTextField tf_lop = new JTextField();
            JTextField tf_hehoc = new JTextField();
            JTextField tf_tinhtrang = new JTextField();
            JTextField tf_khoa = new JTextField();
            pnInfor_CenterR.add(tf_masv);
            pnInfor_CenterR.add(tf_ten);
            pnInfor_CenterR.add(tf_lop);
            pnInfor_CenterR.add(tf_hehoc);
            pnInfor_CenterR.add(tf_tinhtrang);
            pnInfor_CenterR.add(tf_khoa);
            pnInfor_Center.add(pnInfor_CenterL, BorderLayout.WEST);
            pnInfor_Center.add(pnInfor_CenterR, BorderLayout.CENTER);

            //CHỨC NĂNG TÌM KIẾM
            bt_seach.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SinhVien sinhVien1 = new SinhVien();
                    sinhVien1.setMaSV(tf_search.getText().toString());
                    SinhVien sinhVien3 = SinhVienDAO.getInstance().selectById(sinhVien1);
                    if(sinhVien3 == null) {
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                            if (fj == null) {
                                new notExist();
                            } else {
                                fj.toFront();
                            }
                        } catch (Exception a) {
                            a.printStackTrace();
                        }
                    } else {
                        tf_masv.setText(sinhVien3.getMaSV());
                        tf_ten.setText(sinhVien3.getTenSV());
                        tf_lop.setText(sinhVien3.getLop());
                        tf_hehoc.setText(sinhVien3.getHeHoc());
                        tf_tinhtrang.setText(sinhVien3.getTinhTrang());
                        tf_khoa.setText(sinhVien3.getKhoa());
                    }
                }
            });

            pnInfor_North.add(pnInfor_North1, BorderLayout.CENTER);
            pnInfor_North.add(pnInfor_North2, BorderLayout.EAST);
            pnInfor.add(pnInfor_North, BorderLayout.NORTH);
            pnInfor.add(pnInfor_Center, BorderLayout.CENTER);
            pnSouth.add(pnInfor, BorderLayout.CENTER);

            jf.setTitle("SEARCH");
            jf.setLocation(500,40);
            jf.setSize(450,820);
            JLabel label = new JLabel("StudentID: ");
            JTextField textField = new JTextField();

            //PANEL CENTER ADD
            JPanel pnCenter_East = new JPanel();
            pnCenter_East.setPreferredSize(new Dimension(100,100));
            JPanel pnCenter_West = new JPanel();
            pnCenter_West.setPreferredSize(new Dimension(100,100));
            JPanel pnCenter_South = new JPanel();
            pnCenter_South.setPreferredSize(new Dimension(100,100));
            pnCenter.add(pnDisNorth, BorderLayout.NORTH);
            pnCenter.add(pnSouth, BorderLayout.CENTER);
            pnCenter.add(pnCenter_East, BorderLayout.EAST);
            pnCenter.add(pnCenter_West, BorderLayout.WEST);
            pnCenter.add(pnCenter_South, BorderLayout.SOUTH);

            jf.setLayout(new BorderLayout());
            jf.add(pnCenter );
            jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    jf = null;
                }
            });
            jf.setVisible(true);
        }
    }
     public void search() {
         try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             if (jf == null) {
                 new timKiem();
             } else {
                 jf.toFront();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }


    public void them(){
        ArrayList <SinhVien> lst = SinhVienDAO.getInstance().selectAll();
        int count = 0;
        for (SinhVien sinhVien1 : lst) {
            if (sinhVien1.getMaSV().equals(tf_MaSV.getText())) count ++;
        }
        if (count > 0) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                if (fj == null) {
                    new exist();
                } else {
                    fj.toFront();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dm.addRow(new String[]{tf_MaSV.getText(),tf_TenSV.getText(), tf_Lop.getText(),
                    cb_HeDaoTao.getSelectedItem().toString(), cb_TinhTrang.getSelectedItem().toString(),cb_Khoa.getSelectedItem().toString()});
            sinhVien = new SinhVien(tf_MaSV.getText(),tf_TenSV.getText(), tf_Lop.getText(),
                    cb_HeDaoTao.getSelectedItem().toString(), cb_TinhTrang.getSelectedItem().toString(),cb_Khoa.getSelectedItem().toString());
            SinhVienDAO.getInstance().insert(sinhVien);
        }
    }



    //CỬA SỔ CẬP NHẬT SỬA THÔNG TIN SINH VIÊN
    class capNhat extends JFrame{
        public capNhat() {
            jf = new JFrame();
            jf.setTitle("Cập nhật thông tin sinh viên");
            jf.setLocation(500,300);
            jf.setSize(400,300);
            JPanel pnLeft = new JPanel();
            pnLeft.setLayout(new BorderLayout());
            pnLeft.setPreferredSize(new Dimension(150,100));
            JPanel pnLeft1 = new JPanel();
            JPanel pnLeft2 = new JPanel();
            JPanel pnLeft3 = new JPanel();
            JPanel pnLeft4 = new JPanel();
            JPanel pnLeft5 = new JPanel();
            pnLeft5.setLayout(new BorderLayout());
            JPanel pnL5C = new JPanel();
            JLabel lb_image = new JLabel(new ImageIcon("C:\\image\\Gboy.png"));
            pnL5C.add(lb_image);
            JPanel pnL5S = new JPanel();
            pnL5S.setLayout(new GridLayout(3,1));
            JLabel lb_search = new JLabel("Mã sinh viên");
            JTextField tf_search = new JTextField();
            JPanel pnL5STOP = new JPanel();
            pnL5STOP.setLayout(new FlowLayout());
            pnL5STOP.add(lb_search);
            JPanel pnL5SBOT = new JPanel();
            pnL5SBOT.setLayout(new FlowLayout());
            JButton bt_search = new JButton("Tìm kiếm");

            pnL5SBOT.add(bt_search);
            pnL5S.add(pnL5STOP);
            pnL5S.add(tf_search);
            pnL5S.add(pnL5SBOT);
            pnLeft5.add(pnL5S, BorderLayout.SOUTH);
            pnLeft5.add(pnL5C, BorderLayout.CENTER);
            pnLeft.add(pnLeft1, BorderLayout.WEST);
            pnLeft.add(pnLeft2, BorderLayout.EAST);
            pnLeft.add(pnLeft3, BorderLayout.NORTH);
            pnLeft.add(pnLeft4, BorderLayout.SOUTH);
            pnLeft.add(pnLeft5, BorderLayout.CENTER);
            JPanel pnRight = new JPanel();
            pnRight.setLayout(new BorderLayout());
            JPanel pnRight1 = new JPanel();
            JPanel pnRight2 = new JPanel();
            pnRight2.setPreferredSize(new Dimension(10,100));
            JPanel pnRight3 = new JPanel();
            JPanel pnRight4 = new JPanel();
            JPanel pnRight5 = new JPanel();
            pnRight5.setLayout(new BorderLayout());
            JPanel pnR5R = new JPanel();
            pnR5R.setLayout(new GridLayout(5,1,10,10));
            JLabel lb_tenSV = new JLabel("Tên SV:");
            JLabel lb_Lop = new JLabel("Lớp:");
            JLabel lb_heHoc = new JLabel("Hệ học:");
            JLabel lb_tinhTrang = new JLabel("Tình trạng:");
            JLabel lb_khoa = new JLabel("Khoa:");
            JPanel pnR5L = new JPanel();
            pnR5L.setLayout(new GridLayout(5,1,10,10));
            pnR5L.add(lb_tenSV);
            pnR5L.add(lb_Lop);
            pnR5L.add(lb_heHoc);
            pnR5L.add(lb_tinhTrang);
            pnR5L.add(lb_khoa);
            JTextField tf_tenSV = new JTextField();
            JTextField tf_lop = new JTextField();
            JComboBox cb_heHoc = new JComboBox();
            cb_heHoc.addItem("Chính Quy");
            JComboBox cb_tinhTrang = new JComboBox();
            cb_tinhTrang.addItem("Đã nộp học phí");
            cb_tinhTrang.addItem("Chưa nộp học phí");
            JComboBox cb_khoa = new JComboBox();
            cb_khoa.addItem("Khoa học máy tính");
            cb_khoa.addItem("Kỹ thuật máy tính");
            cb_khoa.addItem("An toàn thông tin");
            pnR5R.add(tf_tenSV);
            pnR5R.add(tf_lop);
            pnR5R.add(cb_heHoc);
            pnR5R.add(cb_tinhTrang);
            pnR5R.add(cb_khoa);
            JPanel pnRight52 = new JPanel();
            pnRight52.setLayout(new BorderLayout());
            JLabel lb_sua = new JLabel("Sửa thông tin");
            lb_sua.setFont(new Font("Arial", Font.BOLD, 16));
            JPanel pn_sua = new JPanel();
            pn_sua.setLayout(new FlowLayout());
            pn_sua.add(lb_sua);
            JPanel pn_luu = new JPanel();
            pn_luu.setLayout(new FlowLayout());
            JButton bt_luu1 = new JButton("Lưu");
            pn_luu.add(bt_luu1);

            pnRight5.add(pnR5L, BorderLayout.WEST);
            pnRight5.add(pnR5R, BorderLayout.CENTER);

            pnRight52.add(pn_sua, BorderLayout.NORTH);
            pnRight52.add(pnRight5, BorderLayout.CENTER);
            pnRight52.add(pn_luu, BorderLayout.SOUTH);


            pnRight.add(pnRight1, BorderLayout.WEST);
            pnRight.add(pnRight2, BorderLayout.EAST);
            pnRight.add(pnRight3, BorderLayout.NORTH);
            pnRight.add(pnRight4, BorderLayout.SOUTH);
            pnRight.add(pnRight52, BorderLayout.CENTER);

            //THANH CHIA PANEL LEFT VÀ RIGHT
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
            splitPane.setDividerSize(2);
            splitPane.setEnabled(false);
            jf.getContentPane().add(splitPane);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            bt_search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SinhVien sinhVien2 = new SinhVien();
                    sinhVien2.setMaSV(tf_search.getText().toString());
                    SinhVien sinhVien1 = SinhVienDAO.getInstance().selectById(sinhVien2);
                    if(sinhVien1 == null) {
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                            if (fj == null) {
                                new notExist();
                            } else {
                                fj.toFront();
                            }
                        } catch (Exception a) {
                            a.printStackTrace();
                        }
                    } else {
                        tf_tenSV.setText(sinhVien1.getTenSV());
                        tf_lop.setText(sinhVien1.getLop());
                        cb_heHoc.setSelectedItem(sinhVien1.getHeHoc());
                        cb_tinhTrang.setSelectedItem(sinhVien1.getTinhTrang());
                        cb_khoa.setSelectedItem(sinhVien1.getKhoa());
                    }
                 }
            });
            bt_luu1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SinhVien sinhVien2 = new SinhVien();
                    sinhVien2.setMaSV(tf_search.getText());
                    sinhVien2.setTenSV(tf_tenSV.getText());
                    sinhVien2.setLop(tf_lop.getText());
                    sinhVien2.setHeHoc(cb_heHoc.getSelectedItem().toString());
                    sinhVien2.setTinhTrang(cb_tinhTrang.getSelectedItem().toString());
                    sinhVien2.setKhoa(cb_khoa.getSelectedItem().toString());
                    SinhVienDAO.getInstance().update(sinhVien2);
                }
            });
            jf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    jf = null;
                }
            });
        }
    }


    //CHỨC NĂNG CẬP NHẬT SỬA THÔNG TIN SINH VIÊN
    public void sua() {
        if (jf == null) {
            new capNhat();
        } else {
            jf.toFront();
        }
    }

    //////////////////////////////////////
    class capNhat1 extends JFrame{
        public capNhat1() {
            jf = new JFrame();
            jf.setTitle("Cập nhật thông tin học phí");
            jf.setLocation(500,300);
            jf.setSize(400,300);
            JPanel pnLeft = new JPanel();
            pnLeft.setLayout(new BorderLayout());
            pnLeft.setPreferredSize(new Dimension(150,100));
            JPanel pnLeft1 = new JPanel();
            JPanel pnLeft2 = new JPanel();
            JPanel pnLeft3 = new JPanel();
            JPanel pnLeft4 = new JPanel();
            JPanel pnLeft5 = new JPanel();
            pnLeft5.setLayout(new BorderLayout());
            JPanel pnL5C = new JPanel();
            JLabel lb_image = new JLabel(new ImageIcon("C:\\image\\Gboy.png"));
            pnL5C.add(lb_image);
            JPanel pnL5S = new JPanel();
            pnL5S.setLayout(new GridLayout(3,1));
            JLabel lb_search = new JLabel("Mã sinh viên");
            JTextField tf_search = new JTextField();
            JPanel pnL5STOP = new JPanel();
            pnL5STOP.setLayout(new FlowLayout());
            pnL5STOP.add(lb_search);
            JPanel pnL5SBOT = new JPanel();
            pnL5SBOT.setLayout(new FlowLayout());
            JButton bt_search = new JButton("Tìm kiếm");

            pnL5SBOT.add(bt_search);
            pnL5S.add(pnL5STOP);
            pnL5S.add(tf_search);
            pnL5S.add(pnL5SBOT);
            pnLeft5.add(pnL5S, BorderLayout.SOUTH);
            pnLeft5.add(pnL5C, BorderLayout.CENTER);
            pnLeft.add(pnLeft1, BorderLayout.WEST);
            pnLeft.add(pnLeft2, BorderLayout.EAST);
            pnLeft.add(pnLeft3, BorderLayout.NORTH);
            pnLeft.add(pnLeft4, BorderLayout.SOUTH);
            pnLeft.add(pnLeft5, BorderLayout.CENTER);
            JPanel pnRight = new JPanel();
            pnRight.setLayout(new BorderLayout());
            JPanel pnRight1 = new JPanel();
            JPanel pnRight2 = new JPanel();
            pnRight2.setPreferredSize(new Dimension(10,100));
            JPanel pnRight3 = new JPanel();
            JPanel pnRight4 = new JPanel();
            JPanel pnRight5 = new JPanel();
            pnRight5.setLayout(new BorderLayout());
            JPanel pnR5R = new JPanel();
            pnR5R.setLayout(new GridLayout(5,1,10,10));
            JLabel lb_tenSV = new JLabel("Tên SV:");
            JLabel lb_Lop = new JLabel("Lớp:");
            JLabel lb_Khoa = new JLabel("Khoa:");
            JLabel lb_hocphidanop = new JLabel("Học phí đã nộp:");
            JLabel lb_hocphiconlai = new JLabel("Học phí còn lại:");
            JPanel pnR5L = new JPanel();
            pnR5L.setLayout(new GridLayout(5,1,10,10));
            pnR5L.add(lb_tenSV);
            pnR5L.add(lb_Lop);
            pnR5L.add(lb_Khoa);
            pnR5L.add(lb_hocphidanop);
            pnR5L.add(lb_hocphiconlai);
            JTextField tf_tenSV = new JTextField();
            JTextField tf_lop = new JTextField();
            JComboBox cb_Khoa = new JComboBox();
            cb_Khoa.addItem("Khoa học máy tính");
            cb_Khoa.addItem("Kỹ thuật máy tính");
            cb_Khoa.addItem("An toàn thông tin");
            JTextField tf_hocphidanop = new JTextField();
            JTextField tf_hocphiconlai = new JTextField();
            pnR5R.add(tf_tenSV);
            pnR5R.add(tf_lop);
            pnR5R.add(cb_Khoa);
            pnR5R.add(tf_hocphidanop);
            pnR5R.add(tf_hocphiconlai);
            JPanel pnRight52 = new JPanel();
            pnRight52.setLayout(new BorderLayout());
            JLabel lb_sua = new JLabel("Sửa thông tin");
            lb_sua.setFont(new Font("Arial", Font.BOLD, 16));
            JPanel pn_sua = new JPanel();
            pn_sua.setLayout(new FlowLayout());
            pn_sua.add(lb_sua);
            JPanel pn_luu = new JPanel();
            pn_luu.setLayout(new FlowLayout());
            JButton bt_luu1 = new JButton("Lưu");
            pn_luu.add(bt_luu1);

            pnRight5.add(pnR5L, BorderLayout.WEST);
            pnRight5.add(pnR5R, BorderLayout.CENTER);

            pnRight52.add(pn_sua, BorderLayout.NORTH);
            pnRight52.add(pnRight5, BorderLayout.CENTER);
            pnRight52.add(pn_luu, BorderLayout.SOUTH);


            pnRight.add(pnRight1, BorderLayout.WEST);
            pnRight.add(pnRight2, BorderLayout.EAST);
            pnRight.add(pnRight3, BorderLayout.NORTH);
            pnRight.add(pnRight4, BorderLayout.SOUTH);
            pnRight.add(pnRight52, BorderLayout.CENTER);

            //THANH CHIA PANEL LEFT VÀ RIGHT
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
            splitPane.setDividerSize(2);
            splitPane.setEnabled(false);
            jf.getContentPane().add(splitPane);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            bt_search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    HocPhi hocPhi2 = new HocPhi();
                    hocPhi2.setMaSV(tf_search.getText());
                    HocPhi hocPhi1 = HocPhiDAO.getInstance().selectById(hocPhi2);
                    if(hocPhi1 == null) {
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                            if (fj == null) {
                                new notExist();
                            } else {
                                fj.toFront();
                            }
                        } catch (Exception a) {
                            a.printStackTrace();
                        }
                    } else {
                        tf_tenSV.setText(hocPhi1.getTenSV());
                        tf_lop.setText(hocPhi1.getLop());
                        cb_Khoa.setSelectedItem(hocPhi1.getKhoa());
                        tf_hocphidanop.setText(hocPhi1.getHocPhiDaNop()+"");
                        tf_hocphiconlai.setText(hocPhi1.getHocPhiConLai()+"");
                    }
                }
            });
            bt_luu1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    HocPhi hocPhi2 = new HocPhi();
                    hocPhi2.setMaSV(tf_search.getText());
                    hocPhi2.setTenSV(tf_tenSV.getText());
                    hocPhi2.setLop(tf_lop.getText());
                    hocPhi2.setKhoa(cb_Khoa.getSelectedItem().toString());
                    hocPhi2.setHocPhiDaNop(Integer.parseInt(tf_hocphidanop.getText()));
                    hocPhi2.setHocPhiConLai(Integer.parseInt(tf_hocphiconlai.getText()));
                    HocPhiDAO.getInstance().update(hocPhi2);
                }
            });
            jf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    jf = null;
                }
            });
        }
    }
    //CHỨC NĂNG CẬP NHẬT SỬA THÔNG TIN SINH VIÊN
    public void sua1() {
        if (jf == null) {
            new capNhat1();
        } else {
            jf.toFront();
        }
    }


    public void deleteSelectedRow() {
        int [] selectedRow = table.getSelectedRows();
        for (int i = selectedRow.length - 1 ; i >= 0; i--) {
            String id = (String) table.getValueAt(selectedRow[i], 0);
            SinhVien sinhVien1 = new SinhVien();
            sinhVien1.setMaSV(id);
            SinhVienDAO.getInstance().delete(sinhVien1);
            dm.removeRow(selectedRow[i]);
        }
    }

    public void deleteSelectedRow1() {
        int [] selectedRow = tb_Search.getSelectedRows();
        for (int i = selectedRow.length - 1 ; i >= 0; i--) {
            String id = (String) tb_Search.getValueAt(selectedRow[i], 0);
            HocPhi hocPhi1 = new HocPhi();
            hocPhi1.setMaSV(id);
            HocPhiDAO.getInstance().delete(hocPhi1);
            tableModel.removeRow(selectedRow[i]);
        }
    }

    public void tk() {
        SinhVien sv = new SinhVien();
        sv.setMaSV(tf_Search.getText());
        sv = SinhVienDAO.getInstance().selectById(sv);
        textField_masv.setText(sv.getMaSV());
        textField_tensv.setText(sv.getTenSV());
        textField_lop.setText(sv.getLop());
    }
    public void luu() {
        ArrayList <HocPhi> list = HocPhiDAO.getInstance().selectAll();
        int count = 0;
        SinhVien sv = new SinhVien();
        sv.setMaSV(tf_Search.getText());
        sv = SinhVienDAO.getInstance().selectById(sv);
        HocPhi hocPhi = new HocPhi(textField_masv.getText(), textField_tensv.getText(), textField_lop.getText()
                , sv.getKhoa(), Integer.parseInt(textField_hocdanop.getText()), Integer.parseInt(textField_hocphiconlai.getText()));
        for (HocPhi hp : list) {
            if(hp.getMaSV().equals(textField_masv.getText())) {
                count++;
            }
        }
        if(count > 0) {
            if (fj == null) {
                new exist();
            } else {
                fj.toFront();
            }
        } else {
            HocPhiDAO.getInstance().insert(hocPhi);
            tableModel.addRow(new String[]{textField_masv.getText(), textField_tensv.getText(), textField_lop.getText()
                    , sv.getKhoa(), textField_hocdanop.getText(), textField_hocphiconlai.getText()});
            textField_tonghocphi.setText(Integer.parseInt(textField_hocdanop.getText()) + Integer.parseInt(textField_hocphiconlai.getText())+"");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new QLHPView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

