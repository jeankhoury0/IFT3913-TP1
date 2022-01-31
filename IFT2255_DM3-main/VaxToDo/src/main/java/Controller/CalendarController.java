
// singleton

package controller;

import model.CalendarModel;
import view.CalendarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalendarController {

    // *** attributes *** //

    private static CalendarModel calendarModel; // le modèle du calendrier
    private static CalendarController ccInstance; // l'unique contrôleur du calendrier
    private final CalendarView calendarView; // la vue du menu des calendriers
    private final AddAppointmentController aacInstance;
    private final DeleteAppointmentController dacInstance;
    private final FindAppointmentController facInstance;
    private final ConsultCalendarController cacInstance;

    // *** constructor *** //

    /**
     * Controller Constructor
     *
     * Creating the menu
     *
     * @throws IOException
     */
    private CalendarController() throws IOException {
        // on instancie le modèle et la vue
        calendarModel = new CalendarModel();
        this.calendarView = new CalendarView();
        aacInstance = AddAppointmentController.GetInstance();
        dacInstance = DeleteAppointmentController.GetInstance();
        facInstance = FindAppointmentController.GetInstance();
        cacInstance = ConsultCalendarController.GetInstance();

        // on lie les listeners aux boutons appropriés
        this.calendarView.addAddAppointmentListener(new AddAppointmentListener());
        this.calendarView.addDeleteAppointmentListener(new DeleteAppointmentListener());
        this.calendarView.addFindAppointmentListener(new FindAppointmentListener());
//		this.calendarView.addEditAppointmentListener(new EditAppointmentListener());
        this.calendarView.addConsultAppointmentListener(new ConsultCalendarListener());
        this.calendarView.addGoToMenuListener(new GoBackListener());
    }

    /**
     * Creating Calendar Controller Instance
     *
     * @return coInstance
     * @throws IOException
     */
    public static CalendarController GetInstance() throws IOException {
        if (ccInstance == null)
            ccInstance = new CalendarController();
        return ccInstance;
    }

    // *** model methods *** //

    /**
     * Displaying Calender View
     *
     * @return calendarView
     */
    public CalendarView getView() {
        return calendarView;
    }

    /**
     * CalenderModel getter
     *
     * @return calendarModel
     */
    public static CalendarModel getCalendarModel() {
        return calendarModel;
    }

    // *** view methods *** //

    void DisplayCalendarView() {
        this.calendarView.showCalendarView();
    }

    void DisplayAddAppointmentView() {
        this.calendarView.hideCalendarView();
        aacInstance.DisplayAddAppointmentView();
    }

    void DisplayDeleteAppointmentView() {
        this.calendarView.hideCalendarView();
        dacInstance.getDeleteAppointmentView().refreshGUI();
        dacInstance.DisplayDeleteAppointmentView();
    }

    void DisplayFindAppointmentView() {
        this.calendarView.hideCalendarView();
        facInstance.DisplayFindVisitorView();
    }

    void DisplayConsultAppointmentView() {
        this.calendarView.hideCalendarView();
        cacInstance.DisplayAddAppointmentView();
    }

    // *** nested class : action listener *** //

    class AddAppointmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DisplayAddAppointmentView();
        }
    }

    class DeleteAppointmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DisplayDeleteAppointmentView();
        }
    }

    class FindAppointmentListener implements ActionListener {
        /**
         * Button: Find Appointment
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            facInstance.getView().setTextLabel("veuillez entrer l'identificateur du rendez-vous à chercher");
            DisplayFindAppointmentView();
        }
    }

    class EditAppointmentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    class ConsultCalendarListener implements ActionListener {
        /**
         * Consulting calendar
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            String rdv = calendarModel.toString();
            if (rdv.trim().length() > 0) {
                cacInstance.getView().setAppointmentListLabel(rdv);
            } else {
                cacInstance.getView().setAppointmentListLabel("aucun rendez-vous...");
            }
            DisplayConsultAppointmentView();
        }
    }

    class GoBackListener implements ActionListener {
        /**
         * Return to menu button
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            calendarView.hideCalendarView();
            try {
                SystemController.GetInstance().DisplayMenuView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
