/**
 * Programme qui teste l'interface DAO contenant les requêtes SQL (update, delete, select, insert).
 * 
 * @author Le-porcherS 3-3-2023
 */
package fr.fms.bdd;

import fr.fms.dao.ArticleDao;
import fr.fms.entities.Article;

public class TestDao {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		
		String url = "jdbc:mariadb://localhost:3306/Shop";
		String user = "root";
		String password = "fms2023";
		Article article = new Article();
		article.setDescription("Developpeur");
		article.setBrand("Stagiaire FMS");
		article.setUnitaryPrice(1645.58); // Je ne ferai aucun commentaire sur cette valeur !

		ArticleDao articleDao = new ArticleDao(url, user, password);
	//	articleDao.getArticle(1);
		articleDao.SaveArticle(article);
	}

}
