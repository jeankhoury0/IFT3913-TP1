package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteUserView extends JFrame {

    private JPanel deleteUserPanel;
    private JButton validateButton;
    private JButton goBackButton;
    private JTextField userIdTextField;
    private JLabel userIdLabel;
    private JLabel answerLabel;

    public DeleteUserView() {
        super("Supprimer un utilisateur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(deleteUserPanel);
        this.pack();
    }

    public void hideDeleteUserView() {
        this.setVisible(false);
    }

    public void showDeleteUserView() {
        this.setVisible(true);
    }

    public String getUserIdTextField() {
        return this.userIdTextField.getText();
    }

    public void setTextLabel(String s) {
        this.answerLabel.setText(s);
    }

    public void emptyTextField() {
        this.userIdTextField.setText("");
    }

    public void setErrorMessage(String msg) {
        this.answerLabel.setForeground(Color.red);
        this.answerLabel.setText(msg);
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }

    public void setAnswerLabel(String s) {
        this.answerLabel.setForeground(Color.lightGray);
        this.answerLabel.setText(s);
    }
}
