package com.pwc.productcentral;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AuthoringPage;
import Pages.ContentPage;
import Pages.GhostedPage;
import Pages.HomePage;
import Pages.LoginPageObjects;
import Pages.TopicLandingPage;




public class SanityTestCases extends HelperFunctions {
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	public static ConfigurationsReader read;
	String platform = null;
	LoginPageObjects lpo=new LoginPageObjects();
	HomePage hp=new HomePage();
	ContentPage cp=new ContentPage();
	GhostedPage gp=new GhostedPage();
	AuthoringPage ap=new AuthoringPage();
	TopicLandingPage tlp=new TopicLandingPage();
	screenshotUtil ssu=new screenshotUtil();
	private ExtentTest test;
	
	
	
	Logger logger=Logger.getLogger("SanityTestCases");
	
	ReadXLSdata read1=new ReadXLSdata();
	
	


	
	@BeforeSuite
	public void setUp() {
		 PropertyConfigurator.configure(".\\log4j.properties");
		 read = new ConfigurationsReader();
		 platform = read.getPlatform();
		 read.platformName();
		 htmlReporter = new ExtentHtmlReporter("Sanity Automation Report for Value Store.html");
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	    
	     
	}
		
	@BeforeMethod
	public void initTest() throws Exception {
	    Driver.getDriver();
	    read1.setExcelFile("./testdata.xlsx", "QA");
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().deleteAllCookies();
		HelperFunctions.setWaitTime();
		
		
	}
	
	
	/*******************************************************Sanity Test Case********************************************************/
	
