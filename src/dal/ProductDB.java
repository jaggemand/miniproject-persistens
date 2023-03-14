package dal;

import java.util.ArrayList;

import model.Product;

public class ProductDB implements ProductDBIF{

	public ProductDB() {
		
	}
	
	@Override
	public Product findProductByProductNumber(int productNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> getProductsAtLocation(int locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProductStock(int productNumber, int stock) {
		// TODO Auto-generated method stub
		return false;
	}

}
