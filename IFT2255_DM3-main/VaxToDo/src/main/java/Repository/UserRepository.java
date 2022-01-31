// contient dans une liste les données relatives aux utilisateurs du système Vaxtodo
// singleton

package repository;

import model.EmployeeModel;
import model.UserModel;
import model.VolunteerModel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;


public class UserRepository {

    // *** attributs *** //

    ArrayList<EmployeeModel> employeeList;
    ArrayList<VolunteerModel> volunteerList;
    private static UserRepository urInstance;
    private final File employeeFile, volunteerFile;

    // *** constructor *** //

    UserRepository() throws IOException {
        this.employeeList = new ArrayList<>();
        this.volunteerList = new ArrayList<>();
        employeeFile = new File("src/main/java/resource/employee.txt");
        volunteerFile = new File("src/main/java/resource/volunteer.txt");
        lireEmpFile();
        lireVolunteerFile();
    }

    public static UserRepository GetInstance() throws IOException {
        if (urInstance == null)
            urInstance = new UserRepository();
        return urInstance;
    }

    // *** methods *** //

    /**
     * Cette fonction retourne vrai si il y a au moins 1 utilisateur
     * sinon retourne faux.
     *
     * @param id l'entier identificateur de l'utilisateur
     */
    public boolean findVolunteer(String id) {
        return getVolunteer(id) != null;
    }

    /**
     * Ajoute un utilisateur à la base de donnée
     *
     * @param volunteer un bénévole
     */
    public void addVolunteer(VolunteerModel volunteer) throws IOException {
        volunteerList.add(volunteer);

        // on ajoute le rdv dans le fichier texte pour la persistance des données
        FileWriter fw = new FileWriter(volunteerFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(volunteer.encodeVolunteer());
        bw.newLine(); // saut de ligne
        bw.close();
        fw.close();
    }

    public ArrayList<EmployeeModel> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<VolunteerModel> getVolunteerList() {
        return volunteerList;
    }

    /**
     * Cette fonction retourne un utilisateur ce qui rend possible
     * sa modification
     *
     * @param id l'entier identificateur de l'utilisateur
     */
    public VolunteerModel getVolunteer(String id) {
        for (VolunteerModel volunteer : volunteerList) {
            if (volunteer.getAccountId().equals(id)) {
                return volunteer;
            }
        }
        return null;
    }

    public EmployeeModel getEmployee(String id) {
        for (EmployeeModel employee : employeeList) {
            if (employee.getAccountId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public UserModel getUser(String id) {
        for (UserModel employee : employeeList) {
            if (employee.getAccountId().equals(id)) {
                return employee;
            }
        }

        for (UserModel volunteer : volunteerList) {
            if (volunteer.getAccountId().equals(id)) {
                return volunteer;
            }
        }
        return null;
    }

    /**
     * Supprimer un utilisateur de la base de donnée
     *
     * @param id l'entier identificateur de l'utilisateur
     */
    public void removeVolunteer(String id) throws IOException {
        VolunteerModel toRemove = getVolunteer(id);
        if (toRemove != null) {
            volunteerList.remove(toRemove);

            // créer un fichier temporaire vide
            File temp = File.createTempFile("temp", ".txt", volunteerFile.getParentFile());

            // on veut lire dans le fichier d'origine
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(volunteerFile), StandardCharsets.UTF_8));

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
            volunteerFile.delete();
            temp.renameTo(volunteerFile);
        }
    }

    /**
     * Supprimer un employée de la base de donnée
     *
     * @param id
     * @throws IOException
     */

    public void removeEmployee(String id) throws IOException {
        EmployeeModel toRemove = getEmployee(id);
        if (toRemove != null) {
            employeeList.remove(toRemove);

            // créer un fichier temporaire vide
            File temp = File.createTempFile("temp", ".txt", employeeFile.getParentFile());

            // on veut lire dans le fichier d'origine
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(employeeFile), StandardCharsets.UTF_8));

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
            employeeFile.delete();
            temp.renameTo(employeeFile);
        }
    }

    public String toStringVolunteer() {
        StringBuilder s = new StringBuilder();
        for (VolunteerModel volunteer : this.volunteerList) {
            if (volunteer != null) {
                s.append(volunteer);
            }
        }
        return s.toString();
    }

    /**
     * lireRemplir lit le fichier texte users.txt, extrait les informations
     * puis les stocke dans la liste dynamique en instanciant les utilisateurs
     * déjà dans le système.
     *
     * @throws IOException si le fichier employee.txt n'est pas trouvé
     */
    private void lireEmpFile() throws IOException {
//        InputStream is = getClass().getClassLoader().getResourceAsStream("resource/employee.txt");

        FileReader fr = new FileReader(employeeFile);
        BufferedReader br = new BufferedReader(fr);
        boolean finFichier = false;

        while (!finFichier) {
            String uneLigne = br.readLine();

            if (uneLigne == null || uneLigne.length() < 1)
                finFichier = true;

            else {
                EmployeeModel emp;
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
                String password = infos[9];

                emp = new EmployeeModel(accountId, firstName, lastName, birthday,
                        mail, phone, address, postal, city, password);

                this.employeeList.add(emp);
            }
        }
        br.close();
    }

    /**
     * Lectre du fichier de bénévole
     *
     * @throws IOException
     */
    private void lireVolunteerFile() throws IOException {

        FileReader fr = new FileReader(volunteerFile);
        BufferedReader br = new BufferedReader(fr);
        boolean finFichier = false;

        while (!finFichier) {
            String uneLigne = br.readLine();

            VolunteerModel volunteerModel = null;
            if (uneLigne == null || uneLigne.length() < 1)
                finFichier = true;

            else {
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
                String password = infos[9];

                volunteerModel = new VolunteerModel(accountId, firstName, lastName, birthday,
                        mail, phone, address, postal, city, password);

                this.volunteerList.add(volunteerModel);
            }
        }
        br.close();
    }

    private LocalDate decodeDate(String date) {
        return LocalDate.parse(date);
    }

    private int decodeInt(String code) {
        int c = 9;
        try {
            c = Integer.parseInt(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public UserModel authentification(String id, String pwd) {
        // on parcourt tous les employés
        for (EmployeeModel emp : employeeList) {
            if (emp.getAccountId().equals(id) && emp.getPassword().equals(pwd))
                return emp;
        }

        // on parcourt tous les bénévoles
        for (VolunteerModel vol : volunteerList) {
            if (vol.getAccountId().equals(id) && vol.getPassword().equals(pwd)) {
                return vol;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        UserRepository ur = new UserRepository();

        for (EmployeeModel emp : ur.employeeList) {
            System.out.println(emp.getAccountId());
        }

        for (VolunteerModel volunteer : ur.volunteerList) {
            System.out.println(volunteer.getAccountId());
        }
    }
}