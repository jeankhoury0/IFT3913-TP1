package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UserView extends JFrame{

    // *** attributes *** //

    private JPanel userPanel;
    private JButton addUserButton, editUserButton, findUserButton, deleteUserButton,
            goToMainMenuButton, consultVolunteerListButton;

    // *** constructor *** //

    public UserView() {
        super("Gestion des utilisateurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(userPanel); // set loginPanel instead ?
        this.pack();
    }

    // *** methods *** //

    public void hideUserView(){
        this.setVisible(false);
    }

    public void showUserView(){
        this.setVisible(true);
    }

    // *** actions & listeners *** //

    public void addAddUserListener(ActionListener listenAddUserButton){
        addUserButton.addActionListener(listenAddUserButton);
    }

    public void addDeleteUserListener(ActionListener listenDeleteUserButton){
        deleteUserButton.addActionListener(listenDeleteUserButton);
    }

    public void addFindUserListener(ActionListener listenFindUserButton){
        findUserButton.addActionListener(listenFindUserButton);
    }

    public void addEditUserListener(ActionListener listenEditUserButton){
        editUserButton.addActionListener(listenEditUserButton);
    }

    public void addConsultVolunteerListListener(ActionListener listenConsultVolunteerListMenuButton){
        consultVolunteerListButton.addActionListener(listenConsultVolunteerListMenuButton);
    }

    public void addGoToMenuListener(ActionListener listenGoToMenuButton){
        goToMainMenuButton.addActionListener(listenGoToMenuButton);
    }

}
