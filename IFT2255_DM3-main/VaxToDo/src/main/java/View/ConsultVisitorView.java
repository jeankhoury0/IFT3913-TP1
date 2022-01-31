package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ConsultVisitorView extends JFrame {
    private JLabel titleLabel;
    private JLabel visitorListLabel;
    private JPanel consultVisitorPanel;
    private JButton goBackButton;

    public ConsultVisitorView() {
        super("Consulter les visiteurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(consultVisitorPanel);
        this.pack();
    }

    // *** methods *** //

    public void hideConsultVisitorView() {
        this.setVisible(false);
    }

    public void showConsultVisitorView() {
        this.setVisible(true);
    }

    public void setVisitorListLabel(String visitorList){
        this.visitorListLabel.setText(visitorList);
        this.pack();
    }

    public void addGoBackListener(ActionListener listenGoBackButton) {
        goBackButton.addActionListener(listenGoBackButton);
    }
}
