package Pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;
import com.pwc.productcentral.Driver;



public class LoginPageObjects extends HelperFunctions{
	public LoginPageObjects() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(name= "j_username")
	private WebElement username;
	@FindBy(name="j_password")
	private WebElement password;
	@FindBy(id="submit-button")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//a[@id='loginLink']")
	private WebElement loginLink;
	
	@FindBy(xpath="//div[@data-href='/content/pc/us/en/my-products/product-4.html']")
	private WebElement loginLink2;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-container']//a")
	private static List<WebElement> productLinks;
	
	ReadXLSdata read1=new ReadXLSdata();
	
	public void setLogin() throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    Driver.getDriver().navigate().refresh();
	    HelperFunctions.waitForPageToLoad(3);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://productcentral-qa.products.pwc.com/");
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("window.scrollBy(0,250)", "");
	    HelperFunctions.staticWait(3);
	    loginLink2.click();
	    HelperFunctions.staticWait(5);
	    
	}
	
	public void setLoginAuthor() {
		email.sendKeys("erincbaser@gmail.com");
		next.click();
		pass.sendKeys("Ege123/.");
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/sites.html/content/pc/us/en/automation");
	    //HelperFunctions.staticWait(5);
	    //loginLink.click();
	    //HelperFunctions.staticWait(5);
	    
	}
	
	
	
	
	
	public void setUsername(String userName) {
		username.sendKeys(userName);
	}
	public void setPassword(String passWord) {
		password.sendKeys(passWord);
	}
	public void setSignInButton() {
		signInButton.click();
	}
	

}
