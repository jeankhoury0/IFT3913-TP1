public class UserRepository {

	ArrayList<User> userList = new ArrayList<User>();

	/**
	 * 
	 * @param userId
	 */
	public boolean hasUser(int userId) {
		for(User activeUser : userList) {
			if(activeUser.getUserId() == userId) {return true;}
		}
		return false;
	}

	/**
	 * 
	 * @param user
	 */
	public boolean addUser(User user) {
		userList.add(user);
		return true;
	}

	/**
	 * 
	 * @param userId
	 */
	public void editUser(String userId) {
		// TODO - implement UserRepository.editUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 */
	public void removeUser(String userId) {
		// TODO - implement UserRepository.removeUser
		throw new UnsupportedOperationException();
	}

}