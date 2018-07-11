package ch.aos.shoppingbasket;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.aos.shoppingbasket.model.MixedFruit;
import ch.aos.shoppingbasket.service.ShoppingBasketService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingBasketApplicationTests {

	@Autowired
	ShoppingBasketService sBs;

	@Test(expected = Exception.class)
	public void test_fruitbag_with_wrong_name() throws Throwable {
		sBs.composeFruitBagTypeWithName("ahhahahaha");
	}

	@Test
	public void test_fruitbag_ironman() throws Throwable {
		MixedFruit mf = sBs.composeFruitBagTypeWithName("IronMan");
		Assert.assertNotNull(mf);
		assertTrue(mf.collection().size() == 3);
		BigDecimal bd = new BigDecimal(0.95).setScale(2, RoundingMode.CEILING);
		assertTrue(bd.equals(mf.getPrice()));
	}

	@Test
	public void test_fruitbag_HealthyAndStrong() throws Throwable {
		MixedFruit mf = sBs.composeFruitBagTypeWithName("HealthyAndStrong");
		Assert.assertNotNull(mf);
		assertTrue(mf.collection().size() == 2);
		BigDecimal bd = new BigDecimal(1.30).setScale(2, RoundingMode.DOWN);
		assertTrue(bd.equals(mf.getPrice()));
	}

	@Test
	public void test_fruitbag_display() throws Throwable {
		MixedFruit mf = sBs.composeFruitBagTypeWithName("HealthyAndStrong");
		Assert.assertNotNull(mf);
		mf.displayReceipt("HealthyAndStrong");
	}
}
