package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel loginPanel;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JLabel idLabel;
    private JTextField idTextField;
    private JButton loginButton;
    private JLabel errorMessage;

    public LoginView(){
        super("Authentification");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
        this.pack();
    }

    // *** methods *** //

    public void hideLoginView(){
        this.setVisible(false);
    }

    public void showLoginView(){
        this.setVisible(true);
    }

    public void displayErrorMessage(String message){
        errorMessage.setText(message);
    }

    // *** getters & setters *** //

    public String getPassword() {
        char[] c = passwordField.getPassword();
        return new String(c);
    }

    public String getIdentification() {
        return idTextField.getText();
    }

    // *** action listeners *** //

    public void addLoginListener(ActionListener listenLoginButton){
        loginButton.addActionListener(listenLoginButton);
    }

}
