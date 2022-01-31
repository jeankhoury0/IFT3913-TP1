package controller;

import model.AppointmentModel;
import model.VisitorModel;
import repository.AppointmentRepository;
import repository.VisitorRepository;
import view.AddVisitorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class AddVisitorController {

    // *** attributes *** //

    private static AddVisitorController avcInstance;
    private final AddVisitorView addVisitorView;

    // *** constructor *** //

    /**
     * Constructing add visitor Controller
     */
    public AddVisitorController() {

        this.addVisitorView = new AddVisitorView();

        // on ajoute les listeners aux boutons appropriés
        this.addVisitorView.addValidateListener(new ValidationListener());
        this.addVisitorView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating instance of controller
     *
     * @return avcInstance
     * @throws IOException
     */
    public static AddVisitorController GetInstance() throws IOException {
        if (avcInstance == null)
            avcInstance = new AddVisitorController();
        return avcInstance;
    }

    /**
     * Displaying view
     */
    public void DisplayAddVisitorView() {
        this.addVisitorView.showAddVisitorView();
    }

    /**
     * Validating added visitor
     *
     * Validating visitor in database and the formatting of entries
     *
     * @throws IOException
     */
    private void validateAddVisitor() throws IOException {
        boolean data = true; // si les données sont bien formatter alors on crée le visiteur

        // récupérer les données
        String id;
        LocalDate ld = null;
        String city = addVisitorView.getCityTextField();
        String phoneString = addVisitorView.getPhoneTextField();
        String postal = addVisitorView.getPostalCodeTextField();
        String address = addVisitorView.getVisitorAddressTextField();
        String email = addVisitorView.getVisitorEmailTextField();
        String firstName = addVisitorView.getVisitorFirstNameTextField();
        String lastName = addVisitorView.getVisitorLastNameTextField();
        String birthday = addVisitorView.getBirthdayTextField();

        // vérifier la longueur des données
        if (firstName.length() < 50 && lastName.length() < 50 && phoneString.length() <= 10
                && postal.length() <= 6 && address.length() < 100 && city.length() < 50
                && email.length() < 50 && email.contains("@")) {

            // on convertit le téléphone en entier
            int phone = 0;
            try {
                phone = Integer.parseInt(phoneString);
            } catch (NumberFormatException e) {
                addVisitorView.setErrorLabel("les données sont mal formatées (numéro de téléphone  ex : 5149998888)");
                data = false;
            }
            try {
                ld = LocalDate.parse(birthday, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (Exception e) {
                addVisitorView.setErrorLabel("Les données ne sont pas au bon format (YYYY-MM-DD)");
                data = false;
            }
            id = generateId();

            // si les data sont bien formatées alors on crée le visiteur
            if (data) {
                VisitorModel visitor = new VisitorModel(id, firstName, lastName, ld, email,
                        Integer.toString(phone), address, postal.toUpperCase(), city);
                VisitorRepository.GetInstance().addVisitor(visitor);
                addVisitorView.setTextLabel("Le visiteur a bien été ajouté");
            }
        } else {
            addVisitorView.setErrorLabel("Les données ne sont pas au bon format");
        }
    }

    /**
     * Generating unique ID for visitor
     *
     * ID is max 10 caracters
     *
     * @return id
     * @throws IOException
     */
    public String generateId() throws IOException {
        boolean unique = true;
        Random rn = new Random();
        ArrayList<VisitorModel> visitorList = VisitorRepository.GetInstance().getVisitorList();
        String id;

        // on veut s'assurer que l'on attribue un id unique
        do {

            // on crée un identifiant
            id = rn.ints(97, 123).limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            // on doit vérifier que l'id est unique en le comparant avec les autres
            for (VisitorModel visitor : visitorList) {
                if (id.equals(visitor.getAccountId())) {
                    unique = false;
                    break;
                }
            }
        } while (!unique); // on recommence si on a attribué un id déjà existant
        return id;
    }

    // *** getter *** //

    /**
     * Displaying View
     * @return addVisitorView
     */
    public AddVisitorView getView() {
        return addVisitorView;
    }
    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                validateAddVisitor();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class GoBackToMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            addVisitorView.emptyTextField();
            addVisitorView.hideAddVisitorView();
            try {
                VisitorController.GetInstance().DisplayVisitorView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
