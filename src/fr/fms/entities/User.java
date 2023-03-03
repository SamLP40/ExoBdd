/**
 * Programme générant des utilisateurs à ajouter à la table t_user.
 * 
 * @author Le-porcherS - 3-3-2023
 */
package fr.fms.entities;

public class User {

	public int idUser;
	public String login;
	public String password;
/**
 * 	
 * @param idUser
 * @param login
 * @param password
 */
	public User (int idUser, String login, String password) {
		this.idUser = idUser;
		this.login = login;
		this.password = password;
	}
/**
 * 
 * @return
 */
	private int getIdUser() {
		return idUser;
	}
/**
 * 
 * @param idUser
 */
	private void setIdUser(int idUser) {
		this.idUser = idUser;
	}
/**
 * 
 * @return
 */
	private String getLogin() {
		return login;
	}
/**
 * 
 * @param login
 */
	private void setLogin(String login) {
		this.login = login;
	}
/**
 * 
 * @return
 */
	private String getPassword() {
		return password;
	}
/**
 * 
 * @param password
 */
	private void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + "]";
	}
	
}