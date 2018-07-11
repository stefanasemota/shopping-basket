package ch.aos.shoppingbasket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author aos
 *
 */
public class Orange implements Fruit {
	private final String id;
	private final int number;

	public Orange(String id, int number) {
		this.id = id;
		this.number = number;
	}

	public String name() {
		return "Orange";
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(0.30).setScale(2, RoundingMode.CEILING);
	}

	public String getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}
}
