package controller;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import dal.ProductDBIF;
import model.Product;

/**

The ProductController class is responsible for managing and updating product information.
*/
/**

Creates an instance of the ProductController class with the given product database.
@param productDataBase the product database to use for storing and retrieving product information.
*/
public class ProductController {
	private ProductDBIF productDataBase;

	public ProductController(ProductDBIF productDataBase) {
		this.productDataBase = productDataBase;
	}

	/**
	Retrieves the product with the specified product number from the database.
	@param productNumber the product number of the product to retrieve.
	@return the product with the specified product number, or null if no such product exists.
	*/
	public Product findProductByProductNumber(int productNumber) {
		Product outputProduct = null;

		outputProduct = productDataBase.findProductByProductNumber(productNumber);

		return outputProduct;
	}

	/**
	Updates the stock amount of the product with the specified product number in the database.
	@param productNumber the product number of the product to update.
	@param stockAmount the new stock amount of the product.
	@return true if the product stock was successfully updated, false otherwise.
	*/
	public boolean updateProductStock(int productNumber, int stockAmount) {
		boolean success = false;
		Product productToUpdate = null;
		int tempStock;
		int value = 0;
		productToUpdate = findProductByProductNumber(productNumber);
		if (productToUpdate != null) {
			tempStock = productToUpdate.getStockAmount();
			value = (stockAmount > 0) ? tempStock + stockAmount : tempStock - Math.abs(stockAmount); // Checks if we
																										// want to
																										// subtract or
																										// add to the
																										// stock, then
																										// does the
																										// correct
																										// operation
			success = productDataBase.updateProductStock(productNumber, value);
		}

		return success;
	}
	
	/**
	Updates the location of the product with the specified product number in the database.
	@param productNumber the product number of the product to update.
	@param location the new location of the product.
	@return true if the product location was successfully updated, false otherwise.
	*/
	public boolean updateProductLocation(int productNumber, int location) {
		boolean success = false;
		
		success = productDataBase.updateProductLocation(productNumber, location);
		
		return success;
	}

	/**
	Retrieves a list of products stored at the specified location in the database.
	@param locationNumber the location number of the products to retrieve.
	@return a list of products stored at the specified location in the database.
	*/
	public ArrayList<Product> selectStockLocation(int locationNumber) {
		List<Product> tempList = new ArrayList<>();

		tempList = productDataBase.getProductsAtLocation(locationNumber);
		ArrayList<Product> outputList = new ArrayList<>(tempList);

		return outputList;
	}

	/**
	Creates a new product with the given parameters and adds it to the product database.
	@param name the name of the product
	@param purchasePrice the purchase price of the product
	@param salesPrice the sales price of the product
	@param rentPrice the rent price of the product
	@param countryOfOrigin the country of origin of the product
	@param minStock the minimum stock of the product
	@param stock the current stock of the product
	@param contactSupplier an integer indicating whether or not to contact the supplier for more of the product
	@param productType the type of the product
	@param productLocation the location of the product in the stock
	@return the newly created product
	*/
	public Product createNewProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, int stock, int contactSupplier, int productType,
			int productLocation) {
		Product product = null;

		product = productDataBase.createNewProduct(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin,
				minStock, stock, contactSupplier, productType, productLocation);

		return product;
	}

	/**
	Removes a product with the specified product number from the database.
	@param productNumber the product number of the product to be removed
	@return true if the product was successfully removed, false otherwise
	*/
	public boolean removeProduct(int productNumber) {
		boolean success = false;

		success = productDataBase.removeProduct(productNumber);

		return success;
	}
}
