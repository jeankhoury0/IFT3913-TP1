package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ConsultCalendarView extends JFrame {
    private JLabel appointmentListLabel;
    private JPanel consultAppointmentPanel;
    private JButton goBackButton;
    private JLabel titleLabel;

    public ConsultCalendarView() {
        super("Consulter le calendrier");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(consultAppointmentPanel);
        this.pack();
    }

    // *** methods *** //

    public void hideConsultCalendarView() {
        this.setVisible(false);
    }

    public void showConsultCalendarView() {
        this.setVisible(true);
    }

    public void setAppointmentListLabel(String s){
        this.appointmentListLabel.setText(s);
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }
}
