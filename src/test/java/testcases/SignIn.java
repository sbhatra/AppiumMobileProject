package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Practice.AppiumFramework.Capability;
import Practice.AppiumFramework.SignInPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import java.io.IOException;

public class SignIn extends Capability {
	
	SignInPage objSignInPage;
	AndroidDriver<AndroidElement> driver;
	
	@Test //(priority=1)
	public void openApp() throws IOException, InterruptedException 
	{
		driver=DesiredCapability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objSignInPage = new SignInPage(driver);
		objSignInPage.clickDismis1();
		objSignInPage.clickDismis2();
	}
	
	@Test (dependsOnMethods = "openApp")
	public void loginApp() throws IOException, InterruptedException 
	{
		objSignInPage.signInMethod();		
	}
}
