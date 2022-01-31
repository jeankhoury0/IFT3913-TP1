// le calendrier est simplement un tableau de plusieurs rendez-vous.

package model;
import repository.AppointmentRepository;

import java.io.IOException;
import java.util.ArrayList;


public class CalendarModel {

	private final AppointmentRepository appointmentRepository;

	/**
	 * Calendar builder
	 *
	 * @throws IOException
	 */
	public CalendarModel() throws IOException {
		// comparer les rendez-vous avec la date et l'heure courante
		this.appointmentRepository = AppointmentRepository.GetInstance();
	}

	/**
	 * Get List of appointments
	 * @return appointmentRepository
	 */
	public AppointmentRepository getAppointmentRepository(){
		return appointmentRepository;
	}

	@Override
	public String toString() {
		return appointmentRepository.toString();
	}
}