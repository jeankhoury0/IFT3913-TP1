package controller;


import model.EmployeeModel;
import model.UserModel;
import model.VisitorModel;
import model.VolunteerModel;
import repository.UserRepository;
import repository.VisitorRepository;
import view.FindUserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FindUserController {

    // *** attributes *** //

    private static FindUserController fucInstance;
    private final FindUserView findUserView;

    // *** constructor *** //

    /**
     * Controller builder
     *
     * @throws IOException
     */
    private FindUserController() throws IOException {

        this.findUserView = new FindUserView();

        // on ajoute les listeners aux boutons appropriés
        this.findUserView.addValidateListener(new ValidationListener());
        this.findUserView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating controller instance
     *
     * @return fucInstance
     * @throws IOException
     */
    public static FindUserController GetInstance() throws IOException {
        if (fucInstance == null)
            fucInstance = new FindUserController();
        return fucInstance;
    }

    /**
     * View getter
     * @return findUserView
     */
    public FindUserView getView() {
        return findUserView;
    }

    /**
     * View display
     */
    public void DisplayFindUserView() {
        this.findUserView.showFindUserView();
    }

    /**
     * User lookup
     * user ID validation
     *
     * @throws IOException
     */
    private void validateFindUser() throws IOException {
        String id = findUserView.getFindUserIdTextField();
        boolean trouve = false;
        ArrayList<EmployeeModel> empList = UserRepository.GetInstance().getEmployeeList();
        ArrayList<VolunteerModel> volList = UserRepository.GetInstance().getVolunteerList();

        for (EmployeeModel emp : empList) {
            if (id.equals(emp.getAccountId())) {
                trouve = true;
                findUserView.setTextLabel(String.format("L'employé %s %s est bien dans la base de donnée", emp.getFirstName(), emp.getLastName()));
                break;
            }
        }

        if (!trouve) {
            for (VolunteerModel volunteer : volList) {
                if (id.equals(volunteer.getAccountId())) {
                    trouve = true;
                    findUserView.setTextLabel(String.format("Le bénévole %s %s est bien dans la base de donnée", volunteer.getFirstName(), volunteer.getLastName()));
                    break;
                }
            }
        }

        if (!trouve) {
            findUserView.setTextLabel("L'utilisateur n'est pas dans la base de donnée");
        }
    }
    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        /**
         * Action button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            try {
                validateFindUser();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class GoBackToMenuListener implements ActionListener {
        /**
         * Return to menu button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            findUserView.hideFindUserView();
            try {
                UserController.GetInstance().DisplayUserView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
