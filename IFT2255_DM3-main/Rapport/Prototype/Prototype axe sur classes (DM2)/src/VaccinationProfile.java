import java.util.Scanner;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class VaccinationProfile {

	// Attributes
	private Date vaccinationDate;
	private int doseType;
	private VaccineName vaccineName;
	private String vaccineCode;
	private String vaccineLot;

	// Getters & Setters
	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public int getDoseType() {
		return doseType;
	}

	public void setDoseType(int doseType) {
		this.doseType = doseType;
	}

	public VaccineName getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(VaccineName vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getVaccineCode() {
		return vaccineCode;
	}

	public void setVaccineCode(String vaccineCode) {
		this.vaccineCode = vaccineCode;
	}

	public String getVaccineLot() {
		return vaccineLot;
	}

	public void setVaccineLot(String vaccineLot) {
		this.vaccineLot = vaccineLot;
	}

	// Methods
	public VaccinationProfile getVaxProfile(String visitorNumber) {

		Scanner input = new Scanner(System.in);

		System.out.println("Voici le profil de vaccination du visiteur a code " + visitorNumber + " : ");
		System.out.println("Date de vaccination : " + getVaccinationDate());
		System.out.println("Type de dose : " + getDoseType());
		System.out.println("Nom du vaccin : " + getVaccineName());
		System.out.println("Code du vaccin : " + getVaccineCode());
		System.out.println("Lot du vaccin : " + getVaccineLot());
		System.out.println("-------------------------------------------------------");
		System.out.println("Que voulez-vous faire?");
		System.out.println("[1] Envoyer le profil au visiteur concerne.");
		System.out.println("[2] Retour a l'arriere.");

		String choice = input.nextLine();

		switch(choice) {
			case 1:
				emailVaxProfile(getVisitor(visitorNumber).getVisitorEmail);
				break;
			case 2:
				displayVisitorMenu();
				break;
			default:
				System.out.println("Choix invalide, veuillez reessayer.");
		}
	}

	/**
	 * 
	 * @param visitorEmail
	 */
	public static void emailVaxProfile(String visitorEmail) {
		String to = visitorEmail;
		String from = "staff@VaxTodore.ca";
		String host = "localhost";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("VaxTodo:re, votre profil de vaccination");

//			message.setText(.txt) [ A COMPLETER ]

			Transport.send(message);
			System.out.println("Vaccination profile successfully sent!");
		} catch (MessaginException mex) {
			mex.PrintStackTrace();
		}
	}

}