package controller;

import repository.AppointmentRepository;
import view.DeleteAppointmentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteAppointmentController {

    // *** attributes *** //

    private static DeleteAppointmentController dacInstance;
    private final DeleteAppointmentView deleteAppointmentView;

    // *** constructor *** //

    /**
     * Controller builder
     *
     * @throws IOException
     */
    private DeleteAppointmentController() throws IOException {

        this.deleteAppointmentView = new DeleteAppointmentView();

        // on ajoute les listeners aux boutons appropriés
        this.deleteAppointmentView.addValidateListener(new ValidationListener());
        this.deleteAppointmentView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating instance
     *
     * @return dacInstance
     * @throws IOException
     */
    public static DeleteAppointmentController GetInstance() throws IOException {
        if (dacInstance == null)
            dacInstance = new DeleteAppointmentController();
        return dacInstance;
    }

    /**
     * View getter
     *
     * @return deleteAppointmentView
     */
    public DeleteAppointmentView getDeleteAppointmentView() {
        return deleteAppointmentView;
    }

    /**
     * Display Appointment cancellation view
     */
    public void DisplayDeleteAppointmentView() {
        this.deleteAppointmentView.showDeleteAppointmentView();
    }

    /**
     * Appointment ID validation
     * Deleting appointment if ID is valid
     *
     * @throws IOException
     */
    private void ValidateDeleteAppointment() throws IOException {
        String id = deleteAppointmentView.getDeleteAppointmentTextField();
        if (id.length() != 10) {
            deleteAppointmentView.setErrorMessage("L'identificateur est dans le mauvais format");
        } else {
            AppointmentRepository aptList = CalendarController.getCalendarModel().getAppointmentRepository();
            if (aptList.findAppointment(id)) {

                // on supprime le rendez-vous dans la structure de donnée et sur le fichier
                aptList.removeAppointment(id);
                CalendarController.getCalendarModel().getAppointmentRepository().removeAppointment(id);
                deleteAppointmentView.setAnswerLabel("Le rendez-vous a bien été supprimé");
            } else {
                deleteAppointmentView.setAnswerLabel("Le rendez-vous n'a pas été trouvé");
            }
        }
    }

    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        /**
         * Delete button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            try {
                ValidateDeleteAppointment();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            deleteAppointmentView.emptyTextField();
        }
    }

    class GoBackToMenuListener implements ActionListener {
        /**
         * Return menu
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            deleteAppointmentView.emptyTextField();
            deleteAppointmentView.hideDeleteAppointmentView();
            try {
                CalendarController.GetInstance().DisplayCalendarView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
