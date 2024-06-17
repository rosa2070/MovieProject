import dto.UserDto;

import javax.swing.*;

public class MainAPP extends JFrame{
    private JLabel userNameLabel;
    private JPanel mainPanel;

    public MainAPP(UserDto userDto){
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
