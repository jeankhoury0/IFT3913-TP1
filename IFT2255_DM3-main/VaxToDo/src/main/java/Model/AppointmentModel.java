/**
 * un appointment est une quantité utilisée pour le calendrier
 * dans cette quantité est permet de lier les visiteurs à une date
 * dans le système. Donc un appointment décrit empiriquement une date.
 * On peut avoir au maximum 15 rendez vous par heure.
 * les horaires d'ouvertures sont de 8h à 18h du lundi au vendredi.
 *
 * LocalDate ld = LocalDate.of( 2018 , Month.JANUARY , 23 ) ;
 * LocalTime lt = LocalTime.of( 15 , 0 ) ;  // 3 PM in 24-hour time.
 * LocalDateTime ldt= LocalDateTime.of( ld , lt ) ;
 */

package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public class AppointmentModel {

    // *** attributes *** //
    private final String id;
    private final VisitorModel visitor1;
    private final VisitorModel visitor2; // juste prénom et nom
    private final LocalDate date;
    private final LocalTime hour;
    private final Duration duration = Duration.ofMinutes(60);

    // *** constructor *** //

    // un rendez-vous peut-être pris pour une ou deux personnes maximum

    /**
     * Appointment constructor
     * 1 visitor
     *
     * @param visitor1
     * @param date
     * @param hour
     * @param id
     */
    public AppointmentModel(VisitorModel visitor1, LocalDate date,
                            LocalTime hour, String id) {
        this.visitor1 = visitor1;
        this.visitor2 = null;
        this.date = date;
        this.hour = hour;
        this.id = id;
    }

    /**
     * Appointment constructor
     * 2 visitors
     *
     * @param visitor1
     * @param visitor2
     * @param date
     * @param hour
     * @param id
     */
    public AppointmentModel(VisitorModel visitor1, VisitorModel visitor2,
                            LocalDate date, LocalTime hour, String id) {
        this.visitor1 = visitor1;
        this.visitor2 = visitor2;
        this.date = date;
        this.hour = hour;
        this.id = id;
    }

    // *** methods *** //

    // utile pour imprimer les informations sur le CLI
    @Override
    public String toString() {
        if (visitor2 != null)
            return date.toString() + " " + hour.toString() + " "
                    + visitor1.getFirstName() + " " + visitor1.getLastName() + ", "
                    + visitor2.getFirstName() + " " + visitor2.getLastName() + "\n";
        else return date.toString() + " " + hour.toString() + " "
                + visitor1.getFirstName() + " " + visitor1.getLastName() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentModel that = (AppointmentModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // utile pour réécrire les données dans un fichier texte de manière formaté

    /**
     * Appointment information formatting
     * @return String.format
     */
    public String encodeAppointment() {
        if (visitor2 != null)
            return String.format("%s %s %s.%s/%s.%s %s", this.date.toString(), this.hour.toString(), visitor1.getFirstName(),
                    visitor1.getLastName(), visitor2.getFirstName(), visitor2.getLastName(), this.id);
        else
            return String.format("%s %s %s.%s %s", this.date.toString(), this.hour.toString(), visitor1.getFirstName(),
                    visitor1.getLastName(), this.id);
    }

    // *** getters & setters *** //

    public String getId() {
        return id;
    }

    public VisitorModel getVisitor1() {
        return visitor1;
    }

    public VisitorModel getVisitor2() {
        return visitor2;
    }

}

