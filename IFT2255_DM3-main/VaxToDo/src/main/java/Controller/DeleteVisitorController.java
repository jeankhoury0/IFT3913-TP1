package controller;

import model.VisitorModel;
import repository.VisitorRepository;
import view.DeleteVisitorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteVisitorController {

    // *** attributes *** //

    private static DeleteVisitorController dvcInstance;
    private final DeleteVisitorView deleteVisitorView;

    // *** constructor *** //

    /**
     * Controller constructor
     *
     * @throws IOException
     */
    private DeleteVisitorController() throws IOException {

        this.deleteVisitorView = new DeleteVisitorView();

        // on ajoute les listeners aux boutons appropriés
        this.deleteVisitorView.addValidateListener(new ValidationListener());
        this.deleteVisitorView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating instance of controller
     *
     * @return dvcInstance
     * @throws IOException
     */
    public static DeleteVisitorController GetInstance() throws IOException {
        if (dvcInstance == null)
            dvcInstance = new DeleteVisitorController();
        return dvcInstance;
    }

    /**
     * Display View
     *
     * Delete visitor
     */
    public void DisplayDeleteVisitorView() {
        this.deleteVisitorView.showDeleteVisitorView();
    }

    /**
     * Visitor ID validation
     * Deleting visitor from database
     *
     * @throws IOException
     */
    private void deleteVisitor() throws IOException {
        String id = deleteVisitorView.getIdTextField();

        if (id.length() != 10) {
            deleteVisitorView.setErrorMessage("L'identificateur est dans le mauvais format");
        } else {
            VisitorRepository vrList = VisitorRepository.GetInstance();
            VisitorModel visitor = vrList.getVisitor(id);
            if (vrList.findVisitor(id)) {
                vrList.removeVisitor(id);
                deleteVisitorView.setAnswerLabel("Le visiteur a bien été supprimé");

            } else {
                deleteVisitorView.setAnswerLabel("Le visiteur n'a pas été trouvé");
            }
        }
    }

    public DeleteVisitorView getView(){
        return this.deleteVisitorView;
    }

// *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        /**
         * Delete button
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            try {
                deleteVisitor();
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
            deleteVisitorView.hideDeleteVisitorView();
            try {
                VisitorController.GetInstance().DisplayVisitorView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
