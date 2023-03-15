package dal;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.Product;

public interface ProductDBIF {
	public Product createNewProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, int productLocation);
	
	public Product findProductByProductNumber(int productNumber);
	
	public List<Product> getProductsAtLocation(int locationId);
	
	public boolean updateProductStock(int productNumber, int stock);
}
