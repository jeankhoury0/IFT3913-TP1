package repository;

import controller.AddVisitorController;
import model.AppointmentModel;
import model.VisitorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentRepositoryTest {

    AddVisitorController visitorController;
    AppointmentRepository ar;
    AppointmentModel ap;
    String id;

    @BeforeEach
    public void setUp() throws IOException {
        visitorController = new AddVisitorController();
        ar = new AppointmentRepository();
        id = visitorController.generateId();
        ap = new AppointmentModel(new VisitorModel("mohamed", "ali"), LocalDate.of(2012, 12, 12)
                , LocalTime.of(11, 11, 11), id);
    }

    @Test
    void getInstance() throws IOException {
        assertNotEquals(AppointmentRepository.GetInstance(), null);
    }

    @Test
    void addAppointment() throws IOException {
        ar.addAppointment(ap);
        assert (ar.getAppointment(id).equals(ap));
        ar.removeAppointment(id);
    }

    @Test
    void findAppointment() throws IOException {
        ar.addAppointment(ap);
        assert (ar.findAppointment(id));
        ar.removeAppointment(id);
    }


    @Test
    void removeAppointment() throws IOException {
        ar.addAppointment(ap);
        ar.removeAppointment(id);
        assert (!ar.findAppointment(id));
    }

}