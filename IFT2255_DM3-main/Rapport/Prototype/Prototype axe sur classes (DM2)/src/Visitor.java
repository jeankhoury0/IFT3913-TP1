public class Visitor {

	// Attributes
	private String visitorNumber;
	private String vLastName;
	private String vFirstName;
	private Date visitorBirthday;
	private String visitorEmail;
	private String vPhoneNumber;

	// Getters & Setters

	public String getVisitorNumber() {
		return visitorNumber;
	}

	public void setVisitorNumber(String visitorNumber) {
		this.visitorNumber = visitorNumber;
	}

	public String getvLastName() {
		return vLastName;
	}

	public void setvLastName(String vLastName) {
		this.vLastName = vLastName;
	}

	public String getvFirstName() {
		return vFirstName;
	}

	public void setvFirstName(String vFirstName) {
		this.vFirstName = vFirstName;
	}

	public Date getVisitorBirthday() {
		return visitorBirthday;
	}

	public void setVisitorBirthday(Date visitorBirthday) {
		this.visitorBirthday = visitorBirthday;
	}

	public String getVisitorEmail() {
		return visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}

	public String getvPhoneNumber() {
		return vPhoneNumber;
	}

	public void setvPhoneNumber(String vPhoneNumber) {
		this.vPhoneNumber = vPhoneNumber;
	}

	// Constructor
	public Visitor(String visitorNumber, String vLastName, String vFirstName,
				   Date visitorBirthday, String visitorEmail, String vPhoneNumber) {
		this.visitorNumber = visitorNumber;
		this.vLastName = vLastName;
		this.vFirstName = vFirstName;
		this.visitorBirthday = visitorBirthday;
		this.visitorEmail = visitorEmail;
		this.vPhoneNumber = vPhoneNumber;
	}
}