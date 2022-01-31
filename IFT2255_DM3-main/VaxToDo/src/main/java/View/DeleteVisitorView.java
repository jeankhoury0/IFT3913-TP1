package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteVisitorView extends JFrame {
    private JPanel deleteVisitorPanel;
    private JTextField visitorIdTextField;
    private JButton goBackButton;
    private JButton validateButton;
    private JLabel visitorIdLabel;
    private JLabel answerLabel;

    public DeleteVisitorView() {
        super("Supprimer un visiteur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(deleteVisitorPanel);
        this.pack();
    }

    public String getIdTextField() {
        return this.visitorIdTextField.getText();
    }

    public void hideDeleteVisitorView() {
        this.setVisible(false);
    }

    public void showDeleteVisitorView() {
        this.setVisible(true);
    }

    public void setTextLabel(String s) {
        this.answerLabel.setText(s);
    }

    public void setErrorMessage(String s) {
        this.answerLabel.setForeground(Color.red);
        this.answerLabel.setText(s);
    }

    public void setAnswerLabel(String s) {
        this.answerLabel.setForeground(Color.lightGray);
        this.answerLabel.setText(s);
    }

    public void emptyTextField(){
        this.visitorIdTextField.setText("");
    }


    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }
}
