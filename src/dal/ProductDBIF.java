package dal;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.Product;

/**
Last updated: 17-03-2023

- Documentation and comments added
*/
/**

The ProductDBIF interface defines methods for accessing and manipulating product data in the database.
*/
public interface ProductDBIF {

	/**
	
	Creates a new product with the given properties and adds it to the database.
	@param name the name of the product
	@param purchasePrice the purchase price of the product
	@param salesPrice the sales price of the product
	@param rentPrice the rent price of the product
	@param countryOfOrigin the country of origin of the product
	@param minStock the minimum stock of the product
	@param stock the current stock of the product
	@param contactSupplier the supplier contact for the product
	@param productType the product type of the product
	@param productLocation the location of the product in the store
	@return the created Product object
	*/
	public Product createNewProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
	String countryOfOrigin, int minStock, int stock, int contactSupplier, int productType,
	int productLocation);
	
	/**
	Finds and returns a Product object with the given product number.
	@param productNumber the product number to search for
	@return the found Product object, or null if no product was found
	*/
	public Product findProductByProductNumber(int productNumber);
	
	/**
	Returns a list of all products at the specified location.
	@param locationId the ID of the location to search for products at
	@return a List of Product objects located at the specified location
	*/
	public List<Product> getProductsAtLocation(int locationId);
	
	/**
	Updates the stock of the product with the given product number.
	@param productNumber the product number to update the stock for
	@param stock the new stock value
	@return true if the stock was updated successfully, false otherwise
	*/
	public boolean updateProductStock(int productNumber, int stock);
	
	/**
	Updates the location of the product with the given product number.
	@param productNumber the product number to update the location for
	@param location the new location value
	@return true if the location was updated successfully, false otherwise
	*/
	public boolean updateProductLocation(int productNumber, int location);
	
	/**
	Removes the product with the given product number from the database.
	@param productNumber the product number of the product to remove
	@return true if the product was removed successfully, false otherwise
	*/
	public boolean removeProduct(int productNumber);
}