	@Test(enabled=false)
	public void WEB_1() throws Exception{
		  String testName = "To verify that Page Title should be populated from Page properties and can not be manually authored";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setPageTitle(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_2() throws Exception{
		  String testName = "To verify that at the time of Content page creation mandatory field like Title,"
		  		+ "Published Date etc. should consist of asterisk sign and author will not able to create page without filling these fields.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setMandatoryFields(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}

	@Test(enabled=false)
	public void WEB_3() throws Exception{
		  String testName = "To verify that author can set Primary tags and additional tags.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setPrimaryTags(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_4() throws Exception{
		  String testName = "To verify that author can add multiple lines of text that handles typical styling/formatting like bold, paragraph alignment etc.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setAddingText(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_5() throws Exception{
		  String testName = "To verify that there are two heading titles that can be edited.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setTitleEdit(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName); 
		    }
	}
	@Test(enabled=false)
	public void WEB_6() throws Exception{
		  String testName = "To verify that content area should contain an Interactive component which allows expansion and contraction of Heading Titles by clicking";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setAccordion(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_7() throws Exception{
		  String testName = "To verify that user can see helpful assets like documents or sites that relate to the content he is viewing in this section.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setHelpfulAssets(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_8() throws Exception{
		  String testName = "To verify that user can see helpful assets like documents or sites that relate to the content he is viewing in this section.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setDidYouKnow(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_9() throws Exception{
		  String testName = "To verify that in enablers section for each group there is a group label, item label and item URL.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setEnablers(test);
		        test.pass("Test passed"); 
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_10() throws Exception{
		  String testName = "To verify that  alliances section should contain list of relevant alliances.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setAlliances(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_11() throws Exception{
		  String testName = "To verify that at the time of Content Page Creation author can create page without filling non mandatory field like Description,Hide from Site Search,Revised Date etc";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        gp.setMandatoryFields(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_12() throws Exception{
		  String testName = "To verify that this section should contains list of client examples.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setClientExamples(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_13() throws Exception{
		  String testName = "To verify that this section should contain list of helpful links without groupings focused on relevant campaigns.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setCampaignMaterials(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_14() throws Exception{
		  String testName = "To verify that orange large text is available for stats and author can manually configure it.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3)); 
		        lpo.setLogin();
		        cp.setMarketDemandOrange(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_15() throws Exception{
		  String testName = "To verify that after clicking on external link share model appears .";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3)); 
		        lpo.setLogin();
		        cp.setShareModal(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_16() throws Exception{
		  String testName = "To verify that ghost page template used to target external content.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3)); 
		        lpo.setLogin();
		        gp.setExternalContent(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_17() throws Exception{
		  String testName = "To verify that all other metadata/properties and tags that apply to normal Content pages, also apply to Ghost pages.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        gp.setPrimaryTags(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_18() throws Exception{
		  String testName = "To verify that the Content tags are tag pills/bubbles that are present on the Homepage and Content page.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setTagPillsExist(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_19() throws Exception{
		  String testName = "To verify that there is 'en' page for US territory which is use as placeholder for homepage."+
	"To verify that there is 'es' page for MX territory which is use as placeholder for homepage.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        ap.setTerritory();
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_20() throws Exception{
		  String testName = "To verify that users is able to access published VS pages and see their profile icon.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setAccesingHomepage(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_21() throws Exception{
		  String testName = "To verify that user should see only published content  in filter/search result.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setFilterContentpage(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_22() throws Exception{
		  String testName = "To verify that when the mouse hovers on the filter option, the checkbox is filled with #DB536A.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setCheckboxColor(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_23() throws Exception{
		  String testName = "To verify that user can click on the share icon next to the shareable links.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        cp.setSharableLinks(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_24() throws Exception{
		  String testName = "To verify that user can click on 'Clear filters' to clear all filters.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setClearFilters(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_25() throws Exception{
		  String testName = "To verify that when user clicks on VS Home button, It should reload the homepage.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setVSHomepage(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}

	@Test(enabled=false)
	public void WEB_26() throws Exception{
		  String testName = "To verify that hover effect on the 'Load more' button as per design.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setLoadMoreButton(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_27() throws Exception{
		  String testName = "To verify that once the filter is selected, the Top 10 section will be refreshed with the articles in real-time (no submit button required).";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setNoSubmitNeeded(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_28() throws Exception{
		  String testName = "To verify that user should be able to apply filters on the homepage Top 10, copy the page link and share it with another user.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setSharetheURL(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_29() throws Exception{
		  String testName = "To verify that the user can see a Value Store favicon in his browser.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setFavicon(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_30() throws Exception{
		  String testName = "To verify that the Top 10 article title & description are clickable to open the page.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setTop10ArticleElementsClickable(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_31() throws Exception{
		  String testName = "To verify that user can see the explore section on the homepage that navigates to the Topic landing page.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setMoretoExplore(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_32() throws Exception{
		  String testName = "To verify that clicking on the Topic title or topic icon to navigate to the landing page.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setMoretoExplore(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_33() throws Exception{
		  String testName = "Verify that, user cannot perform a search without any keywords";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setNoSearchResult(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_34() throws Exception{
		  String testName = "To verify that ( You might also like) article card display Topic label, article title and favorite icon on the card.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setMightAlsoLikeItems(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_35() throws Exception{
		  String testName = "To verify that Homepage \"You might also like\" section displays 4 elements.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setMightAlsoLikeItems2(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_36() throws Exception{
		  String testName = "To verify that quick links icon present at the global header.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setQuickLinksIconVisibility(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_37() throws Exception{
		  String testName = "To verify that user can click on the quick link title to open the item.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setQuickLinksIconOpensItems(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_38() throws Exception{
		  String testName = "To verify that the mega menu will close when the user clicks the quick links icon again.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setQuickLinksIconCloseMegaMenu(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_39() throws Exception{
		  String testName = "Verify that, system should look at the content title and the tags to find suggested terms that match against user’s keyword.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setSearchResultsBasedonKeyword(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_40() throws Exception{
		  String testName = "To verify that, Users can click on a trending term to trigger the search directly and will be presented with the search results page";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setTrendingSearch(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_41() throws Exception{
		  String testName = "Verify that, clicking the topic landing title or icon should open the page in the current window  ";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setSearchResultsTopicTitleIcon(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_42() throws Exception{
		  String testName = "To verify that the Key asset bar is an optional component that is manually authored by the author if relevant assets are available for the topic";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setKeyAssetBar(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_43() throws Exception{
		  String testName = "To verify that the Hot topics component is a manually authored section.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setHotTopics(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_44() throws Exception{
		  String testName = "To verify that Key asset bar displays up to 4 assets that are pointing to the URLs.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setKeyAssetBar4articles(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_45() throws Exception{
		  String testName = "To verify that Hot topics component displays up to 4 articles that are configured by the author.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setHotTopics4articles(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_46() throws Exception{
		  String testName = "To verify that the \"Back to topic page\" button should be presented on the content page if a user opened a page from a topic landing page.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setBacktoTopicandTopicsSize(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_47() throws Exception{
		  String testName = "To verify that the user can click on the feed article title or description to open the article";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setFeedTopics(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_48() throws Exception{
		  String testName = "To verify that the user who receives the link and opens the link should be brought to the homepage with the pre-filtered results.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        hp.setSharetheURLwithFilter(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	@Test(enabled=false)
	public void WEB_49() throws Exception{
		  String testName = "To verify that \"Hot topic\" article should open in the current tab if it's internal VS content.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setHotTopicSameTab(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	@Test(enabled=false)
	public void WEB_50() throws Exception{
		  String testName = "To verify that feed component on the topic landing page is system populated based on the primary topic tag selected and brings published content that reflects the tag value.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 3));
		        lpo.setLogin();
		        tlp.setFeedTopicsTagValue(test);
		        test.pass("Test passed");  
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail("Test failed: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	/******************************************************************************************************************************/
	
	public String takeScreenshot(String screenshotName) throws IOException {
	    WebDriver driver = Driver.getDriver();
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = "screenshots/" + screenshotName + ".png";
	    File target = new File(destination);
	    FileUtils.copyFile(source, target);
	    return destination;
	}
	public void captureScreenshotAndAddToReport(String testName) throws IOException {
		 String screenshotPath = takeScreenshot(testName);
		 ExtentTest test = extent.createTest(testName).pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	@AfterMethod
    public void closeTabs() {
        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
            	Driver.getDriver().switchTo().window(window);
            	Driver.getDriver().close();
            }
        }
        Driver.getDriver().switchTo().window(currentWindow);
         }
	public void tearDown(ITestResult result) throws IOException {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        // Take screenshot if test method fails
	        String screenshotPath = takeScreenshot(result.getName() + "_failed");
	        test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        // Take screenshot if test method passes
	        String screenshotPath = takeScreenshot(result.getName() + "_passed");
	        test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    extent.flush();
	}
      @AfterSuite
	public void closingBrowser() {
		extent.flush();
		//Driver.closeDriver();
	}
	
	


	

}