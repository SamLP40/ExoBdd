import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TestDelete {

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
		String sqlDelete = "DELETE FROM T_articles WHERE IdArticle=18" ;

		try(Statement statement = connection.createStatement()) {

			try(ResultSet resultSet = statement.executeQuery(sqlDelete)) {

						try(ResultSet resultDelete = statement.executeQuery(sqlDelete)) {

				while(resultSet.next()) {
					int rsIdArticle = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsUnitaryPrice = resultSet.getDouble(4);
					articles.add(new Article(rsIdArticle,rsDescription,rsBrand,rsUnitaryPrice));
								}
						}
					}
				}
			}

		for (Article a : articles) 
			System.out.println(a.getIdArticle()+ "-" + a.getDescription()+ "-" + a.getBrand() + "-" + a.getUnitaryPrice());
	}
}
