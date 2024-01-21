import javax.swing.*;

public class FrameWithoutTitleBar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Frame Without Title Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ẩn thanh tiêu đề
        frame.setUndecorated(true);

        // Thêm nội dung vào JFrame
        JLabel label = new JLabel("Hello, this is a frame without title bar.");
        frame.getContentPane().add(label);

        // Thiết lập kích thước và vị trí của cửa sổ
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
