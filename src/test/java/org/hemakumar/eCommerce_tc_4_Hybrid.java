package org.hemakumar;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.hemakumar.PageObjects.android.CartPage;
import org.hemakumar.PageObjects.android.ProductCatalogue;
import org.hemakumar.baseTest.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {

	@BeforeMethod
	public void preSet() throws InterruptedException {
		formPage.setActivity();
		// packagename/current focus or activity driver.startActivity(activity);
		// adb shell dumbsys window | grep -E 'mCurrentFocus' -> MAC
		// adb shell dumpsys window | find "mCurrentFocus" -> windows // App package and
		// app activity
	}

	@Test(dataProvider = "getData")
	public void FillForm(HashMap<String, String> input) throws InterruptedException {
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		ProductCatalogue productCatalogue = formPage.submitForm();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();

		Thread.sleep(2000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.attributeContains(
		// driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
		// "text", "Cart"));
		double totalSum = cartPage.getProductSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsAndConditions();
		cartPage.submitOrder();
		//

		// Hybrid - Google page->

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "//src//test//java//org//hemakumar//testData//testdata.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

		// Paramaterization using from the external Json file using data provider
		// For that two dependencies required, 1. Commons-io and jackson databind
		// Parse json file --> string(commons-io)
		// Json string ---> hashmap (jackson databind)
		// Hashmap to test case (TestNG data provider)
	}

}
