import dao.UserDao;

import javax.swing.*;
import java.awt.event.*;

public class SignUpDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField idTextField;
    private JPanel mainPanel;
    private JTextField passwordTextField;
    private JTextField nameTextField;
    private JButton signUpButton;

    public SignUpDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserDao userDao = new UserDao();
                boolean isSuccess = false;
                isSuccess = userDao.signUp(idTextField.getText(), passwordTextField.getText(), nameTextField.getText());

                if (isSuccess) {
                    MainApp mainApp = new MainApp(userDao.getUserDto());
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        SignUpDialog dialog = new SignUpDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
