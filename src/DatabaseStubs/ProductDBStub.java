package DatabaseStubs;

import java.util.ArrayList;
import java.util.List;

import dal.ProductDBIF;
import model.Product;

public class ProductDBStub implements ProductDBIF{

	@Override
	public Product createNewProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, int productLocation, int stock) {
		return new Product(stock, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productLocation, stock);
	}

	@Override
	public Product findProductByProductNumber(int productNumber) {
		return new Product(1337, "testProduct", 1337, 1337, 1347, "mongoliet", 69, 0, 69420);
	}

	@Override
	public List<Product> getProductsAtLocation(int locationId) {
		List<Product> pl = new ArrayList<Product>(); 
		pl.add(new Product(1337, "testProduct1", 1337, 1337, 1347, "mongoliet", 69, 0, 69420));
		pl.add(new Product(1336, "testProduct2", 1337, 1337, 1347, "mongoliet", 69, 0, 69420));
		pl.add(new Product(1335, "testProduct3", 1337, 1337, 1347, "mongoliet", 69, 0, 69420));
		pl.add(new Product(1334, "testProduct4", 1337, 1337, 1347, "mongoliet", 69, 0, 69420));
		pl.add(new Product(1333, "testProduct5", 1337, 1337, 1347, "mongoliet", 69, 0, 69420));
		pl.add(new Product(1332, "testProduct6", 1337, 1337, 1347, "mongoliet", 69, 0, 69420));
		return null;
	}

	@Override
	public boolean updateProductStock(int productNumber, int stock) {
		return true;
	}
	
	
}
