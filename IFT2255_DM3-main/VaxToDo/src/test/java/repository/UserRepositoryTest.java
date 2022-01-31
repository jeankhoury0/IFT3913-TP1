package repository;

import controller.AddVisitorController;
import model.VolunteerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserRepositoryTest {

    AddVisitorController visitorController;
    String id;
    VolunteerModel v;
    UserRepository ur;


    /**
     *
     * @throws IOException ouverture de fichiers textes
     * @author François Quang Vinh LE
     * @date 2021-12-16
     */
    @BeforeEach
    public void setUp() throws IOException {
        visitorController = new AddVisitorController();
        id = visitorController.generateId();
        v = new VolunteerModel(id, "prenom", "nom", LocalDate.of(2000, 12, 02),
                "prenom.nom@gmail.com", "5142226666", "6.rue_de_la_maison", "H2P8T4", "Montréal", "a");
        ur = new UserRepository();
    }

    /**
     *
     * @throws IOException ouverture de fichiers textes
     * @author François Quang Vinh LE
     * @date 2021-12-16
     */
    @Test
    void findVolunteer() throws IOException {
        ur.addVolunteer(v);
        assert (ur.findVolunteer(id));
        ur.removeVolunteer(id);
    }

    /**
     *
     * @throws IOException ouverture de fichiers textes
     * @author François Quang Vinh LE
     * @date 2021-12-16
     */
    @Test
    void addVolunteer() throws IOException {
        ur.addVolunteer(v);
        assert (ur.findVolunteer(id));
        ur.removeVolunteer(id);
    }

    /**
     *
     * @throws IOException ouverture de fichiers textes
     * @author François Quang Vinh LE
     * @date 2021-12-16
     */
    @Test
    void getVolunteer() throws IOException {
        ur.addVolunteer(v);
        assert (ur.getVolunteer(id).equals(v));
        ur.removeVolunteer(id);
    }

    /**
     *
     * @throws IOException ouverture de fichiers textes
     * @author François Quang Vinh LE
     * @date 2021-12-16
     */
    @Test
    void removeVolunteer() throws IOException {
        ur.addVolunteer(v);
        ur.removeVolunteer(id);
        assert (!ur.findVolunteer(id));

    }

    /**
     *
     * @throws IOException ouverture de fichiers textes
     * @author François Quang Vinh LE
     * @date 2021-12-16
     */
    @Test
    void authentification() throws IOException {
        ur.addVolunteer(v);
        assertNotEquals(ur.authentification(id, "a"), null);
        ur.removeVolunteer(id);
    }


}