package org.hemakumar.utils;

import java.util.HashMap;
import java.util.Map;

import org.hemakumar.PageObjects.iOS.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class iOSActions extends AppiumUtils {

	IOSDriver driver;

	public iOSActions(IOSDriver driver) {
		this.driver = driver;
	}

	public void IOSLongPressAction(WebElement ele) {

		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		Map<String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement) ele).getId());
		params.put("duration", 5);
		driver.executeScript("mobile:touchAndHold", params);

	}

	public void iOSScroll(WebElement ele) {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		params.put("element", ((RemoteWebElement) ele).getId());
		driver.executeScript("mobile:scroll", params);
	}

	public void iOSSwipeLeft(WebElement ele) {

		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("direction", "left");
		// params1.put("element", ((RemoteWebElement)ele).getId());
		driver.executeScript("mobile:swipe", params1);
	}
}
