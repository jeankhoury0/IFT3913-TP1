// singleton

package repository;

import model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class AppointmentRepository {

    // *** attributes *** //

    ArrayList<AppointmentModel> appointments;
    private static AppointmentRepository arInstance;
    private final File appointmentFile;

    // *** constructor *** //

    AppointmentRepository() throws IOException {
        this.appointments = new ArrayList<AppointmentModel>();
        appointmentFile = new File("src/main/java/resource/appointment.txt");
        lireAppointmentFile();
    }

    public static AppointmentRepository GetInstance() throws IOException {
        if (arInstance == null)
            arInstance = new AppointmentRepository();
        return arInstance;
    }

    /**
     * Cette fonction ajoute un rendez-vous dans la base de données
     *
     * @param apt
     */
    public void addAppointment(AppointmentModel apt) throws IOException {
        // on ajoute le rdv dans la structure de donnée locale
        this.appointments.add(apt);

        // on ajoute le rdv dans le fichier texte pour la persistance des données
        FileWriter fw = new FileWriter(appointmentFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(apt.encodeAppointment());
        bw.newLine(); // saut de ligne
        bw.close();
        fw.close();
    }

    /**
     * @param id l'entier identificateur de l'appointment
     */
    public void editAppointment(String id) {
        AppointmentModel toEdit = getAppointment(id);
        // TODO - implement AppointmentRepository.editAppointment
        throw new UnsupportedOperationException();
    }

    /**
     * Cette fonction retourne vrai si il y a au moins 1 utilisateur
     * sinon retourne faux.
     *
     * @param id l'entier identificateur de l'appointment
     */
    public boolean findAppointment(String id) {
        return getAppointment(id) != null;
    }

    /**
     * Cette fonction retourne un Appointment ce qui rend possible
     * sa modification
     *
     * @param id
     */
    public AppointmentModel getAppointment(String id) {
        for (AppointmentModel appointment : appointments) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }

    /**
     * Cette fonction cancel un rendez-vous si id est dans la base de données
     *
     * @param id
     */
    public void removeAppointment(String id) throws IOException {
        AppointmentModel toRemove = getAppointment(id);
        if (toRemove != null) {
            // supprimer le fichier dans la structure de donnée
            appointments.remove(toRemove);

            // créer un fichier temporaire vide
            File temp = File.createTempFile("temp", ".txt", appointmentFile.getParentFile());

            // on veut lire dans le fichier d'origine
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(appointmentFile), StandardCharsets.UTF_8));

            // et écrire dans le fichier temporaire
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(temp), StandardCharsets.UTF_8));

            // parcourir le fichier d'origine ligne par ligne et copier la ligne lue dans un string
            for (String line; (line = reader.readLine()) != null; ) {

                // analyser le string et split en fonction des espaces vide puis regarder l'id
                String[] infos = line.split(" ");
                // si l'id de la ligne correspond à l'id comparé
                if (!id.equals(infos[3])) {
                    // alors écrire la ligne dans le fichier dans le nouveau fichier temporaire
                    writer.write(line);
                    writer.newLine();
                }
            }
            writer.close();
            reader.close();

            // remplacer le fichier d'origine par le fichier temporaire en le renommant
            appointmentFile.delete();
            temp.renameTo(appointmentFile);
        }
    }

    private void lireAppointmentFile() throws IOException {
//      InputStream is = getClass().getClassLoader().getResourceAsStream("resource/appointment.txt");
        // on fait un nouveau array à chaque fetch
        this.appointments = new ArrayList<AppointmentModel>();
        FileReader fr = new FileReader(appointmentFile);
        BufferedReader br = new BufferedReader(fr);
        boolean finFichier = false;

        while (!finFichier) {
            String uneLigne = br.readLine();

            if (uneLigne == null || uneLigne.length() < 1)
                finFichier = true;
            else {

                // on crée des comptes non confirmés de visiteur lors de la prise de rdv
                String[] infos = uneLigne.split(" ");
                LocalDate date = decodeDate(infos[0]);
                LocalTime hour = decodeTime(infos[1]);
                String visitors = infos[2];
//                String id = generateId();
                String id = infos[3];
                VisitorModel visitor1;
                VisitorModel visitor2;
                // on sépare les informations des 2 visiteurs
                String[] visitorList = visitors.split("/");

                if (visitorList.length > 1) {

                    // on sépare le nom et le prénom des visiteurs.
                    String[] infosVisiteur1 = visitorList[0].split("\\.");
                    String[] infosVisiteur2 = visitorList[1].split("\\.");

                    visitor1 = new VisitorModel(infosVisiteur1[0], infosVisiteur1[1]);
                    visitor2 = new VisitorModel(infosVisiteur2[0], infosVisiteur2[1]);
                    this.appointments.add(new AppointmentModel(visitor1, visitor2, date, hour, id));
                } else {
                    String[] infosVisiteur1 = visitorList[0].split("\\.");
                    visitor1 = new VisitorModel(infosVisiteur1[0], infosVisiteur1[1]);
                    this.appointments.add(new AppointmentModel(visitor1, date, hour, id));
                }
            }
        }
        br.close();
    }

    private LocalDate decodeDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);

    }

    private LocalTime decodeTime(String hour) {
        return LocalTime.parse(hour);
    }

    @Override
    public String toString() {
        // à chaque fois qu'on veut afficher le contenu on met à jour avant
        try {
            lireAppointmentFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // on affiche le contenu
        StringBuilder s = new StringBuilder();
        for (AppointmentModel apt : appointments) {
            s.append(apt.toString()).append("\n");
        }
        return s.toString();
    }

    public ArrayList<AppointmentModel> getAppointments() {
        return appointments;
    }

    public static void main(String[] args) throws IOException {

        AppointmentRepository ar = new AppointmentRepository();

    }

}