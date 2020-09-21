package Practice.AppiumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SignInPage {
	AndroidDriver<AndroidElement> driver;
	public SignInPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public void clickDismis1() throws InterruptedException {
		Thread.sleep(8000);
		WebElement dismiss1=driver.findElement(MobileBy.className("android.widget.Button"));
		dismiss1.click();
	}
	
	public void clickDismis2() throws InterruptedException {
		Thread.sleep(5000);
		//Notes: text locators is used with AndroidUIAutomator()
		WebElement dismiss2=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Dismiss\")"));
		dismiss2.click();
	}
	
	public void signInMethod() throws InterruptedException {
		WebElement signInButton=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign in\")"));
		signInButton.click();
		Thread.sleep(3000);
		WebElement continueGoogle=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Continue with Google\")"));
		continueGoogle.click();
		Thread.sleep(3000);
		
		//resourceId - we can write it by 2 ways, first one is with 'id' and second one is with 'AndroidUIAutomator("UiSelector().resourceId'
		WebElement accountEmail=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"com.google.android.gms:id/account_name\")"));
		//driver.findElement(MobileBy.id("com.google.android.gms:id/account_name")).click();
		String actual=accountEmail.getText();
		actual=actual.replaceAll(".gmail.com", "");
		
		accountEmail.click();
		Thread.sleep(3000);
		
		//content-desc is similiar to AccessibilityId.
		WebElement settings=driver.findElement(MobileBy.AccessibilityId("Settings"));
		settings.click();
		
		Thread.sleep(8000);
		WebElement accName=driver.findElements(MobileBy.className("android.widget.TextView")).get(1);
		String expected=accName.getText();
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Assert.assertEquals(actual, expected);
		
	}

}
