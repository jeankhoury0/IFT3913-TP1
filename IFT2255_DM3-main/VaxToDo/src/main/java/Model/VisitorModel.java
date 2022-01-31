/**
 * Un compte visiteur est confirmé dès lors de son premier rendez-vous.
 * Un visiteur dont le compte est confirmé signifie que ses informations
 * sont écrites dans le fichier texte du visiteur.
 * Un visiteur non confirmé peu prendre un premier rendez-vous
 * en ayant des informations partielles.
 * <p>
 * Un visiteur contient les mêmes données qu'un utilisateur, mais possède
 * un profil de vaccination en plus.
 */

package model;

import utils.VaccinationProfile;
import utils.VaccineName;

import java.time.LocalDate;
import java.util.*;


public class VisitorModel {

    private String accountId, lastName, firstName, mail, address, postal, phone, city;
    private LocalDate birthday;
    private VaccinationProfile profil;

    // les visiteurs confirmés ont un identificateur de compte

    /**
     * Constructeur d'informations pour les visiteurs confirmés
     *
     * @param accountId
     * @param firstName
     * @param lastName
     * @param birthday
     * @param mail
     * @param phone
     * @param address
     * @param postal
     * @param city
     */
    public VisitorModel(String accountId, String firstName, String lastName, LocalDate birthday,
                        String mail, String phone, String address, String postal, String city) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.profil = new VaccinationProfile();
    }

    // constructeur des visiteurs non confirmé

    /**
     * Constructeur des visiteurs non-confirmés
     *
     * @param firstName
     * @param lastName
     */
    public VisitorModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // *** methods *** //

    /**
     * Ajout de vaccin
     *
     * @param date
     * @param vaccineName
     * @param vaccineCode
     */
    public void addVaccine(LocalDate date, String vaccineName, String vaccineCode) {
        this.profil.addVaccine(date, VaccineName.valueOf(vaccineName), vaccineCode);
    }

    // *** getters & setters *** //


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public VaccinationProfile getVaccine() {
        return this.profil;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    // utile pour écrire les données de manière formatées

    /**
     * Formattage des données du visiteur
     *
     * @return String.format
     */
    public String encodeVisitor() {

        ArrayList<String> addressSplit = new ArrayList<String>(Arrays.asList(address.split(" ")));
        StringBuilder a = new StringBuilder();
        Iterator<String> iterator = addressSplit.iterator();

        // on formate l'adresse
        for (String i : addressSplit) {
            a.append(i);
            if (iterator.hasNext()) {
                a.append("_");
                iterator.next();
            }
        }

        String address = a.substring(0, a.length() - 1);

        return String.format("%s %s %s %s %s %s %s %s %s", accountId, firstName, lastName, birthday.toString(),
                mail, phone, address, postal, city);
    }

    // utile pour écrire les données de manière intelligible dans CLI
    @Override
    public String toString() {
        return accountId + "\n" + profil.toString() + "\n";
    }
}

