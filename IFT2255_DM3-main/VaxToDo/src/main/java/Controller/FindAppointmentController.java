package controller;

import model.AppointmentModel;
import model.VisitorModel;
import repository.AppointmentRepository;
import repository.VisitorRepository;
import view.FindAppointmentView;
import view.FindVisitorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FindAppointmentController {

    // *** attributes *** //

    private static FindAppointmentController facInstance;
    private final FindAppointmentView findAppointmentView;

    // *** constructor *** //

    /**
     * Constroller Builder
     *
     * @throws IOException
     */
    private FindAppointmentController() throws IOException {

        this.findAppointmentView = new FindAppointmentView();

        // on ajoute les listeners aux boutons appropriés
        this.findAppointmentView.addValidateListener(new ValidationListener());
        this.findAppointmentView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating instance of Controller
     *
     * @return facInstance
     * @throws IOException
     */
    public static FindAppointmentController GetInstance() throws IOException {
        if (facInstance == null)
            facInstance = new FindAppointmentController();
        return facInstance;
    }

    /**
     * Display View
     */
    public void DisplayFindVisitorView() {
        this.findAppointmentView.showFindAppointmentView();
    }

    /**
     * View Getter
     * @return findAppointmentView
     */
    public FindAppointmentView getView() {
        return findAppointmentView;
    }

    /**
     * Appointment lookup validation
     * ID validation
     *
     * @throws IOException
     */
    private void ValidateFindAppointment() throws IOException {
        String id = findAppointmentView.getFindAppointmentTextField();
        // trouver le visiteur correspondant à l'id et écrire la réponse
        boolean trouve = false;
        ArrayList<AppointmentModel> appointments = AppointmentRepository.GetInstance().getAppointments();

        for (AppointmentModel apt : appointments) {
            if (id.equals(apt.getId())) {
                trouve = true;
                findAppointmentView.setTextLabel(apt.toString());
                break;
            }
        }
        if (!trouve) {
            findAppointmentView.setTextLabel("Le rendez-vous n'est pas dans la base de donnée");
        }
    }

    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        /**
         * Action button
         * Validate Appointment
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            try {
                ValidateFindAppointment();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class GoBackToMenuListener implements ActionListener {
        /**
         * Return button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            findAppointmentView.hideFindAppointmentView();
            try {
                CalendarController.GetInstance().DisplayCalendarView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

