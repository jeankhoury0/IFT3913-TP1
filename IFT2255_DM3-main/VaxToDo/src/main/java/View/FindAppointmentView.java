package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FindAppointmentView extends JFrame {

    private JPanel findAppointmentPanel;
    private JTextField findAppointmentIdTextField;
    private JButton goBackButton, validateButton;
    private JLabel answerLabel, findAppointmentIdLabel;

    public FindAppointmentView() {
        super("Trouver un rendez-vous");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(findAppointmentPanel);
        this.pack();
    }

    public void setTextLabel(String s) {
        answerLabel.setText(s);
    }

    public String getFindAppointmentTextField() {
        return findAppointmentIdTextField.getText();
    }

    public void hideFindAppointmentView() {
        this.setVisible(false);
    }

    public void showFindAppointmentView() {
        this.setVisible(true);
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }
}
