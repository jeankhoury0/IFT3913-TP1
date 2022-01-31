package controller;

import view.ConsultCalendarView;
import view.ConsultVisitorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConsultVisitorController {
    // *** attributes *** //

    private static ConsultVisitorController cvcInstance;
    private final ConsultVisitorView consultVisitorView;

    // *** constructor *** //

    /**
     * Visitor consultation Constroller Construction
     *
     * @throws IOException
     */
    private ConsultVisitorController() throws IOException {

        this.consultVisitorView = new ConsultVisitorView();

        // on ajoute les listeners aux boutons appropriés
        this.consultVisitorView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating instance of controller
     *
     * @return cvcInstance
     * @throws IOException
     */
    public static ConsultVisitorController GetInstance() throws IOException {
        if (cvcInstance == null)
            cvcInstance = new ConsultVisitorController();
        return cvcInstance;
    }

    /**
     * View Display
     */
    public void DisplayConsultVisitorView(){
        this.consultVisitorView.showConsultVisitorView();
    }

    public ConsultVisitorView getView(){
        return this.consultVisitorView;
    }

    // *** nested class : action listeners *** //

    class GoBackToMenuListener implements ActionListener {
        /**
         * Return button
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e){
            consultVisitorView.hideConsultVisitorView();
            try {
                VisitorController.GetInstance().DisplayVisitorView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

