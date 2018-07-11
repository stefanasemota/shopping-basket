package ch.aos.shoppingbasket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author aos
 *
 */
public class Banana implements Fruit {

	private final String id;
	private final int number;

	public Banana(String id, int number) {
		this.id = id;
		this.number = number;
	}

	public String name() {
		return "Banana";
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(0.15).setScale(2, RoundingMode.CEILING);
	}

	public String getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

}
