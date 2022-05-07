package PageObjects;

import java.util.List;

import org.apache.velocity.runtime.directive.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class AddCustomer {

	public WebDriver ldriver;

	public AddCustomer(WebDriver rdriver) 
	{		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}	

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	@CacheLookup
	WebElement CustomersMenu;

	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	@CacheLookup
	WebElement CustomersOption;

	@FindBy(xpath="//a[normalize-space()='Add new']")
	@CacheLookup
	WebElement AddNewCustomer;

	@FindBy(xpath ="//input[@id='Email']")
	@CacheLookup
	WebElement CustomerEmail;

	@FindBy(xpath ="//input[@id='Password']")
	@CacheLookup
	WebElement CustomerPassword;

	@FindBy(id="FirstName")
	@CacheLookup
	WebElement Customerfname; 

	@FindBy(xpath ="//input[@id='LastName']")
	@CacheLookup
	WebElement Customerlname;

	@FindBy(xpath="//input[@id='Gender_Female']")
	@CacheLookup
	WebElement femaleGender;
	
	@FindBy(id="Gender_Male")
	@CacheLookup
	WebElement maleGender;

	@FindBy(xpath="//span[@class='k-icon k-i-calendar']")
	@CacheLookup
	WebElement CustomerDOB;

	@FindBy(id="Company")
	@CacheLookup
	WebElement CustomerCompany;

	@FindBy(xpath="//button[@name='save']")
	@CacheLookup
	WebElement SaveButton;

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	@CacheLookup
	WebElement saveSuccessMsg;

	@FindBy(xpath="//li[normalize-space()='Administrators']")
	@CacheLookup
	WebElement Administrators;

	@FindBy(xpath="//li[normalize-space()='Forum Moderators']")
	@CacheLookup
	WebElement forumModerators;

	@FindBy(xpath="//li[normalize-space()='Guests']")
	@CacheLookup
	WebElement Guests;

	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement Vendors;
	

	//Action Methods
	public String getPagetitle() {

		return ldriver.getTitle();
	}
	public void clickOnCustomerMenu() {

		CustomersMenu.click();
	}

	public void clickOnCustomerOption() {

		CustomersOption.click();
	}

	public void addNewCustomer() {

		AddNewCustomer.click();
	}

	public void enterCustomerEmail(String email) {

		CustomerEmail.sendKeys(email);
	}

	public void enterCustomerPassword(String password) {

		CustomerPassword.sendKeys(password);
	}

	public void Customerfname(String fname) {

		Customerfname.sendKeys(fname);
	}

	public void Customerlname(String lname) {

		Customerlname.sendKeys(lname);
	}


	public void setCustomerRoles(String role) {

		ldriver.findElement(By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']")).click();

		if(role.equals(Administrators.getText())) {

			Administrators.click();
		}

		else if(role.equals(forumModerators.getText())) {

			forumModerators.click();
		}

		else if(role.equals(Guests.getText())) {
            
			ldriver.findElement(By.xpath("//span[@title='delete']")).click();
			
			Guests.click();
		}
		
		else if(role.equals(Vendors.getText())) {

			Vendors.click();
		}
	}
	
	public void CustomerGender(String Gender) {
        
		if(Gender.equals(femaleGender.getText())) {
			
			femaleGender.click();
		}
		
		else if(Gender.equals(maleGender.getText())){
			
			maleGender.click();
		}
	}

	public void setDOB() {

		String year ="2021";
		String month ="August";
		String date ="17";

		CustomerDOB.click();		

		while(true) {

			String monyear = ldriver.findElement(By.xpath("//div[@class='k-animation-container']//a[2]")).getText();
			String arr[] =monyear.split(" ");			
			String mon=arr[0];
			String yr=arr[1];			

			if(mon.equals(month) && yr.equals(year))  {				
				break;
			}

			else {

				ldriver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-left']")).click();
			}}

		//date selection
		List<WebElement> alldates= 	ldriver.findElements(By.xpath("//table[@class='k-content k-month']//td"));

		for(WebElement ele:alldates) 
		{			
			String dt =ele.getText();
			if(dt.equals(date)) {				
				ele.click();
				break;
			}				
		}
	}


	public String viewConfirmationMessage() {

		String msg = saveSuccessMsg.getText();

		return msg;
	}
	
	public void saveData() {
		SaveButton.click();
	}
}
