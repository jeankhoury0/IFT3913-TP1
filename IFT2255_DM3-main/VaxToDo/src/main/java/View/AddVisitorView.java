package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddVisitorView extends JFrame {

    private JPanel addVisitorPanel;
    private JTextField visitorEmailTextField, visitorFirstNameTextField,
            visitorLastNameTextField, visitorAddressTextField, cityTextField,
            postalCodeTextField, phoneTextField, birthdayTextField;
    private JButton validateButton, goBackButton;
    private JLabel visitorAddressLabel, visitorEmailLabel, phoneVisitorLabel,
            visitorLastNameLabel, visitorFirstNameLabel, answerLabel, cityLabel,
            postalCodeVisitorLabel, birthdayLabel;

    public AddVisitorView() {
        super("Ajouter un visiteur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addVisitorPanel);
        this.pack();
    }

    // *** methods *** //

    public void setTextLabel(String s) {
        answerLabel.setText(s);
        answerLabel.setForeground(Color.lightGray);
    }

    public void setErrorLabel(String s) {
        answerLabel.setText(s);
        answerLabel.setForeground(Color.red);
    }

    public void emptyTextField() {
        visitorEmailTextField.setText("");
        visitorFirstNameTextField.setText("");
        visitorLastNameTextField.setText("");
        visitorAddressTextField.setText("");
        cityTextField.setText("");
        postalCodeTextField.setText("");
        phoneTextField.setText("");
        birthdayTextField.setText("");
    }

    public String getVisitorEmailTextField() {
        return visitorEmailTextField.getText();

    }

    public String getVisitorFirstNameTextField() {
        return visitorFirstNameTextField.getText();
    }

    public String getVisitorLastNameTextField() {
        return visitorLastNameTextField.getText();

    }

    public String getVisitorAddressTextField() {
        return visitorAddressTextField.getText();
    }

    public String getCityTextField(){
        return cityTextField.getText();
    }

    public String getPostalCodeTextField() {
        return postalCodeTextField.getText();
    }

    public String getPhoneTextField(){
        return phoneTextField.getText();
    }

    public String getBirthdayTextField(){
        return birthdayTextField.getText();
    }

    public void hideAddVisitorView() {
        this.setVisible(false);
    }

    public void showAddVisitorView() {
        this.setVisible(true);
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }
}
