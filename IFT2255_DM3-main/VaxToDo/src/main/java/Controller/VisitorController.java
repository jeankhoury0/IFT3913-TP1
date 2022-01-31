
// singleton

package controller;

import model.VisitorModel;
import repository.VisitorRepository;
import utils.Id;
import view.UserView;
import view.VisitorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VisitorController {

    // *** attributes *** //
    private static VisitorController vcInstance;
    private final VisitorRepository vrInstance;
    private final VisitorView visitorView;
    private static AddVisitorController avcInstance;
    private static DeleteVisitorController dvcInstance;
    private static FindVisitorController fvcInstance;
    private static ConsultVisitorController cvInstance;

    // *** constructor *** //

    /**
     * Visitor Controller Builder
     * @throws IOException
     */
    private VisitorController() throws IOException {
        // on instancie le modèle et la vue
        vrInstance = VisitorRepository.GetInstance();
        visitorView = new VisitorView();
        avcInstance = AddVisitorController.GetInstance();
        dvcInstance = DeleteVisitorController.GetInstance();
        fvcInstance = FindVisitorController.GetInstance();
        cvInstance = ConsultVisitorController.GetInstance();

        // on lie les listeners aux boutons appropriés
        this.visitorView.addAddVisitorListener(new AddVisitorListener());
//		this.visitorView.addEditVisitorListener(new EditVisitorListener());
        this.visitorView.addFindVisitorListener(new FindVisitorListener());
        this.visitorView.addDeleteVisitorListener(new DeleteVisitorListener());
        this.visitorView.addGoToMenuListener(new GoBackListener());
        this.visitorView.addConsultVisitorListener(new ConsultVisitorListener());
    }

    /**
     * Méthode statique utile pour créer l'unique instance du contrôleur système
     *
     * @return vcInstance
     * @throws IOException
     */
    public static VisitorController GetInstance() throws IOException {
        if (vcInstance == null)
            vcInstance = new VisitorController();
        return vcInstance;
    }

    // *** model methods *** //

    /**
     * get visitor by entering existing id number
     *
     * @param id
     */
    public VisitorModel getVisitor(Id id) {
        // TODO - implement VisitorController.getVisitor
        throw new UnsupportedOperationException();
    }

    /**
     * Create visitor from the user entries
     *
     * @param infos
     */
    public void createVisitor(String[] infos) {
        // TODO - implement VisitorController.createVisitorAccount
        throw new UnsupportedOperationException();
    }

    // *** view methods *** //

    /**
     * Get VisitorView
     *
     * @return visitorView
     */
    public VisitorView getView() {
        return visitorView;
    }

    /**
     * Display VisitorView
     */
    void DisplayVisitorView() {
        this.visitorView.showVisitorView();
    }

    /**
     * Show "Add Visitor" View
     */
    public void DisplayAddVisitorView() {
        this.visitorView.hideVisitorView();
        avcInstance.DisplayAddVisitorView();
    }

    /**
     * Show "Find Visistor" view
     */
    public void DisplayFindVisitorView() {
        this.visitorView.hideVisitorView();
        fvcInstance.DisplayFindVisitorView();
    }

    /**
     * Show "Edit Visitor" view
     */
    public void DisplayEditVisitorView() {
        this.visitorView.hideVisitorView();
//        avcInstance.DisplayEditUserPanel();
    }

    /**
     * Display "Delete visitor" view
     */
    public void DisplayDeleteVisitorView() {
        this.visitorView.hideVisitorView();
        dvcInstance.DisplayDeleteVisitorView();
    }

    /**
     * Display "Consult visitor" view
     */
    public void DisplayConsultVisitorView() {
        this.visitorView.hideVisitorView();
        cvInstance.DisplayConsultVisitorView();
    }

    // *** nested class : action listeners *** //

    class AddVisitorListener implements ActionListener {
        /**
         * Display view
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            DisplayAddVisitorView();
        }

    }

    class DeleteVisitorListener implements ActionListener {
        /**
         * Delete button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            dvcInstance.getView().emptyTextField();
            dvcInstance.getView().setTextLabel("");
            DisplayDeleteVisitorView();
        }
    }

    class FindVisitorListener implements ActionListener {
        /**
         * Find visitor button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            fvcInstance.getView().emptyTextField();
            fvcInstance.getView().setTextLabel("");
            DisplayFindVisitorView();
        }
    }

/*	class EditVisitorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DisplayEditVisitorView();
		}
	}*/

    class ConsultVisitorListener implements ActionListener {
        /**
         * Consult profile button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            cvInstance.getView().setVisitorListLabel(vrInstance.toString());
            DisplayConsultVisitorView();
        }
    }

    class GoBackListener implements ActionListener {
        /**
         * Return button
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            visitorView.hideVisitorView();
            try {
                SystemController.GetInstance().DisplayMenuView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}