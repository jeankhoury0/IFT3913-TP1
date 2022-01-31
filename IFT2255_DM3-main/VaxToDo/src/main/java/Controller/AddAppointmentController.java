package controller;

import model.AppointmentModel;
import model.VisitorModel;
import repository.AppointmentRepository;
import view.AddAppointmentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class AddAppointmentController {

    // *** attributes *** //

    private static AddAppointmentController aacInstance;
    private final AddAppointmentView addAppointmentView;

    // *** constructor *** //

    /**
     *  Controller Constructor
     */
    private AddAppointmentController() {

        this.addAppointmentView = new AddAppointmentView();

        // on ajoute les listeners aux boutons appropriés
        this.addAppointmentView.addValidateListener(new ValidationListener());
        this.addAppointmentView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating an instance of Adding Appointment
     *
     * @return aacInstance
     * @throws IOException
     */
    public static AddAppointmentController GetInstance() throws IOException {
        if (aacInstance == null)
            aacInstance = new AddAppointmentController();
        return aacInstance;
    }

    // *** method *** //

    /**
     * View Display
     */
    public void DisplayAddAppointmentView() {
        this.addAppointmentView.showAddAppointmentView();
    }

    /**
     * Validation of new Appointment
     *
     * @throws IOException
     */
    private void validateAddAppointment() throws IOException {
        String id;
        LocalDate ld = null;
        LocalTime lt = null;
        VisitorModel v1, v2;

        // récupérer les données de la vue
        String firstNameFirstVisitor = addAppointmentView.getFirstNameFirstVisitorTextField();
        String lastNameFirstVisitor = addAppointmentView.getLastNameFirstVisitorTextField();
        String firstNameSecondVisitor = addAppointmentView.getFirstNameSecondVisitorTextField();
        String lastNameSecondVisitor = addAppointmentView.getLastNameSecondVisitorTextField();
        String date = addAppointmentView.getDateTextField();
        String time = addAppointmentView.getTimeTextField();

        // vérification
        if (date.length() == 0 || time.length() == 0) {
            addAppointmentView.setErrorLabel("Les données ne sont pas au bon format.");
            throw new Error("les données sont mal formatées");
        } else {
            try {
                ld = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
                lt = LocalTime.parse(time);
            } catch (Exception e) {
                addAppointmentView.setErrorLabel("Les données ne sont pas au bon format.");
            }
            id = generateId();
        }
        // vérifier la conformité des données
        if (firstNameFirstVisitor.length() < 50 && lastNameFirstVisitor.length() < 50
                && firstNameSecondVisitor.length() < 50 && lastNameSecondVisitor.length() < 50
                && ld != null && lt != null) {

            // 2 visiteurs pour le même rendez-vous
            if (firstNameSecondVisitor.trim().length() != 0 && lastNameSecondVisitor.trim().length() != 0) {

                v1 = new VisitorModel(firstNameFirstVisitor, lastNameFirstVisitor);
                v2 = new VisitorModel(firstNameSecondVisitor, lastNameSecondVisitor);
                CalendarController.getCalendarModel().getAppointmentRepository().addAppointment(
                        new AppointmentModel(v1, v2, ld, lt, id));
            }

            // un seul visiteur pour le rendez-vous
            else {
                // le nouveau visiteur à ajouter au rendez-vous
                v1 = new VisitorModel(firstNameFirstVisitor, lastNameFirstVisitor);

                // on crée le rendez-vous à ajouter au calendrier et on l'ajoute
                AppointmentModel appointmentModel = new AppointmentModel(v1, ld, lt, id);
                CalendarController.getCalendarModel().getAppointmentRepository().addAppointment(appointmentModel);
            }

            addAppointmentView.setTextLabel("Le rendez-vous à bien été ajouter");

            // les données ne sont pas au bon format alors on lance une erreur
        } else {
            addAppointmentView.setErrorLabel("Les données entrées ne sont pas au bon format");
        }
    }

    /**
     * Generating unique ID for new appointment
     *
     * ID is max 10 caracters
     *
     * @return id
     * @throws IOException
     */
    private String generateId() throws IOException {
        boolean unique = true;
        Random rn = new Random();
        ArrayList<AppointmentModel> aptList = AppointmentRepository.GetInstance().getAppointments();
        String id;

        // on veut s'assurer que l'on attribue un id unique
        do {

            // on crée un identifiant
            id = rn.ints(97, 123).limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            // on doit vérifier que l'id est unique en le comparant avec les autres
            for (AppointmentModel apt : aptList) {
                if (id.equals(apt.getId())) {
                    unique = false;
                    break;
                }
            }
        } while (!unique); // on recommence si on a attribué un id déjà existant

        return id;

    }

    // *** getter *** //

    /**
     * New Appointment View Getter
     *
     * @return addAppointmentView
     */
    public AddAppointmentView getView() {
        return addAppointmentView;
    }

    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                validateAddAppointment();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class GoBackToMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            addAppointmentView.emptyTextField();
            addAppointmentView.hideAddAppointmentView();
            try {
                CalendarController.GetInstance().DisplayCalendarView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
