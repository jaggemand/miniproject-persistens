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
	private static final String UPDATE_PRODUCT_STOCK = "UPDATE product SET stock_amount = ? WHERE product_number = ?";
	private static final String SELECT_PRODUCT_PRODUCTNUMBER = "SELECT * FROM product WHERE product_number = ?";
	private static final String INSERT_PRODUCT = "INSERT INTO product(product_name, purchase_price, sales_price, rent_price, country_of_origin, min_stock, stock_amount, contact_supplier_number_fk, product_type_id_fk, product_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_PRODUCT = "DELETE FROM product WHERE product_number = ?";
	
	/**
	 * Creates a new Product object in the database and returns it.
	 * 
	 * @param name            the name of the new product
	 * @param purchasePrice   the purchase price of the new product
	 * @param salesPrice      the sales price of the new product
	 * @param rentPrice       the rent price of the new product
	 * @param countryOfOrigin the country of origin of the new product
	 * @param minStock        the minimum stock of the new product
	 * @param productLocation the location of the new product
	 * @param stock           the stock amount of the new product
	 * @return a new Product object
	 */
	@Override
	public Product createNewProduct(String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int minStock, int stock, int contactSupplier, int productType,
			int productLocation) {
		// Get a database connection
		Connection con = DBConnection.getInstance().getDBcon();
		int identity = -1;
		try (PreparedStatement prepS = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {

			// Set parameters for the prepared statement
			prepS.setString(1, name);
			prepS.setDouble(2, purchasePrice);
			prepS.setDouble(3, salesPrice);
			prepS.setDouble(4, rentPrice);
			prepS.setString(5, countryOfOrigin);
			prepS.setInt(6, minStock);
			prepS.setInt(7, stock);
			prepS.setInt(8, contactSupplier);
			prepS.setInt(9, productType);
			prepS.setInt(10, productLocation);

			// Execute the prepared statement
			prepS.executeUpdate();

			// Get the generated keys
			ResultSet rs = prepS.getGeneratedKeys();
			if (rs.next()) {
				// Set the identity to the generated ID
				identity = rs.getInt(1);
			}
			rs.close();
			prepS.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot insert record " + e.getMessage());
		}

		// Return a new Product object with the generated ID
		return new Product(identity, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock,
				productLocation, stock); // Needs more parameters to create the product??
	}

	/**
	 * Finds a product in the database by its product number and returns it.
	 * 
	 * @param productNumber the product number to search for
	 * @return the matching Product object, or null if not found
	 */
	@Override
	public Product findProductByProductNumber(int productNumber) {
		// Get a database connection
		Connection con = DBConnection.getInstance().getDBcon();
		// Initialize the outputProduct variable
		Product outputProduct = null;
		try (PreparedStatement prepS = con.prepareStatement(SELECT_PRODUCT_PRODUCTNUMBER)) {
			// Set the product number parameter for the prepared statement
			prepS.setInt(1, productNumber);

			// Execute the prepared statement
			// prepS.executeUpdate();
			// Get the result set from the executed query
			ResultSet rs = prepS.executeQuery();
			if (rs != null && rs.next()) {
				// If the result set is not null and contains a row, build a Product object from
				// the row
				outputProduct = buildObject(rs);
			}
			rs.close();
			prepS.close();
		} catch (SQLException e) {
			// If an SQLException is thrown, print an error message
			System.out.println("Cannot insert record " + e.getMessage());
		}
		// Return the outputProduct variable (which will be null if no matching product
		// was found)
		return outputProduct;
	}

	/**
	 * Retrieves a list of all products stored at a specific location in the
	 * database.
	 *
	 * @param locationId the ID of the location to retrieve products from
	 * @return a List of Product objects stored at the specified location, or null
	 *         if none were found
	 */
	@Override
	public List<Product> getProductsAtLocation(int locationId) {
		// Initialize the productList variable to null
		List<Product> productList = null;
		// Get a database connection
		Connection con = DBConnection.getInstance().getDBcon();
		try (PreparedStatement prepS = con.prepareStatement(SELECT_PRODUCT_LOCATION)) {
			// Set the location ID parameter for the prepared statement
			prepS.setInt(1, locationId);
			// Execute the prepared statement
			// prepS.executeUpdate();
			// Get the result set from the executed query
			ResultSet rs = prepS.executeQuery();
			if (rs != null && rs.next()) {
				// If the result set is not null and contains a row, build a List of Product
				// objects from the rows
				productList = buildListObjects(rs);
			}
			rs.close();
			prepS.close();
		} catch (SQLException e) {
			// If an SQLException is thrown, print an error message
			System.out.println("Some kind of error " + e.getMessage());
		}
		// Return the productList variable (which will be null if no products were found
		// at the specified location)
		return productList;
	}

	/**
	 * Updates the stock of a product in the database.
	 *
	 * @param productNumber the product number of the product to update
	 * @param stock         the new stock value for the product
	 * @return true if the update was successful, false otherwise
	 */
	@Override
	public boolean updateProductStock(int productNumber, int stock) {
		// Initialize the success variable to false
		boolean success = false;
		// Get a database connection
		Connection con = DBConnection.getInstance().getDBcon();
		try (PreparedStatement prepS = con.prepareStatement(UPDATE_PRODUCT_STOCK)) {
			// Set the stock and product number parameters for the prepared statement
			prepS.setInt(1, stock);
			prepS.setInt(2, productNumber);
			// Execute the prepared statement and check if it was successful
			success = (prepS.executeUpdate() == 1) ? true : false;
			prepS.close();
		} catch (SQLException e) {
			// If an SQLException is thrown, print an error message
			System.out.println("Some kind of error" + e.getMessage());
		}
		// Return the success variable (which will be true if the update was successful,
		// false otherwise)
		return success;
	}
	
	@Override
	public boolean removeProduct(int productNumber) {
		// Get a database connection
		Connection con = DBConnection.getInstance().getDBcon();
		int rowAffected = -1;
		boolean success = false;
		try (PreparedStatement prepS = con.prepareStatement(DELETE_PRODUCT)) {
			// Set the product number parameter for the prepared statement
			prepS.setInt(1, productNumber);

			// Execute the prepared statement
			rowAffected = prepS.executeUpdate();
			prepS.close();
			if (rowAffected == 1) {
				success = true;
			}
		} catch (SQLException e) {
			// If an SQLException is thrown, print an error message
			System.out.println("Cannot insert record " + e.getMessage());
		}
		// Return the outputProduct variable (which will be null if no matching product
		// was found)
		return success;
	}

	// TODO add updateProductLocation

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

	/**
	 * 
	 * Builds a Product object from a ResultSet object.
	 * 
	 * @param rs the ResultSet object to extract data from
	 * @return the Product object created from the ResultSet data, or null if the
	 *         ResultSet is empty
	 */
	public Product buildObject(ResultSet rs) {
		Product product = null;
		int identity;
		try {
			identity = rs.getInt("product_number");
			product = new Product(identity, rs.getString("product_name"), rs.getDouble("purchase_price"),
					rs.getDouble("sales_price"), rs.getDouble("rent_price"), rs.getString("country_of_origin"),
					rs.getInt("min_stock"), rs.getInt("product_location"), rs.getInt("stock_amount"));
		} catch (SQLException e) {
			System.out.println("Cannot convert from ResultSet" + e.getMessage());
		}
		return product;
	}

}
