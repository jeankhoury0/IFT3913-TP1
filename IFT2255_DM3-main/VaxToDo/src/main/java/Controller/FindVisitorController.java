package controller;

import model.VisitorModel;
import repository.VisitorRepository;
import view.FindVisitorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FindVisitorController {

    // *** attributes *** //

    private static FindVisitorController fvcInstance;
    private final FindVisitorView findVisitorView;

    // *** constructor *** //

    /**
     * Visitor lookup controller builder
     * @throws IOException
     */
    private FindVisitorController() throws IOException {

        this.findVisitorView = new FindVisitorView();

        // on ajoute les listeners aux boutons appropriés
        this.findVisitorView.addValidateListener(new ValidationListener());
        this.findVisitorView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating controller instance
     *
     * @return fvcInstance
     * @throws IOException
     */
    public static FindVisitorController GetInstance() throws IOException {
        if (fvcInstance == null)
            fvcInstance = new FindVisitorController();
        return fvcInstance;
    }

    /**
     * Display view
     */
    public void DisplayFindVisitorView() {
        this.findVisitorView.showFindVisitorView();
    }

    /**
     * view Getter
     * @return findVisitorView
     */
    public FindVisitorView getView() {
        return findVisitorView;
    }

    /**
     * visitor ID validation
     * visitor lookup in database
     *
     * @throws IOException
     */
    private void ValidateFindVisitor() throws IOException {
        String id = findVisitorView.getFindVisitorTextField();
        // trouver le visiteur correspondant à l'id et écrire la réponse
        boolean trouve = false;
        ArrayList<VisitorModel> visitorList = VisitorRepository.GetInstance().getVisitorList();

        for (VisitorModel visitor : visitorList) {
            if (id.equals(visitor.getAccountId())) {
                trouve = true;
                findVisitorView.setTextLabel("Le visiteur est bien dans la base de donnée");
                break;
            }
        }
        if (!trouve) {
            findVisitorView.setTextLabel("Le visiteur n'est pas dans la base de donnée");
        }

    }
    // *** nested class : action listeners *** //

    class ValidationListener implements ActionListener {
        /**
         * Lookup action button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            try {
                ValidateFindVisitor();
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
            findVisitorView.hideFindVisitorView();
            try {
                VisitorController.GetInstance().DisplayVisitorView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
