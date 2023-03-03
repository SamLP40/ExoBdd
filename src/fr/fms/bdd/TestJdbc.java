/**
 * Programme de connexion à la base MariaDB.
 * 
 * @author Le-porcherS - 3-3-2023
 */
package fr.fms.bdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class TestJdbc {
/**
 * 
 * @param args
 * @throws Exception
 */
	public static void main (String[] args) throws Exception {

		ArrayList<Article> articles = new ArrayList<Article>();

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Enregistre la classe auprès du Driver manager (mariadb)
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//récupérer une connexion à partir d'une URL + id + mdp
		String url = "jdbc:mariadb://localhost:3306/Shop";
		String login = "root";
		String password = "fms2023";

		try(Connection connection = DriverManager.getConnection(url,login,password)) {
			String sqlUpdate = "UPDATE T_articles SET Description = 'Camera', UnitaryPrice = 75.5 WHERE IdArticle = 12";
			String sqlDelete = "DELETE FROM T_articles WHERE IdArticle = 18" ;
			String sqlInsert = "INSERT INTO T_articles (Description, Brand, UnitaryPrice) values ('Office', 'Microhard', 150)";
			String strSql = "SELECT * FROM T_articles";

			try(Statement statement = connection.createStatement()) {

				try(ResultSet resultSet = statement.executeQuery(strSql)) {
					try(ResultSet resultUpdate = statement.executeQuery(sqlUpdate)) {
						try(ResultSet resultDelete = statement.executeQuery(sqlDelete)) {
							try(ResultSet resultInsert = statement.executeQuery(sqlInsert)) {
								while(resultSet.next()) {
									int rsIdArticle = resultSet.getInt(1);
									String rsDescription = resultSet.getString(2);
									String rsBrand = resultSet.getString(3); // valeur entrée en sql = varchar
									double rsUnitaryPrice = resultSet.getDouble(4); // valeur entrée en SQL = float
									articles.add(new Article(rsIdArticle,rsDescription,rsBrand,rsUnitaryPrice));
								}
							}
						}
					}
				}
				for (Article a : articles) 
					System.out.println(a.getIdArticle()+ "-" + a.getDescription()+ "-" + a.getBrand() + "-" + a.getUnitaryPrice());


			} connection.close();
		} 
	}
/**
 * 
 * @return
 */
	public static Connection getConnection() {
	
		return null;
	} 
}

