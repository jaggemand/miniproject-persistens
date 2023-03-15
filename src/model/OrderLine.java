package model;

/**
	Last updated: 15-03-2023
	
	- getTotalPrice() added
	- Documentation and comments added
*/

public class OrderLine {
	// The product for this order line
	private Product product;

	// The quantity of the product for this order line
	private int quantity;
	
	/**
	 * Constructor for an OrderLine object
	 * @param product the product for this order line
	 * @param quantity the quantity of the product for this order line
	 */
	public OrderLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * Get the product for this order line
	 * @return the product for this order line
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Set the product for this order line
	 * @param product the product for this order line
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Get the quantity of the product for this order line
	 * @return the quantity of the product for this order line
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the quantity of the product for this order line
	 * @param quantity the quantity of the product for this order line
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Calculate the total price of this order line
	 * @return the total price of this order line
	 */
	public double getTotalPrice(){
		return product.getSalesPrice() * quantity;
	}
	
	

}
