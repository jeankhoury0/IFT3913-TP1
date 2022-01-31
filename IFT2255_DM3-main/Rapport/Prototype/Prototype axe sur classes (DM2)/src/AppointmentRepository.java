import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AppointmentRepository {

	ArrayList<Appointment> aptList = new ArrayList<Appointment>();

	/**
	 * 
	 * @param aptNumber
	 */
	public boolean addAppointment(Appointment apt) {
		aptList.add(apt);
		return true;
	}

	/**
	 * 
	 * @param aptNumber
	 */
	public void editAppointment(String aptNumber) {
		for(apt : aptList) {
			if(apt.getAppointmentNumber() == aptNumber) {
				Scanner in = new Scanner(System.in);
				System.out.println("Quel attribut voulez-vous modifier?");
				System.out.println("[1] Nom de reservation");
				System.out.println("[2] Prenom de reservaiton");
				System.out.println("[3] Date de reservation");
				System.out.println("[4] Temps de reservation");
				System.out.println("[5] Type de dose");
				System.out.println("[6] Retour a l'arriere");

				String attr = in.nextLine();

				switch(attr) {
					case 1:
						Scanner type = new Scanner(System.in);
						System.out.println("Quel est le nouveau nom pour la reservation?");
						String change = type.nextline();
						AppointmentController.getAppointment(aptNumber).setAptLastName(change);
						break;
					case 2:
						Scanner type = new Scanner(System.in);
						System.out.println("Quel est le nouveau prenom pour la reservation?");
						String change = type.nextline();
						AppointmentController.getAppointment(aptNumber).setAptFirstName(change);
						break;
					case 3:
						Scanner type = new Scanner(System.in);
						System.out.println("Quel est la nouvelle date de reservation? (format YYYY-MM-JJ)");
						String change = type.nextline();
						AppointmentController.getAppointment(aptNumber).setAptDate( (Date) change);
						break;
					case 4:
						Scanner type = new Scanner(System.in);
						System.out.println("Quel est la nouvelle periode pour la reservation? (heure pres)");
						String change = type.nextline();
						AppointmentController.getAppointment(aptNumber).setAptTime(change);
						break;
					case 5:
						Scanner type = new Scanner(System.in);
						System.out.println("Quel est le type de dose de la reservation? (1 ou 2)");
						String change = type.nextline();
						AppointmentController.getAppointment(aptNumber).setAptDoseType( (int) change);
						break;
					case 6:
						break;
					default:
						System.out.println("Choix invalide, veuillez reessayer.");
				}
			}
		}
	}

	/**
	 * 
	 * @param aptNumber
	 */
	public void removeAppointment(String aptNumber) {
		for(apt : AppointmentRepository) {
			if(apt.getAppointmentNumber() == aptNumber) {
				AppointmentRepository.remove(getAppointment(aptNumber));
			}
		}
	}

}