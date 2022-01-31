public class Calendar {

	private Date[] date;
	private Time[] period;
	private Appointment[] appointments;

	public Calendar(Date[] date, Time[] period, Appointment[] appointments) {
		this.date = date;
		this.period = period;
		this.appointments = appointments;
	}

	public Date[] getDate() {
		return date;
	}

	public void setDate(Date[] date) {
		this.date = date;
	}

	public Time[] getPeriod() {
		return period;
	}

	public void setPeriod(Time[] period) {
		this.period = period;
	}

	public Appointment[] getAppointments() {
		return appointments;
	}

	public void setAppointments(Appointment[] appointments) {
		this.appointments = appointments;
	}
}