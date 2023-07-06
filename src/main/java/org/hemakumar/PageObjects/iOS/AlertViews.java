package org.hemakumar.PageObjects.iOS;

import org.hemakumar.utils.iOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews extends iOSActions {
	IOSDriver driver;

	public AlertViews(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label
	// =='Text Entry'`]")).click();

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label =='Text Entry'`]")
	private WebElement textEntryMenu;

//		AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'"))

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'\"")
	private WebElement confirmMenuItem;

//		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell\"")
	private WebElement textBox;

	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement acceptPopUp;

	// driver.findElement(AppiumBy.iOSNsPredicateString("label ==
	// 'Confirm'")).click();

	@iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
	private WebElement submit;

//		AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'"))
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
	private WebElement confirmMessage;
	
	public void fillTextMenu(String name) {
		textEntryMenu.click();
		textBox.sendKeys(name);
		acceptPopUp.click();
	}
	public String getconfirmMessage() {
		confirmMenuItem.click();
		return confirmMessage.getText();
	}
	public void submitForm() {
		submit.click();
	}
}
