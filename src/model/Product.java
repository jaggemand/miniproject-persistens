package model;

public class Product {
	
	private String countryOfOrigin;
	private String name;
	private int productNumber;
	private int minStock;
	private double productSalesPrice;
	private double rentPrice;
	
	public Product(String countryOfOrigin, String name, int productNumber, int minStock, double productSalesPrice,
			double rentPrice) {
		this.countryOfOrigin = countryOfOrigin;
		this.name = name;
		this.productNumber = productNumber;
		this.minStock = minStock;
		this.productSalesPrice = productSalesPrice;
		this.rentPrice = rentPrice;
	}

	/**
	 * @return the countryOfOrigin
	 */
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	/**
	 * @param countryOfOrigin the countryOfOrigin to set
	 */
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the productNumber
	 */
	public int getProductNumber() {
		return productNumber;
	}

	/**
	 * @param productNumber the productNumber to set
	 */
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	/**
	 * @return the minStock
	 */
	public int getMinStock() {
		return minStock;
	}

	/**
	 * @param minStock the minStock to set
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	/**
	 * @return the productSalesPrice
	 */
	public double getProductSalesPrice() {
		return productSalesPrice;
	}

	/**
	 * @param productSalesPrice the productSalesPrice to set
	 */
	public void setProductSalesPrice(double productSalesPrice) {
		this.productSalesPrice = productSalesPrice;
	}

	/**
	 * @return the rentPrice
	 */
	public double getRentPrice() {
		return rentPrice;
	}

	/**
	 * @param rentPrice the rentPrice to set
	 */
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	

}
