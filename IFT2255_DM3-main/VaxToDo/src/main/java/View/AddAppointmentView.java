package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddAppointmentView extends JFrame {

    private JPanel addAppointmentPanel;
    private JButton goBackButton, validateButton;
    private JTextField firstNameFirstVisitorTextField, lastNameFirstVisitorTextField;
    private JTextField firstNameSecondVisitorTextField, lastNameSecondVisitorTextField;
    private JTextField dateTextField, timeTextField;
    private JLabel firstNameFirstVisitorLabel, lastNameFirstVisitorLabel;
    private JLabel firstNameSecondVisitorLabel, lastNameSecondVisitorLabel;
    private JLabel timeLabel, dateLabel, answerLabel;

    public AddAppointmentView() {
        super("Ajouter un rendez-vous");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 450);
        this.setContentPane(addAppointmentPanel);
        this.pack();
    }


    // *** methods *** //

    public void hideAddAppointmentView() {
        this.setVisible(false);
    }

    public void showAddAppointmentView() {
        this.setVisible(true);
    }

    public void setTextLabel(String s) {
        answerLabel.setText(s);
    }

    public void setErrorLabel(String s) {
        answerLabel.setText(s);
        answerLabel.setForeground(Color.red);
    }

    public void emptyTextField() {
        firstNameFirstVisitorTextField.setText("");
        lastNameFirstVisitorTextField.setText("");
        firstNameSecondVisitorTextField.setText("");
        lastNameSecondVisitorTextField.setText("");
        dateTextField.setText("");
        timeTextField.setText("");
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public String getFirstNameFirstVisitorTextField() {
        return firstNameFirstVisitorTextField.getText();
    }

    public String getLastNameFirstVisitorTextField() {
        return lastNameFirstVisitorTextField.getText();
    }

    public String getFirstNameSecondVisitorTextField() {
        return firstNameSecondVisitorTextField.getText();
    }

    public String getLastNameSecondVisitorTextField() {
        return lastNameSecondVisitorTextField.getText();
    }

    public String getDateTextField() {
        return dateTextField.getText();
    }

    public String getTimeTextField() {
        return timeTextField.getText();
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }

}