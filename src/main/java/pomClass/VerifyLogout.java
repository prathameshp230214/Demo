package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLogout {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement logoutBtn;
	
	public VerifyLogout(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void verifyOnLogoutPage() {
		logoutBtn.isDisplayed();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}

}
