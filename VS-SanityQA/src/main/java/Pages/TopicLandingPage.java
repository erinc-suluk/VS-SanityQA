package Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
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

public class TopicLandingPage extends HelperFunctions {
	public TopicLandingPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	@FindBy(xpath="//coral-icon[@icon='properties']")
	private WebElement pageInfo;
	
	@FindBy(xpath="//button[@title='Open Properties']")
	private WebElement openPro;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Publish Page']")
	private WebElement publishPage;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='View as Published']")
	private WebElement viewPublished;
	
	@FindBy(xpath="//a[@data-tag-id='Deals']")
	private WebElement dealsTag;
	
	@FindBy(xpath="//img[@alt='logo']")
	private WebElement logo;
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	private WebElement editButton;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton;
	
	@FindBy(xpath="//div[@class='vs-title-area__card-box-content']")
	private WebElement titleArea;
	
	@FindBy(xpath="//button[@title='Configure']")
	private WebElement configure;
	
	@FindBy(xpath="//div[@title='Key Asset Bar Component']")
	private WebElement keyAssetBarComponent;
	
	@FindBy(xpath="//div[@title='Key Asset Bar Component']")
	private WebElement keyAssetEdit;
	
	@FindBy(xpath="//h2[normalize-space()='Key Asset Bar Container']")
	private WebElement keyAssetContainer;
	
	@FindBy(xpath="//coral-multifield-item[@aria-label='(1 of 4)']")
	private WebElement firstKeyAsset;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Add']")
	private WebElement addKeyAsset;
	
	@FindBy(xpath="//coral-icon[@aria-label='You can add maximum 4 links. You are trying to add 5th link.']")
	private WebElement errorLabel1;
	
	@FindBy(xpath="//div[@title='Hot Topics']")
	private WebElement hotTopicsEdit;
	
	@FindBy(xpath="//coral-dialog-header[normalize-space()='Hot Topics']")
	private WebElement hotTopicsTitle;
	
	@FindBy(xpath="//span[normalize-space()='Hot Topics']")
	private WebElement hotTopicsBanner;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Add']")
	private WebElement addHotTopic;
	
	@FindBy(xpath="//coral-button-label[normalize-space()='Add']")
	private WebElement errorLabel;
	
	@FindBy(xpath="//div[@class='vs-hot-topics__heading-favorite-wrapper']")
	private static List<WebElement> hotTopicsTitles;
	
	@FindBy(xpath="//h2[normalize-space()='Topic Test']")
	private WebElement topicPageTitle;
	
	@FindBy(xpath="//div[@class='vs-title-area__card-box-content']")
	private WebElement topicContentTitle;
	
	@FindBy(xpath="//div[@class='vs-title-area__back-link']//button")
	private WebElement backToTopic;
	
	@FindBy(xpath="//div[@class='vs-topic-feed__heading-favorite-wrapper']//a")
	private static List<WebElement> feedTopics;
	
	ReadXLSdata read1=new ReadXLSdata();
	
	public void setKeyAssetBar(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 9));
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for edit button visibility and clicked on it");
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.elementToBeClickable(editButton));
	    editButton.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on key asset edit");
	    //HelperFunctions.scrollToElement(editTitle);
	    keyAssetEdit.click();
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(keyAssetBarComponent.isDisplayed());
	    test.info("Verified keyAssetBarComponent banner is displayed");
	    HelperFunctions.staticWait(3);
	    test.info("Verified configure button is displayed");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.elementToBeClickable(configure));
	    Assert.assertTrue(configure.isDisplayed());
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on configure button");
	    configure.click();
	    HelperFunctions.staticWait(3);	   
	    test.info("Wait for key asset container visibility");
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(keyAssetContainer));
	    Assert.assertTrue(keyAssetContainer.isDisplayed());
	    test.info("Verified key asset container is displayed");
	    HelperFunctions.staticWait(3);	
	    String upto4articles=firstKeyAsset.getAttribute("aria-setsize");
	    String upto4articlesExpected="4";
	    Assert.assertTrue(upto4articles.equalsIgnoreCase(upto4articlesExpected));
	    HelperFunctions.staticWait(3);	
	}
	
	public void setHotTopics(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 9));
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for edit button visibility and clicked on it");
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.elementToBeClickable(editButton));
	    editButton.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on hot topics edit");
	    //HelperFunctions.scrollToElement(editTitle);
	    hotTopicsEdit.click();
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(hotTopicsBanner.isDisplayed());
	    test.info("Verified keyAssetBarComponent banner is displayed");
	    HelperFunctions.staticWait(3);
	    test.info("Verified configure button is displayed");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.elementToBeClickable(configure));
	    Assert.assertTrue(configure.isDisplayed());
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on configure button");
	    configure.click();
	    HelperFunctions.staticWait(3);	   
	    test.info("Wait for hot Topics Title visibility");
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(hotTopicsTitle));
	    Assert.assertTrue(hotTopicsTitle.isDisplayed());
	    test.info("Verified hot Topics Title is displayed");
	
	}
	public void setKeyAssetBar4articles(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 9));
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for edit button visibility and clicked on it");
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.elementToBeClickable(editButton));
	    editButton.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on key asset edit");
	    //HelperFunctions.scrollToElement(editTitle);
	    keyAssetEdit.click();
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(keyAssetBarComponent.isDisplayed());
	    test.info("Verified keyAssetBarComponent banner is displayed");
	    HelperFunctions.staticWait(3);
	    test.info("Verified configure button is displayed");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.elementToBeClickable(configure));
	    Assert.assertTrue(configure.isDisplayed());
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on configure button");
	    configure.click();
	    HelperFunctions.staticWait(3);	   
	    test.info("Wait for key asset container visibility");
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(keyAssetContainer));
	    Assert.assertTrue(keyAssetContainer.isDisplayed());
	    test.info("Verified key asset container is displayed");
	    HelperFunctions.staticWait(3);	
	    String upto4articles=firstKeyAsset.getAttribute("aria-setsize");
	    String upto4articlesExpected="4";
	    Assert.assertTrue(upto4articles.equalsIgnoreCase(upto4articlesExpected));
	    test.info("Verified article aria set size is equal to 4");
	    HelperFunctions.staticWait(3);	
	    HelperFunctions.scrollToElement(addKeyAsset);
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on add key asset");
	    addKeyAsset.click();
	    HelperFunctions.staticWait(3);
	    HelperFunctions.scrollToElement(errorLabel1);
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(errorLabel1.isDisplayed());
	    test.info("Verified errorLabel1 is displayed");
	    HelperFunctions.staticWait(3);
	    
	}
	
	public void setHotTopics4articles(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 9));
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for edit button visibility and clicked on it");
	    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
	    wait.until(ExpectedConditions.elementToBeClickable(editButton));
	    editButton.click();
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on hot topics edit");
	    //HelperFunctions.scrollToElement(editTitle);
	    hotTopicsEdit.click();
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(hotTopicsBanner.isDisplayed());
	    test.info("Verified keyAssetBarComponent banner is displayed");
	    HelperFunctions.staticWait(3);
	    test.info("Verified configure button is displayed");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.elementToBeClickable(configure));
	    Assert.assertTrue(configure.isDisplayed());
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on configure button");
	    configure.click();
	    HelperFunctions.staticWait(3);	   
	    test.info("Wait for hot Topics Title visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(hotTopicsTitle));
	    Assert.assertTrue(hotTopicsTitle.isDisplayed());
	    test.info("Verified hot Topics Title is displayed");
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on add hot topic");
	    addHotTopic.click();
	    HelperFunctions.staticWait(2);
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(errorLabel));
	    Assert.assertTrue(errorLabel.isDisplayed());
	    test.info("Verified error label is displayed");
	    HelperFunctions.staticWait(3);
	}
	public void setBacktoTopicandTopicsSize(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 9));
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
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(topicPageTitle));
	    Assert.assertTrue(topicPageTitle.isDisplayed());
	    test.info("Verified topic page title is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(hotTopicsTitles.size()==4);
	    test.info("Verified hot topic title's size is 4");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on hot topic");
	    hotTopicsTitles.get(0).click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for topic content title's visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(topicContentTitle));
	    Assert.assertTrue(topicContentTitle.isDisplayed());
	    test.info("Verified topic content title's is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(backToTopic.isDisplayed());
	    test.info("Verified back to topic breadcrumb is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on bac to topic");
	    backToTopic.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for topic page title's visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(topicPageTitle));
	    Assert.assertTrue(topicPageTitle.isDisplayed());
	    test.info("Verified topic page title's is displayed");
	    HelperFunctions.staticWait(2);
	}
	public void setFeedTopics(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 9));
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
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(topicPageTitle));
	    Assert.assertTrue(topicPageTitle.isDisplayed());
	    HelperFunctions.staticWait(2);
	    for (WebElement element : feedTopics) {
            if (element.getText().toLowerCase().contains("content")) {
            	   ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            	   JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
                   executor.executeScript("arguments[0].click();", element);
                break;
            }
        }
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(backToTopic));
	    Assert.assertTrue(backToTopic.isDisplayed());
	    HelperFunctions.staticWait(2);
	    
	}

}
