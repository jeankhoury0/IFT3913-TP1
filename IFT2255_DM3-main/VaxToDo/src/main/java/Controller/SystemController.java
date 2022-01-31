// la classe SystemController est la classe qui prend tous
// les inputs de l'utilisateur du système Vaxtodo et les redirige
// vers les sous contrôleurs spécialisés
// tous les contrôleurs agrégés dans le SystemController sont des singletons.
// Le systeme controller est relié à la vu du menu et à la vu du login.

package controller;

import view.MenuView;
import view.VisitorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SystemController {

	// *** attributes *** //

	private final UserController ucInstance;
	private final CalendarController ccInstance;
	private final VisitorController vcInstance;
	private static SystemController scInstance;
	private final MenuView menuView; // la vue du menu principal

	// *** constructor *** //

	/**
	 * Controller builder
	 *
	 * @throws IOException
	 */
	public SystemController() throws IOException {

		// on instancie les menus du programme
		this.ucInstance = UserController.GetInstance();
		this.ccInstance = CalendarController.GetInstance();
		this.vcInstance = VisitorController.GetInstance();
		this.menuView = new MenuView();

		// on ajoute les listeners aux boutons appropriés
		this.menuView.addUserListener(new UserListener());
		this.menuView.addVisitorListener(new VisitorListener());
		this.menuView.addLogoutListener(new LogoutListener());
		this.menuView.addCalendarListener(new CalendarListener());

		ucInstance.DisplayLoginView();

	}

	/**
	 * Méthode statique utile pour créer l'unique instance du contrôleur système
	 *
	 * @return scInstance
	 * @throws IOException
	 */
	public static SystemController GetInstance() throws IOException {
		if (scInstance == null)
			scInstance = new SystemController();
		return scInstance;
	}

	// *** view methods *** //

	/**
	 * Display visitor view (menu)
	 */
	public void DisplayVisitorView(){
		this.menuView.hideMenuView();
		this.vcInstance.DisplayVisitorView();
	}

	/**
	 * Display user view (menu)
	 */
	public void DisplayUserView(){
		this.menuView.hideMenuView();
		this.ucInstance.DisplayUserView();
	}

	/**
	 * Display Calendar view
	 */
	public void DisplayCalendarView(){
		this.menuView.hideMenuView();
		this.ccInstance.DisplayCalendarView();
	}

	/**
	 * Display login view
	 */
	public void DisplayLoginView(){
		this.menuView.hideMenuView();
		this.ucInstance.DisplayLoginView();
	}

	/**
	 * Display menu
	 */
	public void DisplayMenuView(){
		this.menuView.showMenuView();
	}

	/**
	 * Menu getter
	 * @return menuView
	 */
	public MenuView GetView(){
		return menuView;
	}

	// *** nested class : action listener *** //

	class VisitorListener implements ActionListener {
		/**
		 * checking user persmission
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			try {
				vcInstance.getView().checkPermission();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			DisplayVisitorView();
		}
	}

	class UserListener implements ActionListener {
		/**
		 * User menu
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			DisplayUserView();
		}
	}

	class CalendarListener implements ActionListener {
		/**
		 * Validating permission to show calendar
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			try {
				ccInstance.getView().checkPermission();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			DisplayCalendarView();
		}
	}

	class LogoutListener implements ActionListener {
		/**
		 * Show login screen
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			DisplayLoginView();
		}
	}

}