package Pages;




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
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='submit-button']//coral-button-label")
	private WebElement signin;
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	public void setLogin() throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
		HelperFunctions.waitForPageToLoad(3);
		username.sendKeys(read1.getCellData("DATA", 1));
		HelperFunctions.staticWait(2);
		password.sendKeys(read1.getCellData("VALUE", 1));
		signin.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(2);
	}

}


