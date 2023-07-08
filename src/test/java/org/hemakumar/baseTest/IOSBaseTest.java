package org.hemakumar.baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.hemakumar.PageObjects.iOS.HomePage;
import org.hemakumar.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class IOSBaseTest extends AppiumUtils {

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public HomePage homePage;

	@BeforeClass
	public void ConfigureAppium() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//org//hemakumar//resources//data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		int portNumber = Integer.parseInt(prop.getProperty("portNumber"));
		String iOSDeviceName = prop.getProperty("iOSDeviceName");

		service = startAppiumServer(ipAddress, portNumber);

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName(iOSDeviceName);

		options.setApp(
				System.getProperty("user.dir") + "//src//test//java//org//hemakumar//resources//General-Store.apk");
		// options.setApp("//Users//rahulshetty//workingcode//Appium//src//test//java//resources//TestApp
		// 3.app");
		options.setPlatformVersion("15.5");
		// Appium- Webdriver Agent -> IOS Apps.
		options.setWdaLaunchTimeout(Duration.ofSeconds(25));

		driver = new IOSDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
