package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

/**
 * 
 * @author Nikolai
 * @version 1
 */

public class CustomerDB implements CustomerDBIF {
	
	private static final String FIND_CUSTOMER_FIELDS = "contact_number,first_name, last_name, house_number, street, city_id_fk, phone_no, email, city, zipcode, [state], country ";
	private static final String FIND_CUSTOMER_JOIN_CITY = "join city on contact.city_id_fk = city.id ";
	private static final String FIND_CUSTOMER_JOIN_STATE = "join state on city.state_id_fk = state.id ";
	private static final String FIND_CUSTOMER_JOIN_COUNTRY = "join country on state.country_id_fk = country.id ";
	private static final String FIND_CUSTOMER_CUSTOMERNUMBER = "Select " + FIND_CUSTOMER_FIELDS + "from contact " + FIND_CUSTOMER_JOIN_CITY + FIND_CUSTOMER_JOIN_STATE + FIND_CUSTOMER_JOIN_COUNTRY + "where contact_number = ?;";
	
	public CustomerDB() {
		//This constructor is left blank
	}
	
	/**

	This method finds a customer by their customer number in the database.
	@param customerNumber the unique identifier for the customer to be found
	@return the Customer object if found, null if not found or if an error occurs
	*/
	@Override
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		Customer customer = null;
		// establish database connection
		Connection con = DBConnection.getInstance().getDBcon();
		try (PreparedStatement psFindCustomer = con.prepareStatement(FIND_CUSTOMER_CUSTOMERNUMBER)) {
			//prepare statement
			psFindCustomer.setInt(1, customerNumber);
			//execute statement
			ResultSet rs = psFindCustomer.executeQuery();
			if (rs != null && rs.next()) {
				//build customer from result set
				customer = buildObject(rs);
			}
		} catch (SQLException e) {
		System.out.println("Some kind of error" + e.getMessage());
		}
		return customer;
	}
	
	/**

	Builds a Customer object from a ResultSet.
	@param rs the ResultSet containing the customer data
	@return a Customer object with the data from the ResultSet
	@throws SQLException if there is an error accessing the ResultSet
	*/
	private Customer buildObject(ResultSet rs) throws SQLException {
		// create a new Customer object
		Customer result = new Customer();
		// set the properties of the customer object based on the values in the ResultSet
		result.setCustomerNumber(rs.getInt("contact_number"));
		result.setFirstName(rs.getString("first_name"));
		result.setLastName(rs.getString("last_name"));
		result.setEmail(rs.getString("email"));
		result.setAddress(rs.getString("street") +" " + rs.getString("house_number"));
		result.setCity(rs.getString("city"));
		result.setPhoneNumber(rs.getString("phone_no"));
		result.setZipcode(rs.getString("zipcode"));	
		// return the Customer object
		return result;
	}
}
