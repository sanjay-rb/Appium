package test;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test2 {

	static AndroidDriver<WebElement> driver;
	public static void main(String[] args) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Added Automation....
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		// Added Platform name...
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		// Your Device or emulator name....
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		// Added Platform Version....
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		
		// App Package....
		cap.setCapability("appPackage", "com.sanjoke.myapplication");
		// App Activity....
		cap.setCapability("appActivity", "com.sanjoke.myapplication.MainActivity");
		
		// connect with appium....
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		testCase1();
		
	}
	private static void testCase1() {
		driver.findElementById("com.sanjoke.myapplication:id/email").sendKeys("sanjaybabu618@gmail.com");
		driver.findElementById("com.sanjoke.myapplication:id/pass").sendKeys("Sample");
		driver.findElementById("com.sanjoke.myapplication:id/login").click();
		driver.quit();
	}

}
