package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import model.Customer;
import model.Order;
import model.OrderLine;

public class OrderDB implements OrderDBIF{

	private static final String INSERT_ORDER = "INSERT INTO sales_order(contact_customer_number_fk,date,order_status_id_fk,delivery_date,total_cost,payment_date) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String INSERT_ORDERLINE = "INSERT INTO order_line(product_number_fk,sales_order_number_fk,product_quantity) VALUES (?, ?, ?)";
	
	CustomerDB cdb;
	
	public OrderDB() {
		cdb = new CustomerDB();
	}
	
	@Override
	public Order addNewOrder(Order o) {
				// Get a database connection
				Connection con = DBConnection.getInstance().getDBcon();
				int identity = -1;
				try (PreparedStatement prepS = con.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
					
					if(o.getCustomer() == null) {
						throw new NullPointerException();
					}

					// Set parameters for the prepared statement
					prepS.setInt(1, o.getCustomer().getCustomerNumber());
					prepS.setDate(2, convertToSqlDate(o.getCreationDate()));
					prepS.setInt(3, o.getOrderStatus());
					prepS.setDate(4, convertToSqlDate(o.getDeliveryDate()));
					prepS.setDouble(5, o.getTotalCost());
					prepS.setDate(6, convertToSqlDate(o.getPaymentDate()));

					// Execute the prepared statement
					prepS.executeUpdate();

					// Get the generated keys
					ResultSet rs = prepS.getGeneratedKeys();
					if (rs.next()) {
						// Set the identity to the generated ID
						o.setOrderNumber(rs.getInt(1));
						for(OrderLine e : o.getOrderLineList()) {
							addNewOrderLine(o.getOrderNumber(), e);
						}
					}
					rs.close();
					prepS.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Cannot insert record" + e.getMessage());
				}
			return o;
	}
	
	private boolean addNewOrderLine(int orderID, OrderLine ol) {
		boolean success = false;
				// Get a database connection
				Connection con = DBConnection.getInstance().getDBcon();
				try (PreparedStatement prepS = con.prepareStatement(INSERT_ORDERLINE)) {
					
					if(ol == null) {
						throw new NullPointerException();
					}

					// Set parameters for the prepared statement
					prepS.setInt(1, ol.getProduct().getProductNumber());
					prepS.setInt(2, orderID);
					prepS.setInt(3, ol.getQuantity());

					// Execute the prepared statement
					prepS.executeUpdate();
					
					prepS.close();
					success = true;
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Cannot insert record" + e.getMessage());
				}
			return success;
	}

	private Date convertToSqlDate(Calendar cal) {
        long timeInMillis = cal.getTimeInMillis();
        return new Date(timeInMillis);
    }
}
