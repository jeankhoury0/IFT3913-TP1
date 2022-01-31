package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FindUserView extends JFrame {

    private JPanel findUserPanel;
    private JTextField userIdTextField;
    private JLabel answerLabel, userIdLabel, emptyLabel;
    private JButton goBackButton, validateButton;

    public FindUserView() {
        super("Trouver un utilisateur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(findUserPanel);
        this.pack();
    }

    public void setTextLabel(String s) {
        answerLabel.setText(s);
        answerLabel.setForeground(Color.lightGray);
    }

    public void emptyTextField(){
        userIdTextField.setText("");
    }

    public void setErrorLabel(String s) {
        answerLabel.setText(s);
        answerLabel.setForeground(Color.red);
    }

    public String getFindUserIdTextField() {
        return userIdTextField.getText();
    }

    public void hideFindUserView() {
        this.setVisible(false);
    }

    public void showFindUserView() {
        this.setVisible(true);
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }
}
