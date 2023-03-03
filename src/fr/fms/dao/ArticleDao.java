/**
 * Programme qui lie la classe Article à l'interface Dao préalablement implémentée (encore en phase de tests...)
 * Elle lie la classe Article à t_articles.
 * 
 * @author Le-porcherS 3-3-2023
 */
package fr.fms.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.fms.bdd.Dao;
import fr.fms.entities.Article;

public class ArticleDao implements Dao {

	private String url;
	private String userName;
	private String password;
	/**
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 */
	public ArticleDao(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
	/**
	 * 
	 * @param article
	 */
	public void SaveArticle (Article article) {
		try {
			Connection connection = DriverManager.getConnection(url,userName,password);
			
			if (article.getIdArticle()!=0) {
				Statement create = connection.createStatement(); 
				//création d'articles dans la DB
				create.executeQuery("Update t_articles set description= "+article.getDescription()+"brand= "+article.getBrand()+"unitary price= "+article.getUnitaryPrice());
				// mise à jour de la DB
				PreparedStatement statement = connection.prepareStatement("update t_articles set description = ? where idArticle = ?");
				statement.setString(1, article.getDescription());
				statement.setString(2, article.getBrand());
				statement.setDouble(3, article.getUnitaryPrice());
				statement.execute(); // renvoie l'article crée dans la DB
			} else {
				PreparedStatement statement = connection.prepareStatement("insert into t_articles (description, brand, unitaryPrice) values (?)");
				statement.setString(1, article.getDescription());
				statement.execute(); // Cas où l'article n'existe pas = ajoute l'article à la DB.
			}
		
			System.out.println(article.getDescription()+"a été enregistré dans la table des articles.");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("L'article n'a pas pu être ajouté. Veuillez lire le manuel afin de trouver l'erreur (ligne 69)");
		}
		
	}
	/**
	 * 
	 * @param idArticle
	 * @return
	 */
	public Article getArticle(int idArticle) {
		
		try {
			Connection connect = DriverManager.getConnection(url, userName, password);
			PreparedStatement statement = connect.prepareStatement("select * from t_articles where id = ?");
			statement.setInt(1, idArticle);
			ResultSet resultSet = statement.executeQuery();
			
			Article article = new Article();
			
			while (resultSet.next()) {
				article.setIdArticle(resultSet.getInt(idArticle));
				article.setDescription(resultSet.getString("Description")); // récupération des attributs de la table t_articles.
				article.setBrand(resultSet.getString("Brand"));
				article.setUnitaryPrice(resultSet.getDouble("UnitaryPrice"));	
			}
			return article;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	}
	

