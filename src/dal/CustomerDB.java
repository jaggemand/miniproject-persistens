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
	
	private static final String FIND_CUSTOMER_FIELDS = "first_name, last_name, house_number, street, city_id_fk, phone_no, email, city, zipcode, [state], country ";
	private static final String FIND_CUSTOMER_JOIN_CITY = "join city on contact.city_id_fk = city.id ";
	private static final String FIND_CUSTOMER_JOIN_STATE = "join state on city.state_id_fk = state.id ";
	private static final String FIND_CUSTOMER_JOIN_COUNTRY = "join country on state.country_id_fk = country.id ";
	private static final String FIND_CUSTOMER_CUSTOMERNUMBER = "Select " + FIND_CUSTOMER_FIELDS + "from contact " +
																														FIND_CUSTOMER_JOIN_CITY + FIND_CUSTOMER_JOIN_STATE + FIND_CUSTOMER_JOIN_COUNTRY + "where contact_number = ?;";
	
	public CustomerDB() {
		
	}
	
	@Override
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		Customer customer = null;
		//etablish connection
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
	
	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer result = new Customer();
		result.setCustomerNumber(rs.getInt("contact_number"));
		result.setFirstName(rs.getString("first_name"));
		result.setLastName(rs.getString("last_name"));
		result.setEmail(rs.getString("email"));
		result.setAddress(rs.getString("street") +" " + rs.getString("house_number"));
		result.setCity(rs.getString("city"));
		result.setPhoneNumber(rs.getString("phone_no"));
		result.setZipcode(rs.getString("zipcode"));	
		return result;
	}
}
