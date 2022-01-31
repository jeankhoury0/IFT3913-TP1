// gère le login
// singleton

package controller;

import model.UserModel;
import repository.UserRepository;
import utils.Id;
import view.LoginView;
import view.UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserController {

    // *** attributes *** //

    private static UserRepository urInstance;
    private static UserController ucInstance; // l'unique instance du contrôleur des utilisateurs
    private static AddUserController aucInstance;
    private static FindUserController fucInstance;
    private static DeleteUserController ducInstance;
    private static ConsultVolunteerController cvcInstance;
    private final UserView userView; // la page de la gestion des utilisateurs du système
    private final LoginView loginView; // la vue du menu d'authentification
    public UserModel connectedUser;

    // *** constructor *** //

    /**
     * User menu cosntructor
     * @throws IOException
     */
    private UserController() throws IOException {
        // on instancie le modèle et les vues
        urInstance = UserRepository.GetInstance();
        aucInstance = AddUserController.GetInstance();
        fucInstance = FindUserController.GetInstance();
        ducInstance = DeleteUserController.GetInstance();
        cvcInstance = ConsultVolunteerController.GetInstance();
        this.userView = new UserView();
        this.loginView = new LoginView();

        // on ajoute les listeners aux boutons appropriés
        this.userView.addAddUserListener(new AddUserListener());
        this.userView.addDeleteUserListener(new DeleteUserListener());
        this.userView.addFindUserListener(new FindUserListener());
//        this.userView.addEditUserListener(new EditUserListener());
        this.userView.addGoToMenuListener(new GoBackToMenuListener());
        this.userView.addConsultVolunteerListListener(new ConsultVolunteerList());
        this.loginView.addLoginListener(new LoginListener());

        // par défaut aucun utilisateur connecté au programme
        this.connectedUser = null;
    }

    /**
     * Instancing controller
     * @return ucInstance
     * @throws IOException
     */
    public static UserController GetInstance() throws IOException {
        if (ucInstance == null)
            ucInstance = new UserController();
        return ucInstance;
    }

    // *** model methods *** //

    /**
     * Validating username and password
     *
     * @param id
     * @param password
     * @throws IOException
     */
    public void login(String id, String password) throws IOException {
        this.connectedUser = urInstance.authentification(id, password);
    }

    public boolean isLogged() {
        return this.connectedUser != null;
    }

    public static UserRepository getUserRepository() {
        return urInstance;
    }

    /**
     * Logging out
     */
    public void logout() {
        this.connectedUser = null;
    }

    /**
     * @param id
     */
    public UserModel getUser(Id id) {
        // TODO - implement LoginController.getUser
        throw new UnsupportedOperationException();
    }

    /**
     * User validation
     * checking id and password
     *
     * @param id
     * @param password
     *
     */
    public boolean validateUser(Id id, String password) {
        // TODO - implement LoginController.validateUser
        throw new UnsupportedOperationException();
    }

    /**
     * Creating new user
     */
    public void createUser() {
        // TODO - implement VisitorController.createVisitorAccount
        throw new UnsupportedOperationException();
    }

    public UserModel getConnectedUser() {
        return connectedUser;
    }

    // *** view methods *** //

    /**
     * Display view
     */
    public void DisplayLoginView() {
        this.connectedUser = null;
        this.loginView.showLoginView();
    }

    /**
     * Display User menu
     */
    public void DisplayUserView() {
        this.userView.showUserView();
    }

    /**
     * Add user menu
     */
    public void DisplayAddUserView() {
        this.userView.hideUserView();
        aucInstance.DisplayAddUserView();
    }

    /**
     * Looking for user in datebase menu
     */
    public void DisplayFindUserView() {
        this.userView.hideUserView();
        fucInstance.DisplayFindUserView();
    }

    /**
     * Edit user profile
     */
    public void DisplayEditUserView() {
        this.userView.hideUserView();
//        this.x.DisplayEditUserPanel();
    }

    /**
     * Delete user
     */
    public void DisplayDeleteUserView() {
        this.userView.hideUserView();
        ducInstance.DisplayDeleteUserView();
    }

    /**
     * Display list of volunteers
     */
    public void DisplayConsultVolunteerListView() {
        this.userView.hideUserView();
        cvcInstance.DisplayConsultVolunteerView();
    }

    // *** nested class : action listeners *** //

    // l'action listener pour se connecter
    class LoginListener implements ActionListener {
        /**
         * Login button
         * Validates username and password
         * Gives the correct permissions
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {

            String identification, password;
            identification = loginView.getIdentification();
            password = loginView.getPassword();

            try {
                ucInstance.login(identification, password);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (ucInstance.isLogged()) {
                // si les crédits de connection sont bons
                // afficher la vue du menu principal
//                loginView.displayErrorMessage("credits ok");
                loginView.hideLoginView();
                // go to menu principal
                try {
                    SystemController.GetInstance().GetView().checkPermission();
                    SystemController.GetInstance().DisplayMenuView();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                // afficher l'erreur
                loginView.displayErrorMessage("wrong credentials");
            }
        }
    }

    class AddUserListener implements ActionListener {
        /**
         * Add User button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            DisplayAddUserView();
        }
    }

    class EditUserListener implements ActionListener {
        /**
         * Edit user button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            DisplayEditUserView();
        }
    }

    class FindUserListener implements ActionListener {
        /**
         * Find user button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            fucInstance.getView().setTextLabel("");
            fucInstance.getView().emptyTextField();
            DisplayFindUserView();
        }
    }

    class DeleteUserListener implements ActionListener {
        /**
         * Delete user button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            ducInstance.getView().setTextLabel("Veuillez rentrer l'id de l'utilisateur à supprimer");
            ducInstance.getView().emptyTextField();
            DisplayDeleteUserView();
        }
    }

    class ConsultVolunteerList implements ActionListener {
        /**
         * See volunteer list button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            cvcInstance.getView().setVisitorListLabel(urInstance.toStringVolunteer());
            DisplayConsultVolunteerListView();
        }
    }

    class GoBackToMenuListener implements ActionListener {
        /**
         * Return button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            userView.hideUserView();
            try {
                SystemController.GetInstance().DisplayMenuView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}




