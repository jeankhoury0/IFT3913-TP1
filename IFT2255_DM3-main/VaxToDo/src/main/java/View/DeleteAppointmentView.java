package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteAppointmentView extends JFrame {

    // *** attributes *** //

    private JPanel deleteAppointmentPanel;
    private JTextField deleteAppointmentTextField;
    private JButton goBackButton, validateButton;
    private JLabel answerLabel;

    public DeleteAppointmentView() {
        super("Supprimer un rendez-vous");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(deleteAppointmentPanel);
        this.pack();
    }

    public void emptyTextField() {
        deleteAppointmentTextField.setText("");
    }

    // *** methods *** //

    public void setErrorMessage(String s) {
        answerLabel.setText(s);
        answerLabel.setForeground(Color.red);
    }

    public void setAnswerLabel(String s) {
        answerLabel.setText(s);
    }

    public void refreshGUI() {
        answerLabel.setText("entrez l'identificateur du rendez-vous à supprimer");
        answerLabel.setForeground(Color.lightGray);
    }

    public void hideDeleteAppointmentView() {
        this.setVisible(false);
    }

    public void showDeleteAppointmentView() {
        this.setVisible(true);
    }

    public String getDeleteAppointmentTextField() {
        return deleteAppointmentTextField.getText();
    }

    public void addValidateListener(ActionListener listenValidateButton) {
        validateButton.addActionListener(listenValidateButton);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }

}
