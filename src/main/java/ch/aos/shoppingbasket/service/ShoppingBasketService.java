package ch.aos.shoppingbasket.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

import ch.aos.shoppingbasket.model.Apple;
import ch.aos.shoppingbasket.model.Banana;
import ch.aos.shoppingbasket.model.MixedFruit;
import ch.aos.shoppingbasket.model.Orange;
import ch.aos.shoppingbasket.model.Papaya;

@Component
public class ShoppingBasketService {

	public MixedFruit composeFruitBagTypeWithName(String fruitBagName) throws Throwable {
		MixedFruit mixedFruit = null;
		switch (fruitBagName) {
		case "IronMan":
			mixedFruit = createIronManFruitBag();
			break;

		case "HealthyAndStrong":
			mixedFruit = createHealthyAndStrongFruitBag();
			break;

		default:
			throw new Exception("Unkown Fruitbag name supplied!!");
		}
		return mixedFruit;
	}

	/**
	 * FruitBag contains:
	 * <p>
	 * 2 apples
	 * <p>
	 * 1 orange
	 * <p>
	 * 1 banana
	 * 
	 * @return {@link MixedFruit}
	 * @throws Throwable
	 */
	private MixedFruit createIronManFruitBag() throws Throwable {
		String id = UUID.randomUUID().toString();
		return new MixedFruit().addFruit(new Apple(id, 2)).addFruit(new Orange(id, 1)).addFruit(new Banana(id, 1));
	}

	/**
	 * FruitBag contains:
	 * <p>
	 * 2 banana
	 * <p>
	 * 3 Papayas
	 * 
	 * @return {@link MixedFruit}
	 * @throws Throwable
	 */
	private MixedFruit createHealthyAndStrongFruitBag() throws Throwable {
		String id = UUID.randomUUID().toString();
		Papaya papaya = new Papaya(id, 3);
		Banana banana = new Banana(id, 2);
		return new MixedFruit().addFruit(banana).addFruit(papaya);
	}

	public String getFruitBagTypes() {
		StringBuilder sb = new StringBuilder();
		sb.append("Please supply the name of one of the listed Fitness Fruit Bags below:\n");
		sb.append("1). IronMan\n");
		sb.append("2). HealthyAndStrong\n");
		return sb.toString();
	}
}
