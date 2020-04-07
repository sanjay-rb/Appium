package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test1 {
	
	static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		// Desired Capabilities Settings....
		DesiredCapabilities cap = new DesiredCapabilities();
		// AutomationName as we discuss UIiAutomator is used....
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		// Your Platform of testing (in our case ANDROID)....
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		// Your Device or emulator name....
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		// Your Device Android Version.... 
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		
		/*
		 * IMPORTANT CAPABILITY
		 * app - Folder path of application apk file. (Optional)
		 * appPackage - Application package.
		 * appActivity - Application Launcher Activity.
		*/
		cap.setCapability("appPackage", "com.android.notes");
		cap.setCapability("appActivity", "com.android.notes.Notes");
		
		// Create the URL to our appium server running on localhost....
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		/* 
		 * Initialized the driver
		 * With
		 * URL of Appium Server
		 * Capability of the Device and Application.
		 */
		driver = new AndroidDriver<WebElement>(url, cap);
		
		// Test One ....
		testCase1();
		
	}
	
	//First Test....
	public static void testCase1() throws InterruptedException {
		driver.findElementById("com.android.notes:id/create_note_text").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("com.android.notes:id/title_edit_text").sendKeys("My Name!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("com.android.notes:id/line_edit_text").sendKeys("Hi this is Sanjay");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"Done\"]").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"Back\"]").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.quit();
	}

}
