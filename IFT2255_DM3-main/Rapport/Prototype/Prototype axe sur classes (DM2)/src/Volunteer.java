public class Volunteer extends User {

    // Attributes
    private int userNumber;
    private String userId;
    private String userPassword;
    private String uLastName;
    private String uFirstName;
    private String uAddress;
    private String uPostalCode;
    private String uCity;
    private String uEmail;
    private String uPhoneNumber;

    // Getters & Setters


    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getuLastName() {
        return uLastName;
    }

    public void setuLastName(String uLastName) {
        this.uLastName = uLastName;
    }

    public String getuFirstName() {
        return uFirstName;
    }

    public void setuFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuPostalCode() {
        return uPostalCode;
    }

    public void setuPostalCode(String uPostalCode) {
        this.uPostalCode = uPostalCode;
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhoneNumber() {
        return uPhoneNumber;
    }

    public void setuPhoneNumber(String uPhoneNumber) {
        this.uPhoneNumber = uPhoneNumber;
    }

    public Volunteer(String userNumber, String userId, String userPassword, String uLastName, String uFirstName,
                     String uAddress, String uPostalCode, String uCity, String uEmail, String uPhoneNumber) {
        this.userNumber = userNumber;
        this.userId = userId;
        this.userPassword = userPassword;
        this.uLastName = uLastName;
        this.uFirstName = uFirstName;
        this.uAddress = uAddress;
        this.uPostalCode = uPostalCode;
        this.uCity = uCity;
        this.uEmail = uEmail;
        this.uPhoneNumber = uPhoneNumber;
    }
}