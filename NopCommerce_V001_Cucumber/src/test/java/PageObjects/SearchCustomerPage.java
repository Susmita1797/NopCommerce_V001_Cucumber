package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;	
	WaitHelper waithelper;

	public SearchCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(ldriver,this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindBy(id="SearchEmail")
	@CacheLookup
	WebElement searchEmail;

	@FindBy(id="SearchFirstName")
	@CacheLookup
	WebElement SearchFirstName;

	@FindBy(id="SearchLastName")
	@CacheLookup
	WebElement SearchLastName;

	@FindBy(how = How.ID, using="search-customers")
	@CacheLookup
	WebElement search;

	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> tablerows;

	@FindBy(how = How.XPATH, using="//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecols;

	public void setEmail(String email) {
		waithelper.WaitForElement(searchEmail, 30);
		searchEmail.clear();
		searchEmail.sendKeys(email);
	}

	public void setFirstName(String fname) {
		waithelper.WaitForElement(searchEmail, 30);
		SearchFirstName.clear();
		SearchFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		waithelper.WaitForElement(searchEmail, 30);
		SearchLastName.clear();
		SearchLastName.sendKeys(lname);
	}

	public void clickSearch() {
		waithelper.WaitForElement(searchEmail, 30);
		search.click();
	}

	public int getNoOfRows() {

		return (tablerows.size());
	}


	public int getNoOfCols() {

		return (tablecols.size());
	}

	public boolean searchCustomerByEmail(String email) {

		boolean flag=false;

		for(int i=1;i<=getNoOfRows();i++) {

			String emailid = ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();

			System.out.println(emailid);

			if(emailid.equals(email)) {

				flag=true;
			}
		}

		return flag;
	}

	public boolean searchCustomerByFirstName(String fname) {

		boolean flag=false;

		for(int i=1;i<=getNoOfRows();i++) {

			String firstName = ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			
			System.out.println(firstName);
			
			String arr[] =firstName.split(" ");
			
			String first=arr[0];
			
			String last=arr[1];

			System.out.println(first);

			if(first.equals(fname)) {

				flag=true;
			}
		}

		return flag;
	}
}
