// contient dans une liste les données relatives aux visiteurs ayant un compte confirmé
// singleton

package repository;

import model.VisitorModel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;

public class VisitorRepository {

    // *** attribute *** //

    ArrayList<VisitorModel> visitorList;
    private static VisitorRepository vrInstance;
    private final File visitorFile, vaccinationProfileFile;

    // *** constructor *** //

    private VisitorRepository() throws IOException {
        this.visitorList = new ArrayList<>();
        vaccinationProfileFile = new File("src/main/java/resource/vaccinationProfile.txt");
        visitorFile = new File("src/main/java/resource/visitor.txt");
        lireVisitorFile(); // on charge les comptes visiteurs confirmés
        lireVaccinationProfileFile(); // on charge leur vaccinationProfile.txt de vaccination
    }

    public static VisitorRepository GetInstance() throws IOException {
        if (vrInstance == null)
            vrInstance = new VisitorRepository();
        return vrInstance;
    }

    // *** methods *** //

    public ArrayList<VisitorModel> getVisitorList() {
        return visitorList;
    }

    /**
     * Cette fonction retourne vrai s'il y a au moins un visiteur
     * sinon retourne faux.
     *
     * @param accountId l'entier identificateur du visiteur
     */
    public boolean findVisitor(String accountId) {
        return getVisitor(accountId) != null;
    }

    /**
     * Ajoute un visiteur à la base de donnée
     *
     * @param visitor le visiteur à ajouter dans la structure de donnée et le fichier
     */
    public void addVisitor(VisitorModel visitor) throws IOException {
        visitorList.add(visitor);

        // on ajoute le rdv dans le fichier texte pour la persistance des données
        FileWriter fw = new FileWriter(visitorFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(visitor.encodeVisitor());
        bw.newLine(); // saut de ligne
        bw.close();
        fw.close();
    }

    /**
     * Cette fonction retourne un visiteur ce qui rend possible
     * sa modification
     *
     * @param accountId l'entier identificateur du visiteur
     */
    public VisitorModel getVisitor(String accountId) {
        for (VisitorModel visitor : visitorList) {
            if (visitor.getAccountId().equals(accountId)) {
                return visitor;
            }
        }
        return null;
    }

    /**
     * Supprimer un visiteur de la base de donnée
     *
     * @param id l'entier identificateur du visiteur
     */
    public void removeVisitor(String id) throws IOException {
        VisitorModel toRemove = getVisitor(id);
        if (toRemove != null) {
            visitorList.remove(toRemove);

            // créer un fichier temporaire vide
            File temp = File.createTempFile("temp", ".txt", visitorFile.getParentFile());

            // on veut lire dans le fichier d'origine
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(visitorFile), StandardCharsets.UTF_8));

            // et écrire dans le fichier temporaire
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(temp), StandardCharsets.UTF_8));

            // parcourir le fichier d'origine ligne par ligne et copier la ligne lue dans un string
            for (String line; (line = reader.readLine()) != null; ) {

                // analyser le string et split en fonction des espaces vide puis regarder l'id
                String[] infos = line.split(" ");
                // si l'id de la ligne correspond à l'id comparé
                if (!id.equals(infos[0])) {
                    // alors écrire la ligne dans le fichier dans le nouveau fichier temporaire
                    writer.write(line);
                    writer.newLine();
                }
            }
            writer.close();
            reader.close();

            // remplacer le fichier d'origine par le fichier temporaire en le renommant
            visitorFile.delete();
            temp.renameTo(visitorFile);
        }
    }

    /**
     * lireRemplir lit le fichier texte users.txt, extrait les informations
     * puis les stocke dans la liste dynamique en instanciant les utilisateurs
     * déjà dans le système.
     *
     * @throws IOException si le fichier employee.txt n'est pas trouvé
     */
    private void lireVisitorFile() throws IOException {
        // InputStream is = getClass().getClassLoader().getResourceAsStream("resource/visitor.txt");
        FileReader fr = new FileReader(visitorFile);
        BufferedReader entree = new BufferedReader(fr);
        boolean finFichier = false;

        while (!finFichier) {
            String uneLigne = entree.readLine();

            if (uneLigne == null || uneLigne.length() < 1)
                finFichier = true;
            else {

                VisitorModel visitor;
                String[] infos = uneLigne.split(" ");
                String accountId = infos[0];
                String firstName = infos[1];
                String lastName = infos[2];
                LocalDate birthday = decodeDate(infos[3]);
                String mail = infos[4];
                String phone = infos[5];
                String address = infos[6];
                String postal = infos[7];
                String city = infos[8];

                visitor = new VisitorModel(accountId, firstName, lastName, birthday,
                        mail, phone, address, postal, city);
//                System.out.println(visitor.toString());
                this.visitorList.add(visitor);
            }
        }
        entree.close();
    }

    /**
     * Lecture du profil de vaccination
     * @throws IOException
     */
    private void lireVaccinationProfileFile() throws IOException {
//        InputStream is = getClass().getClassLoader().getResourceAsStream("resource/vaccinationProfile.txt");
//        assert is != null;
        FileReader fr = new FileReader(vaccinationProfileFile);
        BufferedReader entree = new BufferedReader(fr);
        boolean finFichier = false;

        while (!finFichier) {
            String uneLigne = entree.readLine();

            if (uneLigne == null || uneLigne.length() < 1)
                finFichier = true;
            else {

                String[] infos = uneLigne.split(" ");
                String accountId = infos[0];
                LocalDate date = decodeDate(infos[1]);
                String vaccineName = infos[2];
                String vaccineCode = infos[3];

                getVisitor(accountId).addVaccine(date, vaccineName, vaccineCode);
            }
        }
        entree.close();
    }

    private void ecrireVisitorFile() throws IOException {
        FileWriter fw = new FileWriter(visitorFile);
        BufferedWriter entree = new BufferedWriter(fw);
    }

    private void ecrireVaccinationProfileFile() throws IOException {
        FileWriter fw = new FileWriter(vaccinationProfileFile);
        BufferedWriter entree = new BufferedWriter(fw);
    }

    private LocalDate decodeDate(String date) {
        return LocalDate.parse(date);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------\n");
        for (VisitorModel v : this.visitorList) {
            s.append(v.toString()).append("----------\n");
        }
        return s.toString();
    }

    public static void main(String[] args) throws IOException {
        VisitorRepository vr = new VisitorRepository();
//        System.out.println(vr.visitorFile.toString());
//        System.out.println(vr.vaccinationProfileFile.toString());

    }

}