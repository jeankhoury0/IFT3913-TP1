package model;

import utils.Id;

import java.time.LocalDate;

public class EmployeeModel extends UserModel {
    // *** constructor *** //

    /**
     * Employee date builder
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
    public EmployeeModel(String accountId, String firstName, String lastName,
                         LocalDate birthday, String mail, String phone, String address,
                         String postal, String city, String password) {
        super(accountId, firstName, lastName, birthday, mail, phone, address, postal, city, password);
    }


}