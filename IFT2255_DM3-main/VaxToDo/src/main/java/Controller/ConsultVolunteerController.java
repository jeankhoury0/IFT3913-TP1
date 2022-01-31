package controller;

import view.ConsultVolunteerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConsultVolunteerController {
    // *** attributes *** //

    private static ConsultVolunteerController cvcInstance;
    private final ConsultVolunteerView consultVolunteerView;

    // *** constructor *** //

    /**
     * Vonlunteer consultation Constroller Builder
     *
     * @throws IOException
     */
    private ConsultVolunteerController() throws IOException {

        this.consultVolunteerView = new ConsultVolunteerView();

        // on ajoute les listeners aux boutons appropriés
        this.consultVolunteerView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating instance of controller
     *
     * @return cvcInstance
     * @throws IOException
     */
    public static ConsultVolunteerController GetInstance() throws IOException {
        if (cvcInstance == null)
            cvcInstance = new ConsultVolunteerController();
        return cvcInstance;
    }

    /**
     * Display view
     */
    public void DisplayConsultVolunteerView(){
        this.consultVolunteerView.showConsultVolunteerView();
    }

    /**
     * View getter
     *
     * @return this.consultVolunteerView
     */
    public ConsultVolunteerView getView(){
        return this.consultVolunteerView;
    }

    // *** nested class : action listeners *** //

    class GoBackToMenuListener implements ActionListener {
        /**
         * Return button
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e){
            consultVolunteerView.hideConsultVolunteerView();
            try {
                UserController.GetInstance().DisplayUserView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
