package ch.aos.shoppingbasket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.aos.shoppingbasket.model.MixedFruit;
import ch.aos.shoppingbasket.service.ShoppingBasketService;

/**
 * Starter class
 * 
 * @author aos
 *
 */
@SpringBootApplication
public class ShoppingBasketApplication implements CommandLineRunner {

	@Autowired
	private ShoppingBasketService shoppingBasketService;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ShoppingBasketApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			if (args.length > 0) {
				String fruitBagName = args[0].toString();
				MixedFruit mixedFruit = shoppingBasketService.composeFruitBagTypeWithName(fruitBagName);
				mixedFruit.displayReceipt(fruitBagName);
			} else {
				System.out.println(shoppingBasketService.getFruitBagTypes());
			}
		} catch (Throwable e) {
			// TODO: handle exception
		}
	}
}
