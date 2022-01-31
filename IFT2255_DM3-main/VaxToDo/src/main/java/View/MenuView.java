package view;

import controller.UserController;
import model.EmployeeModel;
import model.UserModel;
import model.VolunteerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuView extends JFrame {

    // *** attributes *** //

    private JPanel loginPanel;
    private JPanel menuPanel;
    private JPanel visitorPanel;
    private JPanel userPanel;
    private JPanel calendarPanel;

    private JButton visitorButton;
    private JButton userButton;
    private JButton calendarButton;
    private JButton logoutButton;

    // *** constructor *** //

    public MenuView() throws IOException {
        super("Menu Principal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(450, 450);
        this.setContentPane(menuPanel); // set loginPanel instead ?
        this.pack();

    }

    // *** methods *** //

    // permet d'afficher les contrôles de la vue en fonction de qui est connecté
    public void checkPermission() throws IOException {
        UserModel connectedUser = UserController.GetInstance().getConnectedUser();
        userButton.setVisible(!(connectedUser instanceof VolunteerModel));
    }

    public void hideMenuView(){
        this.setVisible(false);
    }

    public void showMenuView(){
        this.setVisible(true);
    }

    public void displayLoginPage() {
        // TODO - implement Menu.displayLoginPage
        throw new UnsupportedOperationException();
    }

    public void displayUserMenu() {
        // TODO - implement Menu.displayUserMenu
        throw new UnsupportedOperationException();
    }

    public void displayVisitorMenu() {
        // TODO - implement Menu.displayVisitorMenu
        throw new UnsupportedOperationException();
    }

    public void displayCalendarMenu() {
        // TODO - implement Menu.displayCalendarMenu
        throw new UnsupportedOperationException();
    }

    public void logout() {
        // TODO - implement Menu.exit
        throw new UnsupportedOperationException();
    }

    // *** actions & listeners *** //

    public void addVisitorListener(ActionListener listenVisitorButton){
        visitorButton.addActionListener(listenVisitorButton);
    }

    public void addUserListener(ActionListener listenUserButton){
        userButton.addActionListener(listenUserButton);
    }

    public void addCalendarListener(ActionListener listenCalendarButton){
        calendarButton.addActionListener(listenCalendarButton);
    }

    public void addLogoutListener(ActionListener listenLogoutButton){
        logoutButton.addActionListener(listenLogoutButton);
    }

/*
    public static void main(String[] args){
        JFrame frame = new MenuView("VaxToDo");
        frame.setVisible(true);
    }
*/

}
