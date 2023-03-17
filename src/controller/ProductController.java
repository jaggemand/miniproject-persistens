package controller;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import dal.ProductDBIF;
import model.Product;

public class ProductController {
	private ProductDBIF productDataBase;

	public ProductController(ProductDBIF productDataBase) {
		this.productDataBase = productDataBase;
	}

	public Product findProductByProductNumber(int productNumber) {
		Product outputProduct = null;

		outputProduct = productDataBase.findProductByProductNumber(productNumber);

		return outputProduct;
	}

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
	
	public boolean updateProductLocation(int productNumber, int location) {
		boolean success = false;
		
		success = productDataBase.updateProductLocation(productNumber, location);
		
		return success;
	}

	public ArrayList<Product> selectStockLocation(int location) {
		List<Product> tempList = new ArrayList<>();

		tempList = productDataBase.getProductsAtLocation(location);
		ArrayList<Product> outputList = new ArrayList<>(tempList);

		return outputList;
	}

	public Product createNewProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, int stock, int contactSupplier, int productType,
			int productLocation) {
		Product product = null;

		product = productDataBase.createNewProduct(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin,
				minStock, stock, contactSupplier, productType, productLocation);

		return product;
	}

	public boolean removeProduct(int productNumber) {
		boolean success = false;

		success = productDataBase.removeProduct(productNumber);

		return success;
	}
}
