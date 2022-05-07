package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver ; //driver Object
	public LoginPage lp;      //object of login page class
	public AddCustomer ac; 
	public SearchCustomerPage sc;
	public static Logger logger;
	public Properties prop;
	
	//created for generating random string for unique email id
	public static String randomEmail() {
		
		String str1=RandomStringUtils.randomAlphabetic(5);
		
		return (str1);
	}
}
