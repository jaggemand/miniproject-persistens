package model;
/**
Last updated: 17-03-2023

- Documentation and comments added and updated
*/

/**
The Product class represents a product object that is available for purchase, sale, or rent in a store.
*/
public class Product {
	
	private int productNumber; 		//The product number of the product.
	private String name; 			//The name of the product.
	private double purchasePrice; 	//The purchase price of the product.
	private double salesPrice; 		//The sale price of the product.
	private double rentPrice; 		//The rent price of the product.
	private String countryOfOrigin; //The country of origin of the product.
	private int minStock; 			//The minimum stock level of the product that should be kept in store.
	private int productLocation; 	//The location of the product in the store.
	private int stock; 				//The current stock level of the product in the store.
	
	/**
	Constructs a product with the specified product number, name, purchase price, sale price, rent price,
	country of origin, minimum stock level, product location, and stock level.
	@param productNumber the product number of the product
	@param name the name of the product
	@param purchasePrice the purchase price of the product
	@param salesPrice the sale price of the product
	@param rentPrice the rent price of the product
	@param countryOfOrigin the country of origin of the product
	@param minStock the minimum stock level of the product that should be kept in store
	@param productLocation the location of the product in the store
	@param stock the current stock level of the product in the store
	*/
	public Product(int productNumber, String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, int productLocation, int stock) {
		this.productNumber = productNumber;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.productLocation = productLocation;
		this.stock = stock;
	}

	/**
	Returns the product number of the product.
	@return the product number of the product
	*/
	public int getProductNumber() {
		return productNumber;
	}
	
	/**
	Sets the product number of the product.
	@param productNumber the product number of the product to set
	*/
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	
	/**
	Returns the name of the product.
	@return the name of the product
	*/
	public String getName() {
		return name;
	}
	
	/**
	Sets the name of the product.
	@param name the name of the product to set
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**

	Returns the purchase price of the product.
	@return the purchase price of the product
	*/
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	Sets the purchase price of the product.
	@param purchasePrice the purchase price of the product to set
	*/
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	Returns the sales price of the product.
	@return the sales price of the product
	*/
	public double getSalesPrice() {
		return salesPrice;
	}

	/**
	Sets the sales price of the product.
	@param salesPrice the new sales price of the product
	*/
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	Returns the rental price of the product.
	@return the rental price of the product
	*/
	public double getRentPrice() {
		return rentPrice;
	}

	/**
	Sets the rent price of the product.
	@param rentPrice the new rent price of the product.
	*/
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	/**
	Returns the country of origin of the product.
	@return the country of origin of the product as a String
	*/
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	/**
	Sets the country of origin of the product.
	@param countryOfOrigin the country of origin of the product to be set
	*/
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	/**
	Returns the minimum stock required for the product.
	@return the minimum stock required for the product
	*/
	public int getMinStock() {
		return minStock;
	}

	/**
	Sets the minimum stock quantity for this product.
	@param minStock the minimum stock quantity to set for this product
	*/
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	/**
	Returns the current stock amount of this product.
	@return the stock amount of this product
	*/
	public int getStockAmount() {
		return stock;
	}
	
	/**
	Returns the location of the product.
	@return the location of the product as an integer.
	*/
	public int getProductLocation() {
		return productLocation;
	}
}
