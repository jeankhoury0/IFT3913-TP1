package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentModelTest {

    AppointmentModel a;
    VisitorModel c;

    @BeforeEach
    public void setUp() {
        c = new VisitorModel("mohamed", "ali");
        a = new AppointmentModel(c, LocalDate.of(2012, 12, 12)
                , LocalTime.of(11, 11, 11), "aaaaaaaaaa");

    }

    @Test
    public void encodeAppointment() {
        String encode = "2012-12-12 11:11:11 mohamed.ali aaaaaaaaaa";
        assertEquals(a.encodeAppointment(), encode);
    }

    @Test
    public void getId() {
        assertEquals(a.getId(), "aaaaaaaaaa");
    }

    @Test
    public void getVisitor1() {
        assert (c.equals(a.getVisitor1()));
    }

}