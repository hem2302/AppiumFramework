package org.hemakumar;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.hemakumar.PageObjects.android.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	FormPage formPage;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("HemakumarPhone"); // emulator
		// options.setDeviceName("Android Device");// real device

		options.setChromedriverExecutable("/Users/hemakumarchinnaiah/Automation Work/chromedriver");

		options.setApp("/Users/hemakumarchinnaiah/Automation Work/resources/General-Store.apk");
		// options.setApp("//Users//rahulshetty//workingcode//Appium//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);

	}

	


	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
