package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddVolunteerView extends JFrame {

    private JPanel addVolunteerPanel;
    private JTextField userFirstNameTextField, userLastNameTextField, birthdayTextField,
            mailTextField, cityTextField, postalTextField, phoneTextField, addressTextField;
    private JPasswordField passwordField, confirmPassWordTextField;
    private JButton validateButton, goBackButton;
    private JLabel userFirstNameLabel, confirmePassWordLabel,
            mailLabel, userLastNameLabel, phoneLabel, answerLabel, userPasswordLabel,
            addressLabel, cityLabel, postalLabel;

    public AddVolunteerView() {
        super("Ajouter un utilisateur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addVolunteerPanel);
        this.pack();
    }

    // *** methods *** //

    public void hideAddUserView() {
        this.setVisible(false);
    }

    public void showAddUserView() {
        this.setVisible(true);
    }

    public void setTextLabel(String s) {
        this.answerLabel.setForeground(Color.lightGray);
        this.answerLabel.setText(s);
    }

    public void setErrorMessage(String s) {
        answerLabel.setText(s);
        answerLabel.setForeground(Color.red);
    }

    public void emptyTextField() {

        userLastNameTextField.setText("");
        userFirstNameTextField.setText("");
        addressTextField.setText("");
        confirmPassWordTextField.setText("");
        postalTextField.setText("");
        phoneTextField.setText("");
        cityTextField.setText("");
        mailTextField.setText("");
        birthdayTextField.setText("");
        passwordField.setText("");
    }

    public String getPassword() {
        char[] pass = this.passwordField.getPassword();
        return new String(pass);
    }

    public String getConfirmPassword() {
        char[] pass = this.confirmPassWordTextField.getPassword();
        return new String(pass);
    }

    public String getFirstName() {
        return this.userFirstNameTextField.getText();
    }

    public String getLastName() {
        return this.userLastNameTextField.getText();
    }

    public String getBirthday() {
        return this.birthdayTextField.getText();
    }

    public String getPhone(){
        return this.phoneTextField.getText();
    }

    public String getMail(){
        return this.mailTextField.getText();
    }

    public String getAddress(){
        return this.addressTextField.getText();
    }

    public String getPostal(){
        return this.postalTextField.getText();
    }

    public String getCity(){
        return this.cityTextField.getText();
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }

//    public static void main(String[] args) {
//        AddUserView au = new AddUserView();
//    }
}