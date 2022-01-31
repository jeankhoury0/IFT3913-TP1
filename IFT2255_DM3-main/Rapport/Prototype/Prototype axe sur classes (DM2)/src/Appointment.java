public class Appointment {

	// Attributes
	private String appointmentNumber;
	private String aptFirstName;
	private String aptLastName;
	private Date aptDate;
	private Time aptTime;
	private int aptDoseType;

	// Constructor
	public Appointment(int appointmentNumber, String aptFirstName,
					   String aptLastName, Date aptDate,
					   Time aptTime, int aptDoseType) {
		this.appointmentNumber = appointmentNumber;
		this.aptFirstName = aptFirstName;
		this.aptLastName = aptLastName;
		this.aptDate = aptDate;
		this.aptTime = aptTime;
		this.aptDoseType = aptDoseType;
	}

	// Getters & Setters
	public int getAppointmentNumber() {
		return appointmentNumber;
	}

	public void setAppointmentNumber(int appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	public String getAptFirstName() {
		return aptFirstName;
	}

	public void setAptFirstName(String aptFirstName) {
		this.aptFirstName = aptFirstName;
	}

	public String getAptLastName() {
		return aptLastName;
	}

	public void setAptLastName(String aptLastName) {
		this.aptLastName = aptLastName;
	}

	public Date getAptDate() {
		return aptDate;
	}

	public void setAptDate(Date aptDate) {
		this.aptDate = aptDate;
	}

	public Time getAptTime() {
		return aptTime;
	}

	public void setAptTime(Time aptTime) {
		this.aptTime = aptTime;
	}

	public int getAptDoseType() {
		return aptDoseType;
	}

	public void setAptDoseType(int aptDoseType) {
		this.aptDoseType = aptDoseType;
	}
}