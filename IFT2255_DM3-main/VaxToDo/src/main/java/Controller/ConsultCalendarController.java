package controller;

import view.ConsultCalendarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConsultCalendarController {

    // *** attributes *** //

    private static ConsultCalendarController cacInstance;
    private final ConsultCalendarView consultCalendarView;

    // *** constructor *** //

    /**
     * Calendar consultation controller construction
     *
     * @throws IOException
     */
    private ConsultCalendarController() throws IOException {

        this.consultCalendarView = new ConsultCalendarView();

        // on ajoute les listeners aux boutons appropriés
        this.consultCalendarView.addGoBackListener(new GoBackToMenuListener());

    }

    /**
     * Creating instance of the Calendar consultation controller
     *
     * @return cacInstance
     * @throws IOException
     */
    public static ConsultCalendarController GetInstance() throws IOException {
        if (cacInstance == null)
            cacInstance = new ConsultCalendarController();
        return cacInstance;
    }

    /**
     * View Getter
     *
     * @return this.consultaCalendarView
     */
    public ConsultCalendarView getView(){
        return this.consultCalendarView;
    }

    public void DisplayAddAppointmentView(){
        this.consultCalendarView.showConsultCalendarView();
    }

    // *** nested class : action listeners *** //

    class GoBackToMenuListener implements ActionListener {
        /**
         * Return button
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e){
            consultCalendarView.hideConsultCalendarView();
            try {
                CalendarController.GetInstance().DisplayCalendarView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
