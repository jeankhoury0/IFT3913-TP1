public class User {

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

	// Constructor
	public User(int userNumber, String userId, String userPassword, String uLastName,
				String uFirstName, String uAddress, String uPostalCode,
				String uCity, String uEmail, String uPhoneNumber) {

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

	// Getters & Setters
	public int getUserNumber() {
		return userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getuLastName() {
		return uLastName;
	}

	public String getuFirstName() {
		return uFirstName;
	}

	public String getuAddress() {
		return uAddress;
	}

	public String getuPostalCode() {
		return uPostalCode;
	}

	public String getuCity() {
		return uCity;
	}

	public String getuEmail() {
		return uEmail;
	}

	public String getuPhoneNumber() {
		return uPhoneNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setuLastName(String uLastName) {
		this.uLastName = uLastName;
	}

	public void setuFirstName(String uFirstName) {
		this.uFirstName = uFirstName;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public void setuPostalCode(String uPostalCode) {
		this.uPostalCode = uPostalCode;
	}

	public void setuCity(String uCity) {
		this.uCity = uCity;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public void setuPhoneNumber(String uPhoneNumber) {
		this.uPhoneNumber = uPhoneNumber;
	}

	/**
	 * 
	 * @param oldPassword
	 * @param newPassword
	 */
	public boolean changePassword(String oldPassword, String newPassword) {
		boolean match = false;
		while(!match) {
			Scanner oldPass = new Scanner(System.in);
			System.out.println("Entrez l'ancien mot de passe : ");
			String oldOne = oldPass.nextLine();
			if (old != oldPassword) {
				System.out.println("Le mot de passe ne concorde pas.");
			} else {match = true;}
		}
		Scanner newPass = new Scanner(System.in);
		System.out.println("Enter new password : ");
		String newOne = newPass.nextLine();
		this.setUserPassword(newOne);
	}

}