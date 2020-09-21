package Practice.AppiumFramework;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

//manually added
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SelectCoursePage {
	
	AndroidDriver<AndroidElement> driver;
	public SelectCoursePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
//	public void clickEditBtn() throws InterruptedException {
//		WebElement getst = driver.findElementByAndroidUIAutomator("text(\"Edit\")");
//		getst.click();
//		Thread.sleep(10000);
//	}
	
	public void courseSelection() throws InterruptedException {
		Thread.sleep(4000);
		//WebElement getStartedButton=driver.findElement(MobileBy.className("android.widget.Button"));
		WebElement getStartedButton=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Get started\")"));
		getStartedButton.click();
		//scroll to Graduate Studies
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Graduate studies\"));"));
		
		WebElement GraduateStudies=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Graduate studies\")"));
		//GraduateStudies.click();
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(GraduateStudies))).perform();
		
		Thread.sleep(4000);
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Computer programming\"));"));
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Computer programming\"));");
		
		WebElement compProgram=driver.findElement(MobileBy.AccessibilityId("Checkmark"));
		compProgram.click();
	}
}
