package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class LaunchPage {
	public static By dismiss_btn = AppiumBy.androidUIAutomator("text(\"Dismiss\")");
	public static By signIn_btn = AppiumBy.androidUIAutomator("text(\"Sign in\")");
}
