package dal;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDB implements ProductDBIF {

	private static final String SELECT_PRODUCT_LOCATION = "SELECT * FROM product WHERE product_location = ?";
	private static final String SELECT_PRODUCT_ALL = "SELECT * FROM product";
	private static final String SELECT_PRODUCT_PRODUCTNUMBER = "SELECT * FROM product WHERE product_number = ?";
	private static final String INSERT_PRODUCT = "INSERT INTO product(product_name, purchase_price, sales_price, rent_price, country_of_origin, min_stock, stock_amount, contact_supplier_number_fk, product_type_id_fk, product_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public Product createNewProduct(String name, double purchasePrice, double salesPrice,
			double rentPrice, String countryOfOrigin, int minStock, int productLocation) {
		Connection con = DBConnection.getInstance().getDBcon();
		int identity = -1;
		try (PreparedStatement prepS = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
			//con.setAutoCommit(false);
			prepS.setString(1, name);
			prepS.setDouble(2, purchasePrice);
			prepS.setDouble(3, salesPrice);
			prepS.setDouble(4, rentPrice);
			prepS.setString(5, countryOfOrigin);
			prepS.setInt(6, minStock);
			prepS.setInt(7, productLocation);
			//prepS.setInt(8, stock_amount);
			//prepS.setInt(9, rentPrice);
			//prepS.setInt(10, rentPrice);
			prepS.executeUpdate();
			con.commit();
			ResultSet rs = prepS.getGeneratedKeys();
			if (rs.next()) {
				identity = rs.getInt("id");
			}
			rs.close();
			//prepS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot insert record" + e.getMessage());
		}
		return new Product(identity, name, purchasePrice, salesPrice,
		 rentPrice, countryOfOrigin, minStock, productLocation);
	}

	@Override
	public Product findProductByProductNumber(int productNumber) {
		Connection con = DBConnection.getInstance().getDBcon();
		Product outputProduct = null;
		try (PreparedStatement prepS = con.prepareStatement(SELECT_PRODUCT_PRODUCTNUMBER)) {
			//con.setAutoCommit(false);
			prepS.setInt(1, productNumber);
			prepS.executeUpdate();
			//con.commit();
			ResultSet rs = prepS.executeQuery();
			if (rs != null && rs.next()) {
				outputProduct = buildObject(rs);
			}
			rs.close();
			prepS.close();
		} catch (SQLException e) {
			System.out.println("Cannot insert record" + e.getMessage());
		}
		return outputProduct;
	}

	@Override
	public List<Product> getProductsAtLocation(int locationId) {
		List<Product> productList = null;
		Connection con = DBConnection.getInstance().getDBcon();
		try (PreparedStatement prepS = con.prepareStatement(SELECT_PRODUCT_LOCATION)) {
			//con.setAutoCommit(false);
			prepS.setInt(1, locationId);
			prepS.executeUpdate();
			//con.commit();
			ResultSet rs = prepS.executeQuery();
			if (rs != null && rs.next()) {
				productList = buildListObjects(rs);
			}
		} catch (SQLException e) {
			System.out.println("Some kind of error" + e.getMessage());
		}
		return productList;
	}

	@Override
	public boolean updateProductStock(int productNumber, int stock) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public List<Product> buildListObjects(ResultSet rs) {
		List<Product> res = new ArrayList<>();
		try {
			do {
				Product m = buildObject(rs);
				res.add(m);
			} while (rs.next());
		} catch (SQLException e) {
			System.out.println("Could not iterate ResultSet" + e.getMessage());
		}
		return res;
	}

	public Product buildObject(ResultSet rs) {
		Product product = null;
		int identity;
		try {
			identity = rs.getInt("product_number");
			product = new Product(identity, rs.getString("product_name"), rs.getDouble("purchase_price"),
					rs.getDouble("sales_price"), rs.getDouble("rent_price"), rs.getString("country_of_origin"),
					rs.getInt("min_stock"), rs.getInt("product_location"));
		} catch (SQLException e) {
			System.out.println("Cannot convert from ResultSet" + e.getMessage());
			;
		}
		return product;
	}

}
