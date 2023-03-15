package controller;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import dal.ProductDBIF;
import model.Product;

public class ProductController {
	private ProductDBIF productDataBase;
	private int selectedStockLocation;
	private int selectedProductToUpdate;

	public ProductController(ProductDBIF productDataBase) {
		this.productDataBase = productDataBase;
	}

	public Product findProductByProductNumber(int productNumber) {
		Product outputProduct = null;

		productDataBase.findProductByProductNumber(productNumber);

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

	public ArrayList<Product> selectStockLocation(int locationNumber) {
		List<Product> tempList = new ArrayList<>();

		tempList = productDataBase.getProductsAtLocation(locationNumber);
		ArrayList<Product> outputList = new ArrayList<>(tempList);

		return outputList;
	}

	public void selectProductToUpdate(int productNumber) {

	}

	public boolean setProductStock(int stock) {
		return false;
	}

	public void confirmStockUpdate() {

	}

	public boolean setProductLocation(Product p, String location) {
		return false;
	}
}
