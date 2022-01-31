public class AppointmentController extends Controller {
	/**
	 * 
	 * @param resNumber
	 */
	public Appointment getAppointment(String aptNumber) {
		for(thisAppointment : AppointmentRepository) {
			if (thisAppointment.getAppointmentNumber() == aptNumber) {
				return thisAppointment;
			}
		}
	}

	/**
	 * 
	 * @param infos
	 */
	public void createAppointment(String[] infos) {
		Appointment apt = Appointment(infos[0], infos[1], infos[2],
									  infos[3], infos[4], infos[5]);

		AppointmentRepository.addAppointment(apt);
	}

}