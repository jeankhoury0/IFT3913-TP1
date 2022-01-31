package application;

import controller.*;
import model.AppointmentModel;
import model.VisitorModel;
import org.junit.jupiter.api.Test;
import repository.AppointmentRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

class VaxTodoTest {


    /**
     * Cette classe permet de couvrir des tests plus larges et d'instancier tous les
     * contrôleurs et les vues comme si un utilisateur itérait dans l'application.
     * @throws IOException utilise des singletons et ouvre des fichiers textes
     * @author Pierre Janier Dubry
     * @date 2021-12-16
     */
    @Test
    public void main() throws IOException {


        SystemController systemController = SystemController.GetInstance();
        UserController userController = UserController.GetInstance();
        VisitorController visitorController = VisitorController.GetInstance();
        CalendarController calendarController = CalendarController.GetInstance();
        AddAppointmentController addAppointmentController = AddAppointmentController.GetInstance();


        // *** login *** //
        userController.login("user1", "a");

        // *** ajout puis suppression d'un rdv *** //
        AppointmentModel apt = new AppointmentModel(new VisitorModel("mohamed", "ali"), LocalDate.of(2012, 12, 12)
                , LocalTime.of(11, 11, 11), "aaaaaaaaaa");
        AppointmentRepository aptRepos = AppointmentRepository.GetInstance();
        aptRepos.addAppointment(apt);
        assert (aptRepos.findAppointment("aaaaaaaaaa"));
        aptRepos.removeAppointment("aaaaaaaaaa");
        assert (!aptRepos.findAppointment("aaaaaaaaaa"));

        // à continuer ...

        // *** déplacement dans les menus *** //
        systemController.DisplayCalendarView();
        systemController.DisplayLoginView();
        systemController.DisplayLoginView();
        systemController.DisplayMenuView();
        systemController.DisplayUserView();
        systemController.DisplayVisitorView();
        userController.DisplayUserView();
        userController.DisplayLoginView();
        userController.DisplayAddUserView();
        userController.DisplayDeleteUserView();
        userController.DisplayFindUserView();
        userController.DisplayConsultVolunteerListView();
    }
}