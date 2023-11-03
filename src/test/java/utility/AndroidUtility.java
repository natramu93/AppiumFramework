package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidUtility {
	static AndroidDriver driver;
	static DesiredCapabilities cap;
	static void defaultCapabilities()
	{
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("deviceName", "mydevice");
	}
	public static void initializeApk(String appPath) {
		defaultCapabilities();
		cap.setCapability("app", appPath);
		try {
			driver = new AndroidDriver(new URL("http://localhost:4723"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
	}
	
	public static void initializeApp(String appPackage,String appActivity) {
		defaultCapabilities();
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		try {
			driver = new AndroidDriver(new URL("http://localhost:4723"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
	}
	
	public static void initializeBrowser(String browserName) {
		defaultCapabilities();
		cap.setCapability("browserName", browserName);
		try {
			driver = new AndroidDriver(new URL("http://localhost:4723"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
	}
	
	public static void click(By by) {
		driver.findElement(by).click();
	}
	
	public static void swipeTo(By by) {
		AndroidTouchAction act = new AndroidTouchAction(driver);
		Dimension d = driver.manage().window().getSize();
		while(driver.findElements(by).size()==0)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			act.longPress(PointOption.point(d.width/2,3*d.height/4)).moveTo(PointOption.point(d.width/2, d.height/4)).release().perform();
		}
	}
	
	public static void type(By by, String val) {
		driver.findElement(by).sendKeys(val);
	}
}
