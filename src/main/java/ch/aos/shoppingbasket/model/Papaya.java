package ch.aos.shoppingbasket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author aos
 *
 */
public class Papaya implements Fruit {
	private final String id;
	private final int number;

	public Papaya(String id, int number) {
		this.id = id;
		this.number = number;
	}

	public String name() {
		return "Papaya";
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(0.50).setScale(2, RoundingMode.CEILING);
	}

	public String getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

}
