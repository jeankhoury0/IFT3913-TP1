package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.VaccinationProfile;
import utils.VaccineName;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VisitorModelTest {

    VaccinationProfile profil;
    VisitorModel v;

    /**
     * @author Jenny DIEP
     * @date 2021-12-16
     */
    @BeforeEach
    public void setUp() {
        profil = new VaccinationProfile();
        v = new VisitorModel("visitor1", "prenom", "nom", LocalDate.of(2000, 12, 2),
                "prenom.nom@gmail.com", "5142226666", "6_rue_de_la_maison", "H2P8T4", "Montréal");
    }

    /**
     * @author Jenny DIEP
     * @date 2021-12-16
     */
    @Test
    void addVaccine() {
        profil.addVaccine(LocalDate.of(2012, 2, 2), VaccineName.Pfizer, "");
        v.addVaccine(LocalDate.of(2012, 2, 2), String.valueOf(VaccineName.Pfizer), "");
        assertNotEquals(v.getVaccine(), new VaccinationProfile());
    }

    /**
     * @author Jenny DIEP
     * @date 2021-12-16
     */
    @Test
    void getAccountId() {
        assertEquals(v.getAccountId(), "visitor1");
    }

    /**
     * @author Jenny DIEP
     * @date 2021-12-16
     */
    @Test
    void encodeVisitor() {
        String encode = "visitor1 prenom nom 2000-12-02 prenom.nom@gmail.com 5142226666 6_rue_de_la_maison H2P8T4 Montréal";
        assertEquals(v.encodeVisitor(), encode);
    }

    /**
     * @author Jenny DIEP
     * @date 2021-12-16
     */@Test
    void getVaccine() {
        v.addVaccine(LocalDate.of(2012, 2, 2), String.valueOf(VaccineName.Pfizer), "");
        assertNotEquals(v.getVaccine(), new VaccinationProfile());
    }
}