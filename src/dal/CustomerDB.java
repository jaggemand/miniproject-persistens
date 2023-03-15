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
	private PreparedStatement psFindCustomer = null;
	
	public CustomerDB() {
		
	}
	
	@Override
	public Customer findCustomerByCustomerNumber(int customerNumber) throws SQLException {
		Customer customer = null;
		//etablish connection
		Connection con = DBConnection.getInstance().getDBcon();
		//prepare statement
		psFindCustomer = con.prepareStatement(FIND_CUSTOMER_CUSTOMERNUMBER);
		psFindCustomer.setString(1, customerNumber);
		//execute statement
		psFindCustomer.execute
		
		return null;
	}
	
	private Customer buildObject(ResultSet rs) {
		
		return null;
	}
}
