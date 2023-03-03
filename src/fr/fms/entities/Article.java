/**
 * Application générant des Articles dans la database t_articles.
 * 
 * @author Le-porcherS - 3-3-2023
 */
package fr.fms.entities;

public class Article {

	public int idArticle;
	public String description;
	public String brand;
	public double unitaryPrice;

	/**
	 * 
	 * @param idArticle
	 * @param description
	 * @param brand
	 * @param unitaryPrice
	 */
	public Article(int idArticle, String description, String brand, double unitaryPrice) {
	
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return
	 */
	public int getIdArticle() {
		return idArticle;
	}
/**
 * 
 * @param idArticle
 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
/**
 * 
 * @return
 */
	public String getDescription() {
		return description;
	}
/**
 * 
 * @param description
 */
	public void setDescription(String description) {
		this.description = description;
	}
/**
 * 
 * @return
 */
	public String getBrand() {
		return brand;
	}
/**
 * 
 * @param brand
 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
/**
 * 
 * @return
 */
	public double getUnitaryPrice() {
		return unitaryPrice;
	}
/**
 * 
 * @param unitaryPrice
 */
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand
				+ ", unitaryPrice=" + unitaryPrice + "]";
	}
	
}