package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FindVisitorView extends JFrame {

    private JPanel findVisitorPanel;
    private JTextField findVisitorTextField;
    private JButton goBackButton, validateButton;
    private JLabel answerLabel, visitorIdLabel;

    public FindVisitorView() {
        super("Trouver un visiteur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(findVisitorPanel);
        this.pack();
    }

    public void setTextLabel(String s) {
        answerLabel.setText(s);
    }

    public void emptyTextField() {
        findVisitorTextField.setText("");
    }

    public String getFindVisitorTextField() {
        return findVisitorTextField.getText();
    }

    public void hideFindVisitorView() {
        this.setVisible(false);
    }

    public void showFindVisitorView() {
        this.setVisible(true);
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }
}
