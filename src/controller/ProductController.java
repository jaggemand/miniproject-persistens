package controller;

import java.util.ArrayList;

import dal.ProductDBIF;
import model.Product;

public class ProductController {
	private ProductDBIF productDataBase;
	private int selectedStockLocation;
	private int selectedProductToUpdate;
	
	public ProductController(ProductDBIF productDataBase) {
		
	}
	public Product findProductByProductNumber(int productNumber) {
		return null;
	}
	
	public void updateProductStock() {
		
	}
	
	public ArrayList<Product> selectStockLocation(int locationId){
		return null;
	}
	
	public void selectProductToUpdate(int productId) {
		
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
