package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class SigninPage {
	public static By username_ip = AppiumBy.accessibilityId("Enter an e-mail address or username");
	public static By pwd_ip = AppiumBy.accessibilityId("Password");
	public static By login_btn = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.view.ViewGroup");
	public static By error_txt = AppiumBy.androidUIAutomator("text(\"There was an issue signing in\")");
}
