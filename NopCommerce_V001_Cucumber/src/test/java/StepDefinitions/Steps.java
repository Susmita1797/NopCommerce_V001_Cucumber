package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Steps extends BaseClass {

//	@Before
//	public void setup() throws IOException {		
//		
//		logger=logger.getLogger("NopCommerce");   //Added logger
//		PropertyConfigurator.configure("Log4j.properties");   //Added logger
//		
//		//Read the Properties file
//		prop = new Properties();
//		FileInputStream configpropfile = new FileInputStream("config.properties");
//		prop.load(configpropfile);		
//
//		String br = prop.getProperty("browser");
//		
//		System.out.println(br);	
//		
//		if(br.equals("chrome")) {
//                
//			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
//			driver = new ChromeDriver(); //initiate driver object
//			
//		}
//
//		else if(br.equals("firefox")) {
//
//			System.setProperty("webdriver.firefox.driver", prop.getProperty("firefoxpath"));
//			driver = new FirefoxDriver(); //initiate driver object
//			
//		}
//
//		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\NopCommerce_V001_Cucumber\\Drivers\\chromedriver100.exe");	
//		logger.info("******************Launching browser*************");
//	}

	@Given("user launch Chrome broswer")
	public void user_launch_chrome_broswer() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\NopCommerce_V001_Cucumber\\Drivers\\chromedriver100.exe");	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		lp = new LoginPage(driver);  //initiate login page object
		ac = new AddCustomer(driver);
		sc=new SearchCustomerPage(driver);

		logger=logger.getLogger("NopCommerce");   //Added logger
		PropertyConfigurator.configure("Log4j.properties");   //Added logger
				
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {

		logger.info("******************Launching URL*************");
		driver.get(url);
	}

	@When("users enters Email as {string} and Password as {string}")
	public void users_enters_email_as_and_password_as(String email, String password) {

		logger.info("******************Providing username and password*************");
		lp.setUsername(email);
		lp.setPassword(password);
	}

	@When("click on Login")
	public void click_on_login() {

		logger.info("******************submitting Login*************");
		lp.clickLogin();
	}

	@Then("Page Title should be{string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			logger.info("******************Login Passed*************");
			Assert.assertTrue(false); //marks test as fail
		} else {
			logger.info("******************Login failed*************");
			Assert.assertEquals(title, driver.getTitle()); //marks test as pass
		}
	}

	@When("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}


	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}

	//customer page methods
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {

		Assert.assertEquals("Dashboard / nopCommerce administration", ac.getPagetitle());

	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() {

		ac.clickOnCustomerMenu();
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		ac.clickOnCustomerOption();
	}

	@When("click on add new button")
	public void click_on_add_new_button() {
		ac.addNewCustomer();
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", ac.getPagetitle());
	}


	@When("user enter customer info")
	public void user_enter_customer_info() {

		logger.info("**********Adding the new Customer data*************");
		String email = randomEmail()+"@gmail.com";
		ac.enterCustomerEmail(email);
		ac.enterCustomerPassword("test123");
		ac.Customerfname("Sam");
		ac.Customerlname("Ruth");
		ac.setCustomerRoles("Guests");	
		ac.CustomerGender("Female");
		ac.setDOB();

	}

	@When("click on save button")
	public void click_on_save_button() {

		logger.info("*************Saving the Customer data*************");
		ac.saveData();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		// Assert.assertFalse(message.equals(ac.viewConfirmationMessage())); //marks test as fail	

		//Assert.assertTrue(message.equals(ac.viewConfirmationMessage()));

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(message));
	}




	//Steps for searching Customer using Email id


	@When("user enter customer Email")
	public void user_enter_customer_email() {

		logger.info("*************Searching Customer using email id*************");
		sc.setEmail("victoria_victoria@nopCommerce.com");

	}

	@When("user click on search button")
	public void user_click_on_search_button() {

		sc.clickSearch();
	}

	@Then("user should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {

		boolean status = sc.searchCustomerByEmail("victoria_victoria@nopCommerce.com");

		Assert.assertEquals(true, status);
	}


	//search customer using first name

	@When("user enter customer FirstName")
	public void user_enter_customer_first_name() {

		sc.setFirstName("Victoria");
	}


	@Then("user should found firstname in the search table")
	public void user_should_found_firstname_in_the_search_table() {

		boolean status = sc.searchCustomerByFirstName("Victoria");

		Assert.assertEquals(true, status);
	}
}



