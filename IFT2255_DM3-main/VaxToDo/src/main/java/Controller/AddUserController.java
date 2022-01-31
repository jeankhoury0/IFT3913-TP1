package controller;

import model.VisitorModel;
import model.VolunteerModel;
import repository.UserRepository;
import repository.VisitorRepository;
import view.AddVolunteerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class AddUserController {

    // *** attributes *** //

    private static AddUserController aucInstance;
    private final AddVolunteerView addVolunteerView;

    // *** constructor *** //

    /**
     * Add new User Controller
     *
     * @throws IOException
     */
    private AddUserController() throws IOException {

        this.addVolunteerView = new AddVolunteerView();

        // on ajoute les listeners aux boutons appropriés
        this.addVolunteerView.addValidateListener(new ValidationListener());
        this.addVolunteerView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating a new controller instance
     *
     * @return aucInstance
     * @throws IOException
     */
    public static AddUserController GetInstance() throws IOException {
        if (aucInstance == null)
            aucInstance = new AddUserController();
        return aucInstance;
    }

    /**
     * new user validation
     *
     * validating the user entries, making sure that it is not already in the database
     * and also validating the formatting
     *
     * @throws IOException
     */
    private void validateAddVolunteer() throws IOException {
        boolean data = true; // si les données sont bien formatter alors on crée le visiteur

        String id = "";
        LocalDate ld = null;
        String firstName = addVolunteerView.getFirstName();
        String lastName = addVolunteerView.getLastName();
        String birthday = addVolunteerView.getBirthday();
        String email = addVolunteerView.getMail();
        String postal = addVolunteerView.getPostal();
        String phoneString = addVolunteerView.getPhone();
        String city = addVolunteerView.getCity();
        String address = addVolunteerView.getAddress();
        String password = addVolunteerView.getPassword();
        String confirmedPassword = addVolunteerView.getConfirmPassword();

        // vérifier la longueur des données
        if (firstName.length() < 50 && lastName.length() < 50 && phoneString.length() <= 10
                && postal.length() <= 6 && address.length() < 100 && city.length() < 50
                && email.length() < 50 && email.contains("@")) {

            if (!(password.equals(confirmedPassword))) {
                addVolunteerView.setErrorMessage("les mots de passe ne sont pas similaires.");
                data = false;
            }

            // on convertit le téléphone en entier
            int phone = 0;
            try {
                phone = Integer.parseInt(phoneString);
            } catch (NumberFormatException e) {
                addVolunteerView.setErrorMessage("les données sont mal formatées (numéro de téléphone  ex : 5149998888)");
                data = false;
            }
            try {
                ld = LocalDate.parse(birthday, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (Exception e) {
                addVolunteerView.setErrorMessage("Les données ne sont pas au bon format (YYYY-MM-DD)");
                data = false;
            }
            id = generateId();

            // si les data sont bien formatées alors on crée le visiteur
            if (data) {
                VolunteerModel volunteer = new VolunteerModel(id, firstName, lastName, ld,
                        email, Integer.toString(phone), address, postal.toUpperCase(), city, password);

                UserRepository.GetInstance().addVolunteer(volunteer);
                String s = String.format("Bénévole ajouté. Notez bien votre identifiant : %s", id);
                addVolunteerView.setTextLabel(s);
            }
        } else {
            addVolunteerView.setErrorMessage("Les données ne sont pas au bon format");
        }
    }

    /**
     * Generate unique ID
     *
     * ID is max 10 caracters
     *
     * @return id
     * @throws IOException
     */
    public String generateId() throws IOException {
        boolean unique = true;
        Random rn = new Random();
        ArrayList<VolunteerModel> volunteerList = UserRepository.GetInstance().getVolunteerList();
        String id;

        // on veut s'assurer que l'on attribue un id unique
        do {
            // on crée un identifiant
            id = rn.ints(97, 123).limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            // on doit vérifier que l'id est unique en le comparant avec les autres
            for (VolunteerModel volunteer : volunteerList) {
                if (id.equals(volunteer.getAccountId())) {
                    unique = false;
                    break;
                }
            }
        } while (!unique); // on recommence si on a attribué un id déjà existant
        return id;
    }

    /**
     * Display new User View
     */
    public void DisplayAddUserView() {
        this.addVolunteerView.showAddUserView();
    }
    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                validateAddVolunteer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class GoBackToMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            addVolunteerView.hideAddUserView();
            try {
                UserController.GetInstance().DisplayUserView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
