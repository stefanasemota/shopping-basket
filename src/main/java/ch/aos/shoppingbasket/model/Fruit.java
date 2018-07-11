package ch.aos.shoppingbasket.model;

import java.math.BigDecimal;

/**
 * Contract for a simple fruit.
 * 
 * @author aos
 *
 */
public interface Fruit {

	/**
	 * Returns Fruit Name
	 * 
	 * @return String
	 */
	public String name();

	/**
	 * Returns the Price
	 * 
	 * @return BigDecimal
	 */
	public BigDecimal getPrice();

	public int getNumber();
}
