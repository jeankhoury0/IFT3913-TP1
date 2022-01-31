import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	private User currentUser;

	public void open() {
		displayLoginPage();
		displayMainMenu();
		throw new UnsupportedOperationException();
	}

	public void displayLoginPage() {
		try {
//			Fake user for debuggin purposes
//			User johnD = new User(001, "123456", "test123", "Doe", "John", "1221 Kappiaume", "T9S 3E2",
//					"Montreal", "johndoe1908@gmail.com", "5141234567");

			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("####################################\n" +
					"# Bienvenue au systeme VaxToDo:re! #\n" +
					"####################################\n" +
					"     Menu d'authentification        \n");
			System.out.println("Code d'identification : ");
			String user = console.readLine();
			System.out.println("Mot de passe : ");
			String password = console.readLine();
			System.out.println(user + " " + password);

			while (!(LoginController.validateUser(user, password))) {
				System.out.println("Mot de passe incorrect, reessayez de nouveau.");
				password = console.readLine();
			}
			System.out.println("Poggers!");
			throw new UnsupportedOperationException();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void displayMainMenu() {

	}

	public void exit() {
		// TODO - implement Menu.exit
		throw new UnsupportedOperationException();
	}

}