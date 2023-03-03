package fr.fms.entities;

public class User {

	public int idUser;
	public String login;
	public String password;
	
	public User (int idUser, String login, String password) {
		this.idUser = idUser;
		this.login = login;
		this.password = password;
	}

	private int getIdUser() {
		return idUser;
	}

	private void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	private String getLogin() {
		return login;
	}

	private void setLogin(String login) {
		this.login = login;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
}
