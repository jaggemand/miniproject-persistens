package dal;

import java.util.ArrayList;

import model.Product;

public interface ProductDBIF {
	public Product findProductByProductNumber(int productNumber);
	
	public ArrayList<Product> getProductsAtLocation(int locationId);
	
	public boolean updateProductStock(int productNumber, int stock);
}
