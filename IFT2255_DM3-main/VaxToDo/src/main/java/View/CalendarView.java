package view;

import controller.UserController;
import model.UserModel;
import model.VolunteerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalendarView extends JFrame {

    // *** attributes *** //

    private JPanel calendarPanel;
    private JButton addAppointmentButton;
    private JButton editAppointmentButton;
    private JButton findAppointmentButton;
    private JButton consultAppointmentButton;
    private JButton goBackButton;
    private JButton deleteAppointmentButton;

    // *** constructor *** //

    public CalendarView() {

        // on instancie le menu du calendrier
        super("Menu du Calendrier");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(calendarPanel);
        this.pack();

    }

    // *** methods *** //

    public void checkPermission() throws IOException {
        UserModel connectedUser = UserController.GetInstance().getConnectedUser();
        if (connectedUser instanceof VolunteerModel) {
            editAppointmentButton.setVisible(false);
            findAppointmentButton.setVisible(false);
            deleteAppointmentButton.setVisible(false);
        } else {
            editAppointmentButton.setVisible(true);
            findAppointmentButton.setVisible(true);
            deleteAppointmentButton.setVisible(true);
        }

    }

    public void hideCalendarView() {
        this.setVisible(false);
    }

    public void showCalendarView() {
        this.setVisible(true);
    }


    // *** actions & listeners *** //

    public void addAddAppointmentListener(ActionListener listenAddAppointmentButton) {
        addAppointmentButton.addActionListener(listenAddAppointmentButton);
    }

    public void addEditAppointmentListener(ActionListener listenEditAppointmentButton) {
        editAppointmentButton.addActionListener(listenEditAppointmentButton);
    }

    public void addFindAppointmentListener(ActionListener listenFindAppointmentButton) {
        findAppointmentButton.addActionListener(listenFindAppointmentButton);
    }

    public void addConsultAppointmentListener(ActionListener listenExportAppointmentButton) {
        consultAppointmentButton.addActionListener(listenExportAppointmentButton);
    }

    public void addDeleteAppointmentListener(ActionListener listenDeleteAppointmentButton) {
        deleteAppointmentButton.addActionListener(listenDeleteAppointmentButton);
    }

    public void addGoToMenuListener(ActionListener listenGoToMenuButton) {
        goBackButton.addActionListener(listenGoToMenuButton);
    }
}
