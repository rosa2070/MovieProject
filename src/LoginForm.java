import dao.UserDao;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame{
    private JPanel mainPanel;
    private JTextField idTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JButton SignUpButton;

    public LoginForm(){
        setContentPane(mainPanel);
        setTitle("로그인 화면");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(12, 10, 1000, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserDao userDao = new UserDao();
                boolean isSuccess = false;
                isSuccess = userDao.login(idTextField.getText(), passwordTextField.getText());

                if (isSuccess){
                    MainAPP mainAPP = new MainAPP(userDao.getUserDto());
                }
            }
        });
        SignUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }
}
