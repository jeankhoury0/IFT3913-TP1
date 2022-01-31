package view;

import controller.UserController;
import model.UserModel;
import model.VolunteerModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VisitorView extends JFrame {

    // *** attributes *** //

    private JPanel visitorPanel;
    private JButton addVisitorButton;
    private JButton deleteVisitorButton;
    private JButton findVisitorButton;
    private JButton editVisitorButton;
    private JButton goBackButton;
    private JButton consultVisitorButton;

    // *** constructor *** //

    public VisitorView() {

        // on instancie le menu des visiteurs
        super("Menu des visiteurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(visitorPanel); // set loginPanel instead ?
        this.pack();
    }

    // *** methods *** //

    public void checkPermission() throws IOException {
        UserModel connectedUser = UserController.GetInstance().getConnectedUser();
        if(connectedUser instanceof VolunteerModel){
            addVisitorButton.setVisible(false);
            deleteVisitorButton.setVisible(false);
            editVisitorButton.setVisible(false);
            findVisitorButton.setVisible(false);
        } else {
            addVisitorButton.setVisible(true);
            deleteVisitorButton.setVisible(true);
            editVisitorButton.setVisible(true);
            findVisitorButton.setVisible(true);
        }
    }

    public void hideVisitorView() {
        this.setVisible(false);
    }

    public void showVisitorView() {
        this.setVisible(true);
    }

    // *** actions & listeners *** //

    public void addAddVisitorListener(ActionListener listenAddVisitorButton) {
        addVisitorButton.addActionListener(listenAddVisitorButton);
    }

    public void addDeleteVisitorListener(ActionListener listenDeleteVisitorButton) {
        deleteVisitorButton.addActionListener(listenDeleteVisitorButton);
    }

    public void addFindVisitorListener(ActionListener listenFindVisitorButton) {
        findVisitorButton.addActionListener(listenFindVisitorButton);
    }

    public void addEditVisitorListener(ActionListener listenEditVisitorButton) {
        editVisitorButton.addActionListener(listenEditVisitorButton);
    }

    public void addGoToMenuListener(ActionListener listenGoToMenuButton) {
        goBackButton.addActionListener(listenGoToMenuButton);
    }

    public void addConsultVisitorListener(ActionListener listenGoToMenuButton) {
        consultVisitorButton.addActionListener(listenGoToMenuButton);
    }

}
