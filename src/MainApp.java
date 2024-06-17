import dto.UserDto;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApp extends JFrame{
    private JLabel userNameLabel;
    private JPanel mainPanel;
    private JTextField movieSearchTextField;
    private JButton 검색Button;
    private JTextField movieTitleTextField;
    private JTextField directorNameTextField;
    private JTextField starRatingTextField;
    private JButton reviewButton;

    public MainApp(UserDto userDto){
        setContentPane(mainPanel);
        setTitle("로그인 화면");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(12, 10, 1000, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        userNameLabel.setText(userDto.getUserName());
        검색Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
