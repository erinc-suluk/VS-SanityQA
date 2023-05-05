package Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class GhostedPage extends HelperFunctions{
	public GhostedPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	private WebElement editButton;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton;
	
	@FindBy(xpath="//div[@class='vs-title-area__card-box-content']")
	private WebElement titleArea;
	
	@FindBy(xpath="//button[@title='Configure']")
	private WebElement configure;
	
	@FindBy(xpath="//coral-icon[@icon='properties']")
	private WebElement pageInfo;
	
	@FindBy(xpath="//button[@title='Open Properties']")
	private WebElement openPro;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Publish Page']")
	private WebElement publishPage;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='View as Published']")
	private WebElement viewPublished;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Save & Close']")
	private WebElement saveClose;
	
	@FindBy(xpath="//h2[@class='vs-title-area__card-box-content-heading page-title ']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//input[@name='./jcr:title']")
	private WebElement titleField;
	
	@FindBy(xpath="//label[normalize-space()='Description *']")
	private WebElement description;
	
	@FindBy(xpath="//label[normalize-space()='Title *']")
	private WebElement title;
	
	@FindBy(xpath="//label[normalize-space()='Error: Please fill out this field.']")
	private WebElement errorMessage;
	
	@FindBy(xpath="(//label[normalize-space()='Off Time *'])[1]")
	private WebElement offTime;
	
	@FindBy(xpath="//coral-datepicker[@data-cq-msm-lockable='offTime']//input[@role='combobox']")
	private WebElement dateField;
	
	@FindBy(xpath="//coral-datepicker[@data-cq-msm-lockable='offTime']//button[@title='Calendar']")
	private WebElement calendar;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Create']")
	private WebElement createButton;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath="//img[@src='/content/dam/valuestore/us/en/thumbnails/Ghost.png']")
	private WebElement ghostedPage;
	
	@FindBy(xpath="//a[@aria-label='PwC']")
	private WebElement pwcLogo;
	
	@FindBy(xpath="//label[normalize-space()='Primary Category Tag *']")
	private WebElement primaryCat;
	
	@FindBy(xpath="//label[normalize-space()='Primary Topic Tag *']")
	private WebElement primaryTopic;
	
	@FindBy(xpath="//label[normalize-space()='Primary Economic Buyer Tag *']")
	private WebElement primaryEco;
	
	@FindBy(xpath="//label[normalize-space()='Publish Date *']")
	private WebElement publishDate;
	
	@FindBy(xpath="//label[normalize-space()='Display Image for Content Page *']")
	private WebElement contentImage;
	
	@FindBy(xpath="(//button[@title='Open Selection Dialog'])[1]")
	private WebElement primary1;
	
	@FindBy(xpath="(//button[@title='Open Selection Dialog'])[2]")
	private WebElement primary2;
	
	@FindBy(xpath="(//button[@title='Open Selection Dialog'])[4]")
	private WebElement primary3;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./primarySolutionTag']//input[@role='combobox']")
	private WebElement primary1field;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./primaryTopicTag']//input[@role='combobox']")
	private WebElement primary2field;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./primaryEconomicBuyerTag']//input[@role='combobox']")
	private WebElement primary3field;
	
	@FindBy(xpath="//coral-columnview-item-content[@title='Category']")
	private WebElement path1forPrimary1;
	
	@FindBy(xpath="//coral-columnview-item[@title='Firmwide']//coral-columnview-item-thumbnail[@role='presentation']")
	private WebElement path2forPrimary1;
	
	@FindBy(xpath="//coral-columnview-item-content[@title='Topic']")
	private WebElement path1forPrimary2;
	
	@FindBy(xpath="//coral-columnview-item[@title='Deals']//coral-columnview-item-thumbnail[@role='presentation']")
	private WebElement path2forPrimary2;
	
	@FindBy(xpath="//coral-columnview-item-content[@title='Economic buyer']")
	private WebElement path1forPrimary3;
	
	@FindBy(xpath="//coral-columnview-item[@title='Chief Risk']//coral-columnview-item-thumbnail[@role='presentation']")
	private WebElement path2forPrimary3;
	
	@FindBy(xpath="//label[normalize-space()='Please fill out this field.']")
	private static List<WebElement> errorMessage2;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Select']")
	private WebElement selectButton;
	
	ReadXLSdata read1=new ReadXLSdata();
	
	public void setMandatoryFields(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 6));
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for ghosted page visibility and click on it");
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(ghostedPage));
	    visibleElement.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on next button");
	    nextButton.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for title field visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    WebElement visibleElement2 = wait2.until(ExpectedConditions.visibilityOf(titleField));
	    visibleElement2.click();
	    String titleText = title.getText();
	    boolean hasAsterisk = titleText.contains("*");
	    Assert.assertTrue(hasAsterisk, "The 'titleText' field does not have an asterisk.");
	    test.info("Verified title field has asterisk");
	    HelperFunctions.staticWait(2);
	    String descriptionText = description.getText();
	    boolean hasAsterisk2 = descriptionText.contains("*");
	    Assert.assertTrue(hasAsterisk2, "The 'titleText' field does not have an asterisk.");
	    test.info("Verified description field has asterisk");
	    HelperFunctions.staticWait(2);
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
		 boolean isNotClickable = wait4.until(ExpectedConditions.invisibilityOfElementLocated(By.id("createButton")));

		 if (isNotClickable) {
		     System.out.println("The element is not clickable");
		     Assert.assertTrue(true);
		 } else {
		     System.out.println("The element is clickable");
		 }
		 test.info("Verified cretae button is not clickable");
		 HelperFunctions.staticWait(2);
	    
	}
	public void setExternalContent(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	    js.executeScript("arguments[0].click();", pageInfo);
	    HelperFunctions.staticWait(3);
	    viewPublished.click();
	    HelperFunctions.staticWait(2);
	    String mainWindowHandle = Driver.getDriver().getWindowHandle();
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> windowHandles = Driver.getDriver().getWindowHandles();
	    Iterator<String> iterator = windowHandles.iterator();
	    String currentHandle = "";
	    while (iterator.hasNext()) {
	        currentHandle = iterator.next();
	        if (!currentHandle.equals(mainWindowHandle)) {
	        	Driver.getDriver().switchTo().window(currentHandle);
	            break;
	        }
	    }
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for pwc logo is displayed");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(pwcLogo));
	    Assert.assertTrue(pwcLogo.isDisplayed());
	    test.info("Verified that pwc logo is displayed");
	    HelperFunctions.staticWait(3);
	}
	public void setPrimaryTags(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 6));
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for ghosted page's visibility and clicked on it");
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(ghostedPage));
	    visibleElement.click();
	    HelperFunctions.staticWait(2);
	    test.info("WClicked on next button");
	    nextButton.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for title field's visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(titleField));
	    //visibleElement2.click();
	    HelperFunctions.staticWait(2);
	    test.info("Scroll to off time element");
	    HelperFunctions.scrollToElement(offTime);
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on primary 1 and selected the paths");
        primary1.click();
        HelperFunctions.staticWait(2);
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(path1forPrimary1));
        path1forPrimary1.click();
        HelperFunctions.staticWait(3);
        WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(path2forPrimary1));
	    test.info("Clicked on primary 2 and selected the paths");
        path2forPrimary1.click();
        HelperFunctions.staticWait(3);
        selectButton.click();
        HelperFunctions.staticWait(3);
        WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
	    wait5.until(ExpectedConditions.visibilityOf(primary2));
        primary2.click();
        HelperFunctions.staticWait(3);
        WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 10);
	    wait6.until(ExpectedConditions.visibilityOf(path1forPrimary2));
        path1forPrimary2.click();
        HelperFunctions.staticWait(3);
        WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 10);
	    wait7.until(ExpectedConditions.visibilityOf(path2forPrimary2));
        path2forPrimary2.click();
        HelperFunctions.staticWait(3);
        selectButton.click();
        HelperFunctions.staticWait(3);
        WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 10);
	    wait8.until(ExpectedConditions.visibilityOf(primary3));
	    test.info("Clicked on primary 3 and selected the paths");
        primary3.click();
        HelperFunctions.staticWait(3);
        WebDriverWait wait9 = new WebDriverWait(Driver.getDriver(), 10);
	    wait9.until(ExpectedConditions.visibilityOf(path1forPrimary3));
        path1forPrimary3.click();
        HelperFunctions.staticWait(3);
        WebDriverWait wait10 = new WebDriverWait(Driver.getDriver(), 10);
	    wait10.until(ExpectedConditions.visibilityOf(path2forPrimary3));
        path2forPrimary3.click();
        HelperFunctions.staticWait(3);
        selectButton.click();
        WebDriverWait wait11 = new WebDriverWait(Driver.getDriver(), 10);
        boolean isListInvisible = wait11.until(ExpectedConditions.invisibilityOfAllElements(errorMessage2));
        assert isListInvisible : "Error message list exists on the page!";
        HelperFunctions.staticWait(2);
        test.info("Cleared on primary 1 and verified the error message");
        primary1field.click();
        HelperFunctions.staticWait(2);
        primary1field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        HelperFunctions.staticWait(2);
        test.info("Cleared on primary 2 and verified the error message");
        primary2field.click();
        HelperFunctions.staticWait(2);
        primary2field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        HelperFunctions.staticWait(2);
        primary3field.click();
        HelperFunctions.staticWait(2);
        primary3field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        HelperFunctions.staticWait(2);
        WebDriverWait wait12 = new WebDriverWait(Driver.getDriver(), 10);
        List<WebElement> displayedElements = wait12.until(ExpectedConditions.visibilityOfAllElements(errorMessage2));
        assert !displayedElements.isEmpty() : "Error message list is not displayed on the page!";
        HelperFunctions.staticWait(3);
	}
	
	
}
