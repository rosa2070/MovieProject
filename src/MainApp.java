import dto.UserDto;

import javax.swing.*;

public class MainApp extends JFrame{
    private JLabel userNameLabel;
    private JPanel mainPanel;

    public MainApp(UserDto userDto){
        setContentPane(mainPanel);
        setTitle("로그인 화면");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(12, 10, 1000, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        userNameLabel.setText(userDto.getUserName());
    }
}
