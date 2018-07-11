package ch.aos.shoppingbasket.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Class has a collection of {@link Fruit}. Maximum number of mixed fruits is 5.
 * 
 * @author aos
 *
 */
public class MixedFruit {

	private Set<Fruit> fruits;
	private byte fruitLimit = 5;
	private byte fruitCounter = 0;

	private BigDecimal price = null;

	public MixedFruit() {
		fruits = new HashSet<Fruit>(5);
	}

	/**
	 * Add Fruit to create a Mixed Fruit
	 * 
	 * @param fruit
	 *            Add Fruit to create Mixed Fruit
	 * @return MixedFruit Returns the mixed fruit
	 * @throws Throwable
	 *             Exception
	 */
	public MixedFruit addFruit(Fruit fruit) throws Throwable {
		fruitCounter++;
		if (fruit == null) {
			throw new Exception("Invalid Fruit : Null Fruit!");
		}
		if (fruitCounter > fruitLimit) {
			throw new Exception("Fruit limit reached");
		}
		fruits.add(fruit);
		if (price == null) {
			price = fruit.getPrice().multiply(new BigDecimal(fruit.getNumber()));
		} else {
			if (fruit instanceof Papaya) {
				if (isThreeForTwo(fruit)) {
					price = price.add(fruit.getPrice()).add(fruit.getPrice());
				}
			} else {
				price = price.add(fruit.getPrice());
			}
		}
		return this;
	}

	private boolean isThreeForTwo(Fruit fruit) {
		long count = fruit.getNumber();
		int k = (int) (count % 3);
		if (k == 0) {
			return true;
		}
		return false;
	}

	public Collection<Fruit> collection() {
		return (Collection<Fruit>) fruits;
	}

	/**
	 * Display contents of {@link MixedFruit} collections
	 * 
	 * @param fruitBagName
	 * 
	 */
	public void displayReceipt(String fruitBagName) {
		StringBuilder sb = new StringBuilder();

		for (Fruit f : fruits) {
			sb.append("#       " + f.name()).append(" Quantity (" + f.getNumber() + ") ").append("        : " + f.getPrice())
					.append("        #\n");
		}
		
		System.out.println("###################################################");
		System.out.println("#    **** AoS Fruit Market Billing SYSTEM ****    #");
		System.out.println("#                                                 #");
		System.out.println("#                 R E C E I P T                   #");
		System.out.println("#                                                 #");
		System.out.println("#     FruitBag - " + fruitBagName + "                 #");
		System.out.println("#                                                 #");
		System.out.println("#     Items:                                      #");
		System.out.println(sb.toString());
		System.out.println("#     Total Price                   : " + price + "        #");
		System.out.println("###################################################");
	}

	public BigDecimal getPrice() {
		return price;
	}
}
