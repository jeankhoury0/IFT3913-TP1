package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ConsultVolunteerView extends JFrame {
    private JPanel consultVolunteerListPanel;
    private JButton goBackButton;
    private JLabel volunteerTitleLabel;
    private JLabel volunteerListLabel;

    public ConsultVolunteerView() {
        super("Consulter les bénévoles");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(consultVolunteerListPanel);
        this.pack();
    }

    // *** methods *** //

    public void hideConsultVolunteerView() {
        this.setVisible(false);
    }

    public void showConsultVolunteerView() {
        this.setVisible(true);
    }

    public void setVisitorListLabel(String visitorList) {
        this.volunteerListLabel.setText(visitorList);
        this.pack();
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }

}
