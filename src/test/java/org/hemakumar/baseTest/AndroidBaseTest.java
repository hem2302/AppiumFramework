package org.hemakumar.baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.hemakumar.PageObjects.android.FormPage;
import org.hemakumar.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	FormPage formPage;

	@BeforeClass
	public void ConfigureAppium() throws IOException {

		// *** for MacOS
		// service = new AppiumServiceBuilder()
		// .withAppiumJS(new
		// File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
		// .withIPAddress("127.0.0.1").usingPort(4723).build();

		// *** for Windows

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//org//hemakumar//resources//data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		int portNumber = Integer.parseInt(prop.getProperty("portNumber"));
		String androidDeviceName = prop.getProperty("AndroidDeviceName");

		service = startAppiumServer(ipAddress, portNumber);

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("androidDeviceName"); // emulator
		// options.setDeviceName("Android Device");// real device

		// *** for MacOS
		// options.setChromedriverExecutable("/Users/hemakumarchinnaiah/Automation
		// Work/chromedriver");

		// *** for Windows
		options.setChromedriverExecutable(System.getProperty("user.dir") + "//Drivers//AndroidDriver//chromedriver.exe");

		// *** for MacOS
		// options.setApp("/Users/hemakumarchinnaiah/Automation

		// Work/resources/General-Store.apk");
		// *** for Windows
		options.setApp(
				System.getProperty("user.dir") + "//src//test//java//org//hemakumar//resources//General-Store.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
