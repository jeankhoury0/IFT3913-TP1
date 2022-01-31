public class LoginController extends Controller {

	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public User login(String userId, String password) {
		// TODO - implement LoginController.login
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 */
	public boolean logout(User user) {
		// TODO - implement LoginController.logout
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 */
	public static User getUser(String userId) {
		User johnD = new User(001, "123456", "test123", "Doe", "John", "1221 Kappiaume", "T9S 3E2",
				"Montreal", "johndoe123@gmail.com", "5146266065");
		return johnD;
		// TODO - implement LoginController.getUser
	}

	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public static boolean validateUser(String userId, String password) {
		if(password != "test123") {return false;}
		//getUser(userId).getUserPassword()
		else {return true;}
	}

}