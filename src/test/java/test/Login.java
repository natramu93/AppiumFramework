package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import pageobjects.CoursePage;
import pageobjects.LaunchPage;
import pageobjects.SigninPage;
import utility.AndroidUtility;
import utility.ExcelUtility;

public class Login {

	@Test(dataProvider="negativeLoginData")
	public void negativeLogin(String user,String pwd) {
		AndroidUtility.initializeApp("org.khanacademy.android", "ui.library.MainActivity");
		AndroidUtility.click(LaunchPage.dismiss_btn);
		AndroidUtility.click(LaunchPage.signIn_btn);
		AndroidUtility.click(LaunchPage.signIn_btn);
		AndroidUtility.type(SigninPage.username_ip,user);
		AndroidUtility.type(SigninPage.pwd_ip, pwd);
		AndroidUtility.click(SigninPage.login_btn);
		AndroidUtility.click(SigninPage.error_txt);
	}
	
	@DataProvider
	public Object[][] negativeLoginData(){
//		return new Object[][] {
//			{"user","pass"},
//			{"admin","pass"},
//			{"","pass"},
//			{"admin",""}
//			};
		return ExcelUtility.getData("TestData.xlsx", "negativeLogin");
	}
}
