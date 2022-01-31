/**
 * Un compte utilisateur pour se connecter doit fournir un code d'id de
 * 9 chiffres et un mot de passe composé d'au moins 8 caractères et
 * avec au moins 1 Maj, 1 min, 1 chiffre et 1 caractère spécial.
 * <p>
 * Un utilisateur contient
 * - un numéro de compte de 12 caractères.
 * - un prénom de maximum 50 caractères sans espace.
 * - un nom de maximum 50 caractères et sans espace.
 * - une date de naissance YYYY-MM-JJ
 * - une adresse courriel
 * - un numéro de téléphone de 10 chiffres.
 * - une adresse postale de 100 caractères maximum.
 * - un code postal de 6 caractères
 * - une ville de 50 caractères maximum.
 */

package model;

import utils.VaccinationProfile;

import java.time.LocalDate;

public class UserModel {

    // *** attributes *** //

    private final String accountId;
    private String lastName;
    private String firstName;
    private final String mail;
    private final String address;
    private String password;
    private final String postal;
    private final String phone;
    private final String city;
    private final LocalDate birthday;


    /**
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
    // *** constructor *** /
    public UserModel(String accountId, String firstName, String lastName, LocalDate birthday,
                     String mail, String phone, String address, String postal, String city,
                     String password) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.password = password;
    }

    /**
     * Modification du mot de passe
     *
     * @param oldPassword
     * @param newPassword
     */
    public boolean editPassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    // *** getter & setters *** //
    public String getAccountId() {
        return this.accountId;
    }

    public String getPassword() {
        return password;
    }

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

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public String getPostal() {
        return postal;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "accountId=" + accountId + " " +
                ", lastName=" + lastName + " " +
                ", firstName=" + firstName + " " +
                ", mail=" + mail + " " +
                ", address=" + address + " " +
                ", password=" + password + " " +
                ", postal=" + postal + " " +
                ", phone=" + phone + " " +
                ", birthday=" + birthday;
    }
}