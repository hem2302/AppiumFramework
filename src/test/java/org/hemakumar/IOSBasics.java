package org.hemakumar;

import org.hemakumar.PageObjects.iOS.AlertViews;
import org.hemakumar.baseTest.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {

	@Test
	public void IOSBasicsTest() {
		// Xpath, classname, IOS, iosClassCHain, IOSPredicateString, accessibility id,
		// id

		AlertViews alertViews = homePage.selectAlertViews();
		alertViews.fillTextMenu("hello");
		String actualMessage = alertViews.getconfirmMessage();
		Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
		alertViews.submitForm();

		// longpress, scroll, swipe, slides, dropdowns

	}
}
