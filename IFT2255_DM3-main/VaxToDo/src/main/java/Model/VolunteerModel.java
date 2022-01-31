package model;

import utils.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class VolunteerModel extends UserModel {
    /**
     * Constructeur de modèles des informations de bénévoles
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
     * @param password
     */
    public VolunteerModel(String accountId, String firstName, String lastName,
                          LocalDate birthday, String mail, String phone, String address,
                          String postal, String city, String password) {
        super(accountId, firstName, lastName, birthday, mail, phone, address, postal, city, password);
    }

    /**
     * Encodage des informations du bénévole
     *
     * @return String.format
     */
    public String encodeVolunteer() {
        ArrayList<String> addressSplit = new ArrayList<String>(Arrays.asList(this.getAddress().split(" ")));
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

        return String.format("%s %s %s %s %s %s %s %s %s %s", this.getAccountId(), this.getFirstName(),
                this.getLastName(), this.getBirthday().toString(), this.getMail(), this.getPhone(),
                address, this.getPostal(), this.getCity(), this.getPassword());
    }

    // *** constructor *** //


}