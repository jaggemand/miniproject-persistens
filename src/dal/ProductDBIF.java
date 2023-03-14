package dal;

import model.Product;

public interface ProductDBIF {
	public Product findProductByProductNumber(String productNumber);

}
