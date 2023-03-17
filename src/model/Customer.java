package model;

/**
Last updated: 17-03-2023

- Documentation and comments added
*/
/**

The Customer class represents a customer entity with its properties and methods.
*/
public class Customer {

	private int customerNumber; // the customer number
	private String firstName; // the first name of the customer
	private String lastName; // the last name of the customer
	private String email; // the email of the customer
	private String address; // the address of the customer
	private String zipcode; // the zip code of the customer
	private String city; // the city of the customer
	private String phoneNumber; // the phone number of the customer
	
	/**
	
	Constructs a new customer with the given information.
	@param customerNumber the customer number
	@param firstName the first name of the customer
	@param lastName the last name of the customer
	@param email the email of the customer
	@param address the address of the customer
	@param zipcode the zip code of the customer
	@param city the city of the customer
	@param phoneNumber the phone number of the customer
	*/
	public Customer(int customerNumber, String firstName, String lastName, String email, String address, String zipcode, String city, String phoneNumber) {
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	/**
	
	Constructs an empty customer object.
	This constructor is used for creating new customer objects with no information.
	*/
	public Customer() {
		// Empty constructor
	}
	/**
	
	Returns the customer number of this customer.
	@return the customer number
	*/
	public int getCustomerNumber(){
		return customerNumber;
	}
	/**
	
	Sets the customer number of this customer.
	@param customerNumber the customer number to set
	*/
	public void setCustomerNumber(int customerNumber){
		this.customerNumber = customerNumber;
	}
	/**
	
	Returns the first name of this customer.
	@return the first name
	*/
	public String getFirstName() {
		return firstName;
	}
	/**
	
	Sets the first name of this customer.
	@param firstName the first name to set
	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	
	Returns the last name of this customer.
	@return the last name
	*/
	public String getLastName() {
		return this.lastName;
	}
	/**
	
	Sets the last name of this customer.
	@param lastName the last name to set
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	
	Returns the email of this customer.
	@return the email
	*/
	public String getEmail() {
		return email;
	}
	/**
	
	Sets the email of this customer.
	@param email the email to set
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	
	Returns the address of this customer.
	@return the address
	*/
	public String getAddress() {
		return address;
	}
	/**
	
	Sets the address of this customer.
	@param address the address to set
	*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
