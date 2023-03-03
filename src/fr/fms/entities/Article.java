package fr.fms.entities;

public class Article {

	public int idArticle;
	public String description;
	public String brand;
	public double unitaryPrice;

	public Article(int idArticle, String description, String brand, double unitaryPrice) {
	
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}
	
}
