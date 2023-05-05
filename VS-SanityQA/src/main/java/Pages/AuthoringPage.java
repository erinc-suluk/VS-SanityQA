package Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;


public class AuthoringPage extends HelperFunctions {
	public AuthoringPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//coral-columnview-item[@data-foundation-collection-item-id='/content/valuestore/us']")
	private WebElement US;
	
	@FindBy(xpath="//coral-columnview-item[@data-foundation-collection-item-id='/content/valuestore/mx']//coral-columnview-item-content[@role='presentation']")
	private WebElement MX;
	
	@FindBy(xpath="//coral-columnview-item[@class='foundation-collection-item coral3-ColumnView-item coral3-ColumnView-item--drilldown']//div[@title='Value Store'][normalize-space()='Value Store']")
	private WebElement valueStoreTitle1;
	
	@FindBy(xpath="//div[normalize-space()='en']")
	private WebElement enPage;
	
	@FindBy(xpath="//div[@title='es']")
	private WebElement esPage;
 
    
	ReadXLSdata read1=new ReadXLSdata();
	
	public void setTerritory() throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 8));
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.visibilityOf(US));
	    US.click();
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(valueStoreTitle1));
	    Assert.assertTrue(enPage.isDisplayed());
	    HelperFunctions.staticWait(2);
	    MX.click();
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(esPage));
	    Assert.assertTrue(esPage.isDisplayed());
	    HelperFunctions.staticWait(3);
	}
    

}
