package org.hemakumar;

import org.hemakumar.baseTest.AndroidBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class eCommerce_tc_2 extends AndroidBaseTest {

	@BeforeMethod
	public void preSet() {

		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.MainActivity");
		// packagename/current focus or activity driver.startActivity(activity);
		// adb shell dumbsys window | grep -E 'mCurrentFocus' -> MAC
		// adb shell dumpsys window | find "mCurrentFocus" -> windows // App package and
		// app activity
	}

	@Test
	public void FillFormErrorValidation() throws InterruptedException {

		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul
		// Shetty");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");

	}

	@Test
	public void FillForm_PositiveFlow() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hemakumar Chinnaiah");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size() < 1);

	}
}
