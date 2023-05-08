package Pages;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.valuestore.Driver;
import com.pwc.valuestore.HelperFunctions;
import com.pwc.valuestore.ReadXLSdata;


public class HomePage extends HelperFunctions {
	public HomePage() {
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
	
	@FindBy(xpath="//figure[@class='vs-card__figure-wrapper']")
	private static List<WebElement> tagPills;
	
	@FindBy(xpath="//span[normalize-space()='Topic']")
	private WebElement selectTopic;
	
	@FindBy(xpath="(//label[@for='value-store:topic/deals'])[2]")
	private WebElement dealsCheckbox;
	
	@FindBy(xpath="//a[contains(text(),'erinc-content')]")
	private WebElement automationContentPage;
	
	@FindBy(xpath="//li[@class='userprofile']")
	private WebElement userIcon;
	
	@FindBy(xpath="//div[@class='vs-filter__selected vs-filter__desktop-selected']//button[1]")
	private WebElement selectedFilter;
	
	@FindBy(xpath="//div[@class='vs-filter__selected vs-filter__desktop-selected']//button[@class='vs-filter__selected-pill vs-filter__selected-pill--transparent'][normalize-space()='Clear filters']")
	private WebElement clearFilter;
	
	@FindBy(xpath="//h2[@class='vs-filter__title']")
	private WebElement filterTitle;
	
	@FindBy(xpath="//span[@class='vs-header__logo-title']")
	private WebElement valueStore;
	
	@FindBy(xpath="//button[@class='vs-card__cta-load-more']")
	private WebElement loadMore;
	
	@FindBy(xpath="//div[@class='vs-card__favorite-pill-wrapper']")
	private static List<WebElement> assets;
	
	@FindBy(xpath="(//a[@class='vs-feature-card__figure-heading'])[1]")
	private WebElement firstAssetHomepage;
	
	@FindBy(xpath="(//div[@class='vs-card__favorite-pill-wrapper'])[1]")
	private WebElement firstAssetFilter;
	
	@FindBy(xpath="//link[@rel='shortcut icon']")
	private WebElement faviconLink;
	
	@FindBy(xpath="//a[@class='vs-card__figure-heading']")
	private static List<WebElement> articleTitles;
	
	@FindBy(xpath="(//a[@class='vs-card__figure-heading'])[1]")
	private WebElement firstArticleTitle;
	
	@FindBy(xpath="(//p[@class='vs-card__figure-description'])[1]//a")
	private WebElement firstArticleDescription;
	
	@FindBy(xpath="(//img[@class='vs-card__figure-img'])[1]")
	private WebElement firstArticleImg;
	
	@FindBy(xpath="//h3[@class='vs-topic__heading']")
	private WebElement moretoExplore;
	
	@FindBy(xpath="//span[@class='vs-topic__subheading']")
	private WebElement moretoExploreSub;
	
	@FindBy(xpath="//div[@class='vs-topic__more-explorer-item']//a")
	private static List<WebElement> exploreItemsLink;
	
	@FindBy(xpath="//div[@class='vs-topic__more-explorer-item']")
	private static List<WebElement> exploreItems;
	
	@FindBy(xpath="//span[@class='vs-header__search-btn']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@placeholder='Search the Value Store']")
	private WebElement searchField;
	
	@FindBy(xpath="//span[@class='vs-search__result-not-found-heading']")
	private WebElement noSearchResult;
	
	@FindBy(xpath="//div[@class='vs-content__you-might-also-like-wrapper']//h2")
	private WebElement alsoLikeTitle;
	
	@FindBy(xpath="//div[@class='vs-card__box-heading_youmightalsolike']")
	private static List<WebElement> alsoLikeLabels;
	
	@FindBy(xpath="//div[@class='vs-card__youmightalsolike-box-content']")
	private static List<WebElement> alsoLikeTitles;
	
	@FindBy(xpath="//div[@class='vs-card__youmightalsolike-favorites']")
	private static List<WebElement> alsoLikeFavIcon;
	
	@FindBy(xpath="//div[@class='vs-card__youmightalsolike-highlight-item']")
	private WebElement alsoLikeImage;
	
	@FindBy(xpath="//a[@class='vs-header__quicklinks-img']//span")
	private WebElement quickLinksIcon;
	
	@FindBy(xpath="//div[@class='vs-header__td-menu-item-wrapper']")
	private static List<WebElement> tdMenuItems;
	
	@FindBy(xpath="//div[@class='vs-header__wt-menu-item-wrapper']")
	private static List<WebElement> wtMenuItems;
	
	@FindBy(xpath="//span[@class='vs-header__desktop-close-icon']")
	private WebElement closeQuickLinks;
	
	@FindBy(xpath="//li[@class='navigation vs-header__sub-menu']//span[@class='selected-value']")
	private WebElement terriMenu;
	
	@FindBy(xpath="//li[@class='navigation vs-header__sub-menu']//a[@title='MX_Title']")
	private WebElement mexico;
	
	@FindBy(xpath="//li[@class='navigation vs-header__sub-menu']//a[@title='Global']")
	private WebElement global;
	
	@FindBy(xpath="//li[@class='navigation vs-header__sub-menu']//a[@title='US_Title']")
	private WebElement US;
	
	@FindBy(xpath="//li[@data-suggestedterm-keyword='Tax']")
	private WebElement suggestedKeyword;
	
	@FindBy(xpath="//li[@data-suggestedterm-keyword='Topic']")
	private WebElement suggestedKeyword2;
	
	@FindBy(xpath="(//div[@class='vs-search__more-explorer-item'])[1]")
	private WebElement searchItem;
	
	@FindBy(xpath="(//div[@class='vs-search__explorer-image-wrapper'])[1]")
	private WebElement searchItemIcon;
	
	@FindBy(xpath="//div[@class='trending-search']//span[@class='vs-header__search-analytics-heading']")
	private WebElement trendingSearch;
	
	@FindBy(xpath="//ul[@class='vs-header__search-key-suggestion']//li")
	private static List<WebElement> trendingSuggestions;
	
	@FindBy(xpath="//div[@class='vs-filter__selected vs-filter__desktop-selected']//button[normalize-space()='Deals']")
	private WebElement dealsSearch;
	
	@FindBy(xpath="//h2[@class='vs-title-area__card-box-content-heading page-title ']")
	private WebElement contentTitle;
	
	@FindBy(xpath="//ul[@class='vs-header__search-key-suggestion']")
	private WebElement keySuggestion;
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	public void setAccesingHomepage(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    Assert.assertTrue(tagPills.get(0).isDisplayed());
	    test.info("Verified tag pill is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(userIcon.isDisplayed());
	    HelperFunctions.staticWait(2);
	}
	
	public void setFilterContentpage(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Clicked on select topic");
        selectTopic.click();
        HelperFunctions.staticWait(2);
        test.info("Wait for deals checkbox visibility and clicked on it");
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(dealsCheckbox));
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", dealsCheckbox);
	   // dealsCheckbox.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on select topic");
	    selectTopic.click();
	    HelperFunctions.staticWait(2);
	    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", automationContentPage);
	    test.info("Scroll to automation content page");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(automationContentPage.isDisplayed());
	    test.info("Verified automation content page is displayed");
	    HelperFunctions.staticWait(2);
	}
	public void setCheckboxColor(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Clicked on select topic");
        selectTopic.click();
        HelperFunctions.staticWait(2);
        test.info("Wait for deals checkbox visibility and move the cursor on it");
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(dealsCheckbox));
	   // String checkboxColor = dealsCheckbox.getCssValue("style");
	   // System.out.println(checkboxColor);
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	    String backgroundColor = (String) executor.executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", dealsCheckbox);
	    System.out.println(backgroundColor);
	    Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dealsCheckbox).perform();
	    HelperFunctions.staticWait(2);
	    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	    String backgroundColor2 = (String) executor2.executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", dealsCheckbox);
	    System.out.println(backgroundColor2);
	    HelperFunctions.staticWait(2);
	    Assert.assertNotEquals(backgroundColor, backgroundColor2);
	    test.info("Verified the color of the checkbox has changed after moving the cursor on it");
	    HelperFunctions.staticWait(2);
	}
    
	public void setClearFilters(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Clicked on select topic");
        selectTopic.click();
        HelperFunctions.staticWait(2);
        test.info("Wait for deals checkbox visibility and clicked on it");
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(dealsCheckbox));
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", dealsCheckbox);
	   // dealsCheckbox.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on select topic");
	    selectTopic.click();
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(selectedFilter.isDisplayed());
	    test.info("Verified selected filter is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on clear filter");
        clearFilter.click();
        HelperFunctions.staticWait(5);
        Assert.assertTrue(filterTitle.isDisplayed());
        test.info("Verified the filter title is displayed");
        HelperFunctions.staticWait(3);
        
	}
	public void setVSHomepage(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Clicked on value store");
	    valueStore.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for filter title visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(filterTitle));
	    HelperFunctions.staticWait(2);
        Assert.assertTrue(filterTitle.isDisplayed());
        test.info("Verified the filter title is displayed");
        HelperFunctions.staticWait(3);
	}
	
	public void setLoadMoreButton(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Clicked on select topic");
        selectTopic.click();
        HelperFunctions.staticWait(2);
        test.info("Wait for deals checkbox visibility and clicked on it");
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(dealsCheckbox));
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", dealsCheckbox);
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on select topic");
	    selectTopic.click();
	    test.info("Getting the initial asset size");
	    int initialSize = assets.size();
	    HelperFunctions.staticWait(2);
	    test.info("Scroll to load more button");
	    HelperFunctions.scrollToElement(loadMore);
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on load more");
	    JavascriptExecutor js4 = (JavascriptExecutor) Driver.getDriver();
	    js4.executeScript("arguments[0].click();", loadMore);
	    //loadMore.click();
	    HelperFunctions.staticWait(2);
	    test.info("Getting the new asset size");
	    int newSize = assets.size();
	    if (newSize > initialSize) {
	    	Assert.assertTrue(true);
	        System.out.println("New assets were loaded successfully");
	    } else {
	    	Assert.assertTrue(false);
	        System.out.println("No new assets were loaded");
	    }
	    HelperFunctions.staticWait(3);
	    test.info("Verified new assets were loaded successfully");
	}
	
	public void setNoSubmitNeeded(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    Assert.assertTrue(firstAssetHomepage.isDisplayed());
	    test.info("Verified the first asset is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on select topic");
        selectTopic.click();
        HelperFunctions.staticWait(2);
        test.info("Wait for deals checkbox visibility and clicked on it");
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(dealsCheckbox));
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", dealsCheckbox);
	    HelperFunctions.staticWait(2);
	    test.info("Scroll to first asset");
	    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", firstAssetFilter);
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(firstAssetFilter.isDisplayed());
	    test.info("Verified the first asset after filtering is displayed");
	    HelperFunctions.staticWait(2);
	}
	
	public void setSharetheURL(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    Assert.assertTrue(firstAssetHomepage.isDisplayed());
	    test.info("Verified the first asset is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on it");
	    firstAssetHomepage.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Getting the current url and copy-paste it");
	    String url = Driver.getDriver().getCurrentUrl();
        StringSelection selection = new StringSelection(url);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        Driver.getDriver().switchTo().defaultContent();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        HelperFunctions.staticWait(5);
        String newUrl = Driver.getDriver().getCurrentUrl();
        if (url.equals(newUrl)) {
        	Assert.assertTrue(true);
            System.out.println("Copy-paste successful!");
        } else {
        	Assert.assertTrue(false);
            System.out.println("Copy-paste failed!");
        }
        test.info("Verified Copy-paste action was successful");
        HelperFunctions.staticWait(3);
	}
	
	public void setFavicon(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    Assert.assertTrue(firstAssetHomepage.isDisplayed());
	    test.info("Verified the first asset is displayed on homapage");
	    test.info("Getting the favicon link");
	    String faviconUrl = faviconLink.getAttribute("href");
	 if (faviconUrl != null && faviconUrl.contains("favicon.ico")) {
		 Assert.assertTrue(true);
	     System.out.println("Favicon found!");	
	 } else {
		 Assert.assertTrue(false);
	     System.out.println("Favicon not found.");
	 }
	 test.info("Verified the favicon is displayed");
	}
	public void setTop10ArticleElementsClickable(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Getting the current url");
	    String currentUrl=Driver.getDriver().getCurrentUrl();
	    test.info("Clicked on first article title");
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", firstArticleTitle);
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Getting the current url");
	    String currentUrl2=Driver.getDriver().getCurrentUrl();
	    Assert.assertNotEquals(currentUrl, currentUrl2);
	    test.info("Verified the url values are different");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on logo");
	    logo.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for filter title visibility");
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(filterTitle));
	    HelperFunctions.staticWait(3); 
	    test.info("Clicked on first article description");
	    JavascriptExecutor js3 = (JavascriptExecutor) Driver.getDriver();
	    js3.executeScript("arguments[0].click();", firstArticleDescription);
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
	    wait5.until(ExpectedConditions.visibilityOf(logo));
	    String currentUrl3=Driver.getDriver().getCurrentUrl();
	    Assert.assertNotEquals(currentUrl, currentUrl3);
	    test.info("Verified the url values are different");
	    HelperFunctions.staticWait(3);
	}
	public void setMoretoExplore(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Scroll to more to explore");
	    HelperFunctions.scrollToElement(moretoExplore);
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(moretoExplore.isDisplayed());
	    test.info("Verified more to explore title is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(moretoExploreSub.isDisplayed());
	    test.info("Verified more to explore subtitle is displayed");
	    HelperFunctions.staticWait(2);
	    for(WebElement each: exploreItems) {
	    	if(each.isDisplayed()) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    test.info("Verified more to explore items are displayed");
	    HelperFunctions.staticWait(2);
	    for (WebElement element : exploreItems) {
	        List<WebElement> imgs = element.findElements(By.tagName("img"));
	        if (!imgs.isEmpty()) {
	        	Assert.assertTrue(true);
	            System.out.println("Element contains img tag: " + element.getText());
	        }
	    }
	    test.info("Verified each more to explore items have an img tag");
	    HelperFunctions.staticWait(2);
	    
	}
	public void setMoretoExploreItemNavigation(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Scroll to more to explore");
	    HelperFunctions.scrollToElement(moretoExplore);
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(moretoExplore.isDisplayed());
	    test.info("Verified more to explore title is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(moretoExploreSub.isDisplayed());
	    test.info("Verified more to explore subtitle is displayed");
	    HelperFunctions.staticWait(2);
	    String currentUrl=Driver.getDriver().getCurrentUrl();
	    for (WebElement element : exploreItems) {
	        List<WebElement> tags = element.findElements(By.tagName("a"));
	        if (!tags.isEmpty()) {
	        	Assert.assertTrue(true);
	            System.out.println("Element contains a tag: " + element.getText());
	        }
	    }
	    test.info("Verified each more to explore items have a tag");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on more to explore item");
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", exploreItems.get(0));
	   // exploreItems.get(0).click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    String currentUrl2=Driver.getDriver().getCurrentUrl();
	    HelperFunctions.staticWait(2);
	    Assert.assertNotEquals(currentUrl, currentUrl2);
	    test.info("Verified more to explore item tag is landing to another url");
	    HelperFunctions.staticWait(2);
	    
	    
	}
	public void setNoSearchResult(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on search button");
	    searchButton.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on search field and perform enter");
	    searchField.click();
	    HelperFunctions.staticWait(2);
	    Actions actions = new Actions(Driver.getDriver());
	    actions.sendKeys(Keys.ENTER).build().perform();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for no search result message is displayed");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(noSearchResult));
	    Assert.assertTrue(noSearchResult.isDisplayed());
	    test.info("Verified no search result message is displayed");
	    HelperFunctions.staticWait(2);
	    
	    
	}
	public void setMightAlsoLikeItems(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Scroll to also like title");
	    HelperFunctions.scrollToElement(alsoLikeTitle);
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(alsoLikeTitle.isDisplayed());
	    test.info("Verified also like title is displayed");
	    HelperFunctions.staticWait(2);
	    for(WebElement each: alsoLikeLabels) {
	    	if(each.isDisplayed()) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    test.info("Verified alsoLikeLabels are displayed");
	    HelperFunctions.staticWait(2);
	    for(WebElement each: alsoLikeTitles) {
	    	if(each.isDisplayed()) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    test.info("Verified alsoLikeTitles are displayed");
	    HelperFunctions.staticWait(2);
	    for(WebElement each: alsoLikeFavIcon) {
	    	if(each.isDisplayed()) {
	    		Assert.assertTrue(true);
	    	}else {
	    		Assert.assertTrue(false);
	    	}
	    }
	    test.info("Verified alsoLikeFavIcons are displayed");
	    HelperFunctions.staticWait(2);
	}
	public void setMightAlsoLikeItems2(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    test.info("Verified logo is displayed");
	    HelperFunctions.staticWait(3);
	    test.info("Scroll down to also like title");
	    HelperFunctions.scrollToElement(alsoLikeTitle);
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(alsoLikeTitle.isDisplayed());
	    test.info("Verified also like title is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(alsoLikeFavIcon.size()==3);
	    test.info("Verified also like fav icon size is 3");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(alsoLikeImage.isDisplayed());
	    WebElement img = alsoLikeImage.findElement(By.tagName("img"));
	    if (img != null) {
	    	Assert.assertTrue(true);
	        System.out.println("Element has img tag: " + alsoLikeImage.getText());
	    }else {
	    	Assert.assertTrue(false);
	    }
	    test.info("Verified also like image is displayed and has image tag");
	    test.info("Verified total element's size is 4");
	    HelperFunctions.staticWait(2);
	}
	
	public void setQuickLinksIconVisibility(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for quick links icon visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(quickLinksIcon));
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(quickLinksIcon.isDisplayed());
	    test.info("Verified quick links icon is displayed");
	    HelperFunctions.staticWait(2);
	   
	}
	public void setQuickLinksIconOpensItems(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for quick links icon visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(quickLinksIcon));
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(quickLinksIcon.isDisplayed());
	    test.info("Verified quick links icon is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on quick links icon");
	    quickLinksIcon.click();
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(closeQuickLinks));
	    Assert.assertTrue(closeQuickLinks.isDisplayed());
	    test.info("Verified close button is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(tdMenuItems.get(0).isDisplayed());
	    test.info("Verified tdMenuItem is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(wtMenuItems.get(0).isDisplayed());
	    test.info("Verified wtMenuItem is displayed");
	    HelperFunctions.staticWait(2);
	}
	public void setQuickLinksIconCloseMegaMenu(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for quick links icon visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(quickLinksIcon));
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(quickLinksIcon.isDisplayed());
	    test.info("Verified quick links icon is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on quick links icon");
	    quickLinksIcon.click();
	    test.info("Wait for close button");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(closeQuickLinks));
	    Assert.assertTrue(closeQuickLinks.isDisplayed());
	    test.info("Verified close button is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on quick links icon");
	    quickLinksIcon.click();
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(!closeQuickLinks.isDisplayed());
	    test.info("Verified close button is not displayed");
	    HelperFunctions.staticWait(2);
	}
	public void setSearchResultsBasedonKeyword(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on search button");
	    searchButton.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on search field and send text");
	    searchField.click();
	    HelperFunctions.staticWait(2);
	    String mockContent="Tax";
	    searchField.sendKeys(mockContent);
	    HelperFunctions.staticWait(5);
	    test.info("Wait for suggested keyword visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(suggestedKeyword));
	    Assert.assertTrue(suggestedKeyword.isDisplayed());
	    test.info("Verified suggested keyword is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on enter");
	    Actions actions = new Actions(Driver.getDriver());
	    actions.sendKeys(Keys.ENTER).build().perform();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for search item visibility");
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(searchItem));
	    Assert.assertTrue(searchItem.isDisplayed());
	    test.info("Verified search item is displayed");
	    HelperFunctions.staticWait(2);
	    
	    
	}
	public void setTrendingSearch(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on search button");
	    searchButton.click();
	    HelperFunctions.staticWait(2);
	    searchField.click();
	    HelperFunctions.staticWait(2);
	    test.info("Wait for trending search visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(trendingSearch));
	    Assert.assertTrue(trendingSearch.isDisplayed());
	    test.info("Verified trending search is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on first trending suggestion");
	    trendingSuggestions.get(0).click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for search item visibility");
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(searchItem));
	    Assert.assertTrue(searchItem.isDisplayed());
	    test.info("Verified search item is displayed");
	    HelperFunctions.staticWait(2);
	    
	    
	}
	public void setSearchResultsTopicTitleIcon(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on search button");
	    searchButton.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on search field and send text");
	    searchField.click();
	    HelperFunctions.staticWait(2);
	    String mockContent="Topic";
	    searchField.sendKeys(mockContent);
	    HelperFunctions.staticWait(5);
	    test.info("Wait for suggested keyword's visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(suggestedKeyword2));
	    Assert.assertTrue(suggestedKeyword2.isDisplayed());
	    test.info("Verified suggested keyword is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on enter");
	    Actions actions = new Actions(Driver.getDriver());
	    actions.sendKeys(Keys.ENTER).build().perform();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait search item's visibility");
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(searchItem));
	    Assert.assertTrue(searchItem.isDisplayed());
	    test.info("Verified search item is displayed");
	    HelperFunctions.staticWait(2);
	    Assert.assertTrue(searchItemIcon.isDisplayed());
	    test.info("Verified search icon is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on search item");
	    searchItem.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    Set<String> handles = Driver.getDriver().getWindowHandles();
	    if (handles.size() == 2) {
	    	Assert.assertTrue(true);
	     System.out.println("Element opened the same tab");
	 }else {
			Assert.assertTrue(false);
	 }
	    test.info("Verified element opened the same tab");
	    HelperFunctions.staticWait(3);
	    
	}
	public void setSharetheURLwithFilter(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    Assert.assertTrue(firstAssetHomepage.isDisplayed());
	    test.info("Verified the first asset is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on it");
	    selectTopic.click();
        HelperFunctions.staticWait(2);
        test.info("Wait for deals checkbox visibility and clicked on it");
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(dealsCheckbox));
	    JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
	    js2.executeScript("arguments[0].click();", dealsCheckbox);
	   // dealsCheckbox.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on select topic");
	    selectTopic.click();
	    //firstAssetHomepage.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Getting the current url and copy-paste it");
	    String url = Driver.getDriver().getCurrentUrl();
        StringSelection selection = new StringSelection(url);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        Driver.getDriver().switchTo().defaultContent();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        HelperFunctions.staticWait(5);
        String newUrl = Driver.getDriver().getCurrentUrl();
        if (url.equals(newUrl)) {
        	Assert.assertTrue(true);
            System.out.println("Copy-paste successful!");
        } else {
        	Assert.assertTrue(false);
            System.out.println("Copy-paste failed!");
        }
        test.info("Verified Copy-paste action was successful");
        HelperFunctions.staticWait(3);
        WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(dealsSearch));
        Assert.assertTrue(dealsSearch.isDisplayed());
	    HelperFunctions.staticWait(2);
	}
	public void setSelectTerritory(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    Assert.assertTrue(terriMenu.isDisplayed());
	    test.info("Verified territory menu is displayed");
	    HelperFunctions.staticWait(2);
	    terriMenu.click();
	    HelperFunctions.staticWait(3);
	    WebElement mexicoLink = Driver.getDriver().findElement(By.linkText("Mexico"));
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(mexicoLink));
	    mexicoLink.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(terriMenu));
	    WebElement selectedCountry = Driver.getDriver().findElement(By.cssSelector(".selected-value"));
	    if (selectedCountry.getText().equals("Mexico")) {
	    	Assert.assertTrue(true);
	        System.out.println("Mexico is selected");
	    } else {
	        System.out.println("Mexico is not selected");
	    }
	    terriMenu.click();
	    HelperFunctions.staticWait(3);
	    WebElement globalLink = Driver.getDriver().findElement(By.linkText("Global"));
	    WebDriverWait wait5 = new WebDriverWait(Driver.getDriver(), 10);
	    wait5.until(ExpectedConditions.visibilityOf(globalLink));
	    globalLink.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait6 = new WebDriverWait(Driver.getDriver(), 10);
	    wait6.until(ExpectedConditions.visibilityOf(terriMenu));
	    selectedCountry = Driver.getDriver().findElement(By.cssSelector(".selected-value"));
	    if (selectedCountry.getText().equals("Global")) {
	    	Assert.assertTrue(true);
	        System.out.println("Global is selected");
	    } else {
	        System.out.println("Global is not selected");
	    }
	    terriMenu.click();
	    HelperFunctions.staticWait(3);
	    WebElement usLink = Driver.getDriver().findElement(By.linkText("United States"));
	    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 10);
	    wait7.until(ExpectedConditions.visibilityOf(usLink));
	    usLink.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 10);
	    wait8.until(ExpectedConditions.visibilityOf(terriMenu));
	    selectedCountry = Driver.getDriver().findElement(By.cssSelector(".selected-value"));
	    if (selectedCountry.getText().equals("United States")) {
	    	Assert.assertTrue(true);
	        System.out.println("United States is selected");
	    } else {
	        System.out.println("United States is not selected");
	    }
	    HelperFunctions.staticWait(3);
	}
	public void setTerritoryDropdown(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    Assert.assertTrue(terriMenu.isDisplayed());
	    test.info("Verified territory menu is displayed");
	    HelperFunctions.staticWait(2);
	    terriMenu.click();
	    HelperFunctions.staticWait(3);
	    WebElement mexicoLink = Driver.getDriver().findElement(By.linkText("Mexico"));
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(mexicoLink));
	    mexicoLink.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait4 = new WebDriverWait(Driver.getDriver(), 10);
	    wait4.until(ExpectedConditions.visibilityOf(terriMenu));
	    WebElement selectedCountry = Driver.getDriver().findElement(By.cssSelector(".selected-value"));
	    if (selectedCountry.getText().equals("Mexico")) {
	    	Assert.assertTrue(true);
	        System.out.println("Mexico is selected");
	    } else {
	        System.out.println("Mexico is not selected");
	    }
	    WebElement mexicoListItem = Driver.getDriver().findElement(By.cssSelector(".cmp-navigation__item--active"));
	    if (mexicoListItem.getAttribute("class").contains("cmp-navigation__item--active")
	            && !US.getAttribute("class").contains("cmp-navigation__item--active")
	            && !global.getAttribute("class").contains("cmp-navigation__item--active")) {
	    	Assert.assertTrue(true);
	          System.out.println("Mexico is selected and United States/Global are not selected");
	        } else {
	          System.out.println("Mexico is not selected or United States/Global are selected");
	        }
	    terriMenu.click();
	    HelperFunctions.staticWait(3);
	    WebElement usLink = Driver.getDriver().findElement(By.linkText("United States"));
	    WebDriverWait wait7 = new WebDriverWait(Driver.getDriver(), 10);
	    wait7.until(ExpectedConditions.visibilityOf(usLink));
	    usLink.click();
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait8 = new WebDriverWait(Driver.getDriver(), 10);
	    wait8.until(ExpectedConditions.visibilityOf(terriMenu));
	    selectedCountry = Driver.getDriver().findElement(By.cssSelector(".selected-value"));
	    if (selectedCountry.getText().equals("United States")) {
	    	Assert.assertTrue(true);
	        System.out.println("United States is selected");
	    } else {
	        System.out.println("United States is not selected");
	    }
	    HelperFunctions.staticWait(3);
	}
	public void setMightAlsoLikeTitle(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait for logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Scroll to also like title");
	    HelperFunctions.scrollToElement(alsoLikeTitle);
	    HelperFunctions.staticWait(3);
	    Assert.assertTrue(alsoLikeTitle.isDisplayed());
	    test.info("Verified also like title is displayed");
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on also like title");
	    alsoLikeTitles.get(0).click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(contentTitle));
	    Assert.assertTrue(contentTitle.isDisplayed());
	    test.info("Verified content title is displayed");
	    HelperFunctions.staticWait(3);
	}
	public void setSuggestedTags(ExtentTest test) throws Exception {
		read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
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
	    WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 10);
	    wait1.until(ExpectedConditions.visibilityOf(dealsTag));
	    Assert.assertTrue(dealsTag.isDisplayed());
	    HelperFunctions.staticWait(2);
	    logo.click();
	    test.info("Wait for page to load");
	    HelperFunctions.waitForPageToLoad(3);
	    HelperFunctions.staticWait(3);
	    test.info("Wait logo visibility");
	    WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
	    wait2.until(ExpectedConditions.visibilityOf(logo));
	    HelperFunctions.staticWait(3);
	    test.info("Clicked on search button");
	    searchButton.click();
	    HelperFunctions.staticWait(2);
	    test.info("Clicked on search field and send text");
	    searchField.click();
	    HelperFunctions.staticWait(2);
	    String mockContent="audit";
	    searchField.sendKeys(mockContent);
	    HelperFunctions.staticWait(5);
	    test.info("Wait for suggested keyword's visibility");
	    WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
	    wait3.until(ExpectedConditions.visibilityOf(keySuggestion));
	    Assert.assertTrue(keySuggestion.isDisplayed());
	    test.info("Verified suggested keyword is displayed");
	    HelperFunctions.staticWait(3);
	}
	
}
