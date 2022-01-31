package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserModelTest {

    UserModel u;

    @BeforeEach
    public void setUp() {
        u = new UserModel("user1", "prenom", "nom", LocalDate.of(2000, 12, 02),
                "prenom.nom@gmail.com", "5142226666", "6.rue_de_la_maison", "H2P8T4", "Montréal", "a");

    }

    @Test
    void editPassword() {
        u.editPassword("a", "b");
        assert (u.getPassword().equals("b"));
    }

    @Test
    void getAccountId() {
        u.editPassword("a", "b");
        assert (u.getAccountId().equals("user1"));
    }

    @Test
    void setLastName() {
        u.setLastName("b");
        assert (u.getLastName().equals("b"));

    }
}