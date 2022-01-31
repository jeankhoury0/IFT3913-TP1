/**
 * Le profil de vaccination est une composante d'un visiteur dont le compte est confirmé.
 * Il est vide lors de la création du compte et il se remplie
 * par incrément. On peut rajouter une date et un vaccin à chaque fois.
 * Le type de la dose est la position dans array.
 */

package utils;

import java.time.LocalDate;
import java.util.ArrayList;

public class VaccinationProfile {

    private final ArrayList<Vaccine> vaccines;

    public VaccinationProfile() {
        vaccines = new ArrayList<>();
    }

    public void addVaccine(LocalDate date, VaccineName name, String code) {
        vaccines.add(new Vaccine(date, name, code));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Vaccine v : vaccines) {
            s.append(v.toString()).append("\n");
        }
        return s.toString();
    }

    class Vaccine {

        private final LocalDate date; // YYYY-MM-DD
        private final VaccineName vaccineName; // enum
        private final String vaccineCode; // 24 char max

        public Vaccine(LocalDate date, VaccineName vaccineName, String vaccineCode) {
            this.date = date;
            this.vaccineName = vaccineName;
            this.vaccineCode = vaccineCode;
        }

        @Override
        public String toString() {
            return String.format("Vaccin : %s - %s - %s",
                    date.toString(), this.vaccineName, this.vaccineCode);
        }
    }
}