package org.hemakumar;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.hemakumar.PageObjects.android.CartPage;
import org.hemakumar.PageObjects.android.FormPage;
import org.hemakumar.PageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {

	@Test
	public void FillForm() throws InterruptedException {
		formPage.setNameField("hemakumar chinnaiah");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
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

}
