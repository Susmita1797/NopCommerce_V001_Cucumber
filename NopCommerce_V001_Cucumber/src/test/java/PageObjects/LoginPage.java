package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver ldriver;

	//constructor
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="Email")
	@CacheLookup
	WebElement txtemail;

	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpwd;

	@FindBy(xpath="//button[@type=\"submit\"]")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement btnLogout;

	public void setUsername(String usrname) {

		txtemail.clear();
		txtemail.sendKeys(usrname);	
	}

	public void setPassword(String pwd) {

		txtpwd.clear();
		txtpwd.sendKeys(pwd);	
	}

	public void clickLogin() {
		
		btnLogin.click();
	}

	public void clickLogout() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(ldriver, 60);
//		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		Thread.sleep(5000);
		btnLogout.click();
		
}
}
