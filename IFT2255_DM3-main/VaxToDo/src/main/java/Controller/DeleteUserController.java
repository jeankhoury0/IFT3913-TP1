package controller;

import model.EmployeeModel;
import model.UserModel;
import model.VolunteerModel;
import repository.AppointmentRepository;
import repository.UserRepository;
import view.DeleteUserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteUserController {

    // *** attributes *** //

    private static DeleteUserController ducInstance;
    private final DeleteUserView deleteUserView;

    // *** constructor *** //

    /**
     * Controller builder
     *
     * @throws IOException
     */
    private DeleteUserController() throws IOException {

        this.deleteUserView = new DeleteUserView();

        // on ajoute les listeners aux boutons appropriés
        this.deleteUserView.addValidateListener(new ValidationListener());
        this.deleteUserView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating an instance of controller
     *
     * @return ducInstance
     * @throws IOException
     */
    public static DeleteUserController GetInstance() throws IOException {
        if (ducInstance == null)
            ducInstance = new DeleteUserController();
        return ducInstance;
    }

    /**
     * Deleting user if id valid
     * id validation
     *
     * @throws IOException
     */
    private void ValidateDeleteUser() throws IOException {
        String id = deleteUserView.getUserIdTextField();
        if (id.length() != 10) {
            deleteUserView.setErrorMessage("L'identificateur est dans le mauvais format");
        } else {
            UserRepository urList = UserController.getUserRepository();
            UserModel user = urList.getUser(id);
            if (user instanceof EmployeeModel) {

                urList.removeEmployee(id);
                deleteUserView.setAnswerLabel("L'employé a bien été supprimé");
            } else if (user instanceof VolunteerModel) {

                urList.removeVolunteer(id);
                deleteUserView.setAnswerLabel("Le bénévole a bien été supprimé");
            } else {
                deleteUserView.setAnswerLabel("L'utilisateur n'a pas été trouvé");
            }
        }
    }

    /**
     * View Getter
     * @return
     */
    public DeleteUserView getView() {
        return deleteUserView;
    }

    /**
     * Display view
     */
    public void DisplayDeleteUserView() {
        this.deleteUserView.showDeleteUserView();
    }

    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        /**
         * Delete user button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            try {
                ValidateDeleteUser();
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
            deleteUserView.hideDeleteUserView();
            try {
                UserController.GetInstance().DisplayUserView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

