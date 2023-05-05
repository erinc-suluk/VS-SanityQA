package com.pwc.productcentral;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AuthoringPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.HomePageTemplatePage;
import Pages.LegalPage;
import Pages.LoginPageObjects;

import Pages.ProductListingPage;
import Pages.ProductPage;
import Pages.ResellerPage;
import Pages.SecurityPage;
import Pages.UMSPage;


public class SanityTestCases extends BasePage {
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	public static ConfigurationsReader read;
	String platform = null;
	LoginPageObjects lpo=new LoginPageObjects();
	HomePage hp=new HomePage();
	ProductListingPage plp=new ProductListingPage();
	HomePageTemplatePage hpt=new HomePageTemplatePage();
	ResellerPage rp=new ResellerPage();
	LegalPage lp=new LegalPage();
	SecurityPage sp=new SecurityPage();
	ProductPage pp=new ProductPage();
	AuthoringPage ap=new AuthoringPage();
	UMSPage ums=new UMSPage();
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
		 htmlReporter = new ExtentHtmlReporter("Sanity Automation Report for Product Central.html");
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	    
	     
	}
		
	@BeforeMethod
	public void initTest() throws Exception {
	    Driver.getDriver();
	    read1.setExcelFile("./testdata.xlsx", "PRO");
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().deleteAllCookies();
		HelperFunctions.setWaitTime();
		
		
	}
	
	
	/*******************************************************Sanity Test Case********************************************************/
	
	
	@Test(enabled=false)
	public void WEB_1() throws Exception{
		  String testName = "Verify the promotion banner must contain an image";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 2));
		        hp.setImage();
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
		  String testName = "Verify the promotion banner must contain a description  'PwC's home for information on legal terms & conditions, security, and compliance for our licensed products.'";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 2));
		        hp.setDescriptionOfBanner();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
	
	}
	
	@Test(enabled=false)
	public void WEB_3() throws Exception{
		 String testName = "Verify the promotion banner is visible to all users on homepage";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 2));
		        hp.setPromotionBanner();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test (enabled=false)
	public void WEB_4() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 4));
		ExtentTest test = extent.createTest("Verify related links are visible to all users on content page");
	    test.info("Related links are visible to all users on content page");
	    plp.setAllLinks();
		logger.info("Test WEB_4 has passed");
		  	   
	}
	@Test(enabled=false)
	public void WEB_5() throws Exception{
		 String testName = "Verify that user is able to click the breadcrumb and navigate to the previous page(Products Page)";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 4));
		        plp.setBreadcrumbs();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	
	}
	@Test(enabled=false)
	public void WEB_5_2() throws Exception{
		 String testName = "Verify that user is able to click the breadcrumb and navigate to the previous page(Legal Page)";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 9));
		        lp.setlegalTiles();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_6() throws Exception{
		 String testName = "Verify that breadcrumb contains a link";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 4));
		        plp.setBreadcrumbs();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	
	@Test
	public void WEB_6_1() throws Exception{
		 String testName = "Verify that breadcrumb contains a link";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 4));
		        plp.setDownloadFullTermsLink();
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test(enabled=false)
	public void WEB_7() throws Exception{
		String testName = "Verify the user is able to view the page title and description";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setTitleAndDescription();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test(enabled=false)
	public void WEB_8() throws Exception{
		String testName = "Verify the user is able to view the related links and content";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 4));
	        plp.setAllLinks();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test(enabled=false)
	public void WEB_9() throws Exception{
		String testName = "Verify each link represents the content page for the product";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 4));
	        plp.setLinks();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}

	
	@Test (enabled=false)
	public void WEB_10() throws Exception{
		String testName = "Verify description can only be a maximum of 6 lines, anything more than that will be truncated";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setDescriptionOfTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test (enabled=false)
	public void WEB_11() throws Exception{
		String testName = "Verify homepage tile is visible to all users on homepage";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.sethomePageTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test(enabled=false)
	public void WEB_12() throws Exception{
		String testName = "Verify PDF viewer/controls appear at  the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 4));
	        plp.setPdfControllers();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test(enabled=false)
	public void WEB_13() throws Exception{
		String testName = "Verify that when left navigation collapsed,only the collapsed icon will be displayed and on hover over the icon will say 'collapse'";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        BasePage.setCollapseButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}

	
	@Test(enabled=false)
	public void WEB_14() throws Exception{
		String testName = "Verify left navigation component is visible to user";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        BasePage.setLeftNavigationItems2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test(enabled=false)
	public void WEB_15() throws Exception{
		String testName = "Verify that when user clicks on the tile then user navigate to a hyperlink page within the tab";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setLegalTile();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test (enabled=false)
	public void WEB_16() throws Exception{
		String testName = "Verify that each tile will contain a title";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setTitleOfTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test (enabled=false)
	public void WEB_17() throws Exception{
		String testName = "Verify that title is like 'One stop shop, for all your Product needs' as per pre defined";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setOneStopTitle();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	@Test(enabled=false)
	public void WEB_18() throws Exception{
		String testName = "Verify the footer section size style and design should be fixed and cannot be editable";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        BasePage.setFooterHome();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	@Test (enabled=false)
	public void WEB_19() throws Exception{
		String testName = "Verify the no spelling mistake for the text on the footer section";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        BasePage.setHomePageTemplateElements();
		    BasePage.setFooterTextandPosition();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test (enabled=false)
	public void WEB_20() throws Exception{
		String testName = "Verify the position of the footer";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        BasePage.setFooterTextandPosition();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test(enabled=false)
	public void WEB_21() throws Exception{
		String testName = "Verify that flow is same in legal for security";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 11));
	        sp.setSecurityTiles();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	   
	}
	
	@Test (enabled=false)
	public void WEB_22() throws Exception{
		String testName = "Verify on click of a search results the user will be navigated to the content type";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setSearchButton();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test (enabled=false)
	public void WEB_23() throws Exception{
		String testName = "Verify on selection, the results are automatically sorted";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 2));
	        hp.setSortedResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test (enabled=false)
	public void WEB_24() throws Exception{
		String testName = "Verify that on selection a result, display the relevant product on the page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setSearchBox();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	
	@Test(enabled=false)
	public void WEB_25() throws Exception{
		String testName = "Verify that search results are based on keywords";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 6));
	        plp.setSearchResult();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	
	}
	
	@Test (enabled=false)
	public void WEB_26() throws Exception{
		String testName = "Verify that no change to the home page or side nav";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 11));
	        BasePage.setLeftNavigationItems2();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test(enabled=false)
	public void WEB_27() throws Exception{
		String testName = "Verify the filter will be a dropdown which will display the My products document categories matching the search results";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 11));
	        hp.setDropdown();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
		
	}
	
	
	@Test (enabled=false)
	public void WEB_28() throws Exception{
		String testName = "Verify the doc categories will be based on Taxonomy document";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 13));
	        ap.setDocCategory();
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test(enabled=false)
	public void WEB_29() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that message shown is 403: You do not have access to this page.Please contact our support team for further assistance.(Link to service now where user can submit a ticket)");
	    test.info("Verified that message shown is 403: You do not have access to this page.Please contact our support team for further assistance. (Link to service now where user can submit a ticket)");
	    lpo.setLogin();
	    pp.setErrorMessage();
	    logger.info("Test WEB_29 has passed");
	}
	
	
	@Test (enabled=false)
	public void WEB_30() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify that dropdown list will display the Product & document category as per the latest Tag taxonomy document");
	    test.info("The dropdown list displays the Product & document category as per the latest Tag taxonomy document");
	    hp.setDropdownList();
	    hp.setDropdownList2();
	    logger.info("Test WEB_30 has passed");  
	}
	
	@Test(enabled=false)
	public void WEB_31() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the user should see different footer items if logged in");
	    test.info("The user does not see footer link group if logged in");
	    pp.setFooterWithoutLogin();
	    logger.info("Test WEB_31 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_31_1() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the user should see different footer items if logged in");
	    test.info("The user sees footer link group if logged in");
	    lpo.setLogin();
	    pp.setFooterWithLogin();
	    logger.info("Test WEB_31_1 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_32() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify when the user clicks on next will display the next 5 assets of my product landing page");
	    test.info("When the user clicks on next,the next 5 assets of my product landing page are displayed");
	    lpo.setLogin();
	    pp.setDisplayResources();
	    logger.info("Test WEB_32 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_33() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify when the user clicks on any item the specified asset/page must be loaded in the new tab");
	    test.info("When the user clicks on any item the specified asset/page is loaded in the new tab");
	    lpo.setLogin();
	    pp.setNewTabAssets();
	    logger.info("Test WEB_33 has passed");
	}
	
	
	
	@Test(enabled=false)
	public void WEB_34() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify if user is logged in, then My Products heading in the sitemap is visible");
	    test.info("When user is logged in,My Products heading in the sitemap is visible");
	    lpo.setLogin();
	    pp.setMyProductSitemap();
	    logger.info("Test WEB_34 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_35() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the tags accompany the items which are assets");
	    test.info("Verified the tags accompany the items which are assets");
	    lpo.setLogin();
	    pp.setTagsAccompany();
	    logger.info("Test WEB_35 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_36() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that this page should appear to all Site Visitors that are logged in but do not have the right level of permissions to access the page");
	    test.info("Verified that this page should appear to all Site Visitors that are logged in but do not have the right level of permissions to access the page)");
	    lpo.setLogin();
	    pp.setErrorPage();
	    logger.info("Test WEB_36 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_37() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify there are 2 filters with minor differences between Global and My Products search");
	    test.info("Verified there are 2 filters with minor differences between Global and My Products search");
	    lpo.setLogin();
	    pp.setMyProductSearch();
	    logger.info("Test WEB_37 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_38() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the all resources component is presenting a list of 5 assets that are relevant to the product on the product landing page");
	    test.info("Verified the all resources component is presenting a list of 5 assets that are relevant to the product on the product landing page");
	    lpo.setLogin();
	    pp.setResourcesBasedonProducts();
	    logger.info("Test WEB_38 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_39() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("Verify that page title is visible on page and it displays the name of the product");
	    test.info("Verified that page title is visible on page and it displays the name of the product");
	    rp.setPageTitleAndProducts();
	    logger.info("Test WEB_39 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_40() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("Verify that breadcrumb will contain a link of the previous page of the site and must respect the UI design");
	    test.info("The breadcrumb contains a link of the previous page of the site and respect the UI design");
	  //  test.log(Status.INFO, ""+test.addScreenCaptureFromPath(captureScreen()));
	    rp.setBreadcrumbs();
	    logger.info("Test WEB_40 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_41() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify the content pages will be tagged accordingly");
	    test.info("Verified the content pages are tagged accordingly");
	    lp.setContentPageTags(); 
	    logger.info("Test WEB_41 has passed");
	}
	
	
	
	@Test (enabled=false)
	public void WEB_42() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 42));
		ExtentTest test = extent.createTest("Verify document tile can have 3 lines of description");
	    test.info("Verified document tiles have 3 lines of description");
	    lp.setDescriptionOfTiles();
	    logger.info("Test WEB_42 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_43() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 42));
		ExtentTest test = extent.createTest("Verify display a tile per document category");
	    test.info("Verified display a tile per document category");
	    lp.setDisplayTilePerDocumentCat();
	    logger.info("Test WEB_43 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_44() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 14));
		ExtentTest test = extent.createTest("Verify that user entered keyword remains into search bar either user select suggested product name or not & submitted keyword doesn't match any result");
	    test.info("Verified that user entered keyword remains into search bar either user select suggested product name or not & submitted keyword doesn't match any result");
	    plp.setSearchBarKeywordforNegativeTest();
	    logger.info("Test WEB_44 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_45() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Breadcrumb must be visible to user");
	    test.info("Verified breadcrumb is be visible to user");
	    lp.setBreadcrumb();
	    logger.info("Test WEB_45 has passed");
	}
	
	@Test  (enabled=false)
	public void WEB_46() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("Verify document tile can have only 2 line product name, anything more than that will be truncated(fit to size)");
	    test.fail("Document tile can have 3 line product name");
	//    test.log(Status.INFO, ""+test.addScreenCaptureFromPath(captureScreen()));
	    plp.setDocumentTileLine();
	    logger.error("Test WEB_46 has failed");
	}
	
	@Test (enabled=false)
	public void WEB_47() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 6));
		ExtentTest test = extent.createTest("Verify clicking on the tile will navigate the user to the content page in the same tab");
	    test.info("Verified clicking on the tile navigates the user to the content page in the same tab");
	    plp.setContentPageSameTab();
	    logger.info("Test WEB_47 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_48() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify if the user is already logged in don't display 'log in to my products' link");
	    test.info("Verified if the user is already logged in don't display 'log in to my products' link");
	    ap.setDisplayingLogintomyProductLink();
	    logger.info("Test WEB_48 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_49() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 15));
		ExtentTest test = extent.createTest("Verify on clicking 'login to my products' tile the user is navigated to the PC login page");
	    test.info("Verified on clicking 'login to my products' tile the user is navigated to the PC login page");
	    hp.setLoginToMyProductLink();
	    logger.info("Test WEB_49 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_50() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the hyperlinks in the component will be populated by the system(both title & URL)");
	    test.info("Verified the hyperlinks in the component will be populated by the system(both title & URL)");
		ap.setHyperlinks();
		logger.info("Test WEB_50 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_51() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the filter does not support multi-select");
	    test.info("Verified the filter does not support multi-select");
	    lpo.setLogin();
	    pp.setNotSupportMultiSelect();
	    logger.info("Test WEB_51 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_52() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 14));
		ExtentTest test = extent.createTest("Verify the product listing page does not have broken images");
	    test.fail("The product listing page has broken images");
	  //  test.log(Status.FAIL, ""+test.addScreenCaptureFromPath(captureScreen()));
	    BasePage.setAllImages();
	    logger.info("Test WEB_42 has failed");
	}
	@Test(enabled=false)
	public void WEB_52_1() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify the home page does not have broken images");
	    test.info("Verified the home page does not have broken images");
	  //  test.log(Status.PASS, ""+test.addScreenCaptureFromPath(captureScreen()));
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_1 has passed");
	}
	@Test (enabled=false)
	public void WEB_52_2() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 8));
		ExtentTest test = extent.createTest("Verify the reseller page does not have broken images");
	    test.info("Verified the reseller does not have broken images");
	 //   test.log(Status.PASS, ""+test.addScreenCaptureFromPath(captureScreen()));
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_2 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_52_3() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 9));
		ExtentTest test = extent.createTest("Verify the legal page does not have broken images");
	    test.info("Verified the legal does not have broken images");
	 //   test.log(Status.PASS, ""+test.addScreenCaptureFromPath(captureScreen()));
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_3 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_52_4() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 11));
		ExtentTest test = extent.createTest("Verify the security page does not have broken images");
	    test.info("Verified the security does not have broken images");
	 //   test.log(Status.PASS, ""+test.addScreenCaptureFromPath(captureScreen()));
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_4 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_52_5() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the my product page does not have broken images");
	    test.info("Verified the my product page does not have broken images");
	    lpo.setLogin();
	 //   test.log(Status.PASS, ""+test.addScreenCaptureFromPath(captureScreen()));
	    BasePage.setAllImages();
	    logger.info("Test WEB_52_5 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_53() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify on click on load more, another 5 assets must be loaded");
	    test.info("Verified on click on load more, another 5 assets are loaded");
	    lpo.setLogin();
	    pp.setLoadMoreButton();
	    logger.info("Test WEB_53 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_54() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the assets title cannot be more than 3 lines");
	    test.fail("Verified the assets title cannot be more than 3 lines");
	    lpo.setLogin();
	 //   test.log(Status.INFO, ""+test.addScreenCaptureFromPath(captureScreen()));
	    pp.setTitleOfAssets();
	    logger.info("Test WEB_54 has failed");
	}
	
	
	@Test(enabled=false)
	public void WEB_55() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the user is able to click on load more button");
	    test.info("Verified the user is able to click on load more button");
	    lpo.setLogin();
	    pp.setClickLoadMoreButton();
	    logger.info("Test WEB_55 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_56() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify clicking on view less will revert this section to its original state with 5 tiles");
	    test.info("Verified clicking on view less reverts this section to its original state with 5 tiles");
	    lpo.setLogin();
	    pp.setClickLoadLessButton();
	    logger.info("Test WEB_56 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_57() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify active tab will be underlined");
	    test.info("Verified active tab is underlined ");
	    lpo.setLogin();
	    pp.setActiveTab();
	    logger.info("Test WEB_57 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_58() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify by default the first tab will be active when the user landing on the page");
	    test.fail("Not Verified by default the first tab is active when the user landing on the page");
	    lpo.setLogin();
	 //   test.log(Status.INFO, ""+test.addScreenCaptureFromPath(captureScreen()));
	    pp.setFirstTabActive();
	    logger.info("Test WEB_58 has failed");
	}
	
	@Test (enabled=false)
	public void WEB_59() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify hero promotion card is static, not clickable");
	    test.info("Verified hero promotion card is static, not clickable");
	    lpo.setLogin();
	    pp.setHeroPromotion();
	    logger.info("Test WEB_59 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_60() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify an image can be an image pattern");
	    test.info("Verified an image can be an image pattern");
	    lpo.setLogin();
	    BasePage.setAllImages();
	    logger.info("Test WEB_60 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_61() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify author is able to author the site map will all the links");
	    test.info("Verified author is able to author the site map will all the links");
	    ap.setSitemap();
	    logger.info("Test WEB_61 has passed"); 
	}
	
	@Test (enabled=false)
	public void WEB_62() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify author is able to hide pages from displaying within the site map");
	    test.info("Verified author is able to hide pages from displaying within the site map");
	    ap.setHideSitemap();
	    logger.info("Test WEB_62 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_63() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify tiles are partially authorable");
	    test.info("Verified tiles are partially authorable");
	    ap.setTilesAuthorization();
	    logger.info("Test WEB_63 has passed");
	}
	

	@Test(enabled=false)
	public void WEB_64() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that not all products will have all categories listed on the page but some will have a combination of them");
	    test.info("Verified that not all products will have all categories listed on the page but some will have a combination of them");
	    ap.setCatCombination();
	    logger.info("Test WEB_64 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_65() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify last updated date will be pulled from asset metadata");
	    test.info("Verified last updated date is pulled from asset metadata");
	    ap.setUpdatedDateFromAssets();
	    logger.info("Test WEB_65 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_66() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify last updated date will also be reflected under the title");
	    test.info("Verified last updated date is also be reflected under the title");
	    ap.setUpdatedDateVisibility();
	    logger.info("Test WEB_66 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_67() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify homepage tile component is system authored");
	    test.info("Verified homepage tile component is system authored");
	    ap.setHomepageTileAuthorization();
	    logger.info("Test WEB_67 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_68() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 2));
		ExtentTest test = extent.createTest("Verify that the value of the filters are based on the tags/properties of the search results");
	    test.info("The value of the filters are NOT based on the tags/properties of the search results");
	//    test.log(Status.PASS, ""+test.addScreenCaptureFromPath(captureScreen()));
	    hp.setSearchResult();
	    logger.info("Test WEB_68 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_69() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify unpublish workflow is available both sites and assets");
	    test.info("Verified unpublish workflow is available both sites and assets");
	    ap.setUnpublishWorkflow();
	    logger.info("Test WEB_69 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_70() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify that once content is approved and published, the system will record the date of publishing");
	    test.info("Verified that once content is approved and published, the system will record the date of publishing");
	    ap.setUpdatedDate();
	    logger.info("Test WEB_70 has passed");
	}
	

	@Test (enabled=false)
	public void WEB_71() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the author is able to author the title and the description");
	    test.info("Verified the author is able to author the title and the description");
	    ap.setContentAuthorization();
	    logger.info("Test WEB_71 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_72() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify users icons must present User's First and Last name initials of user");
	    test.fail("Verified users icons present User's First and Last name initials of user");
	    lpo.setLogin();
	    pp.setUserInitials();
	    logger.info("Test WEB_72 has failed");
	}
	
	@Test (enabled=false)
	public void WEB_73() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify all the sections on the header");
	    test.info("Verified all the sections on the header");
	    lpo.setLogin();
	    BasePage.setAllSectionsOnHeader();
	    logger.info("Test WEB_73 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_74() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the scroll functionality");
	    test.info("Verified the scroll functionality");
	    lpo.setLogin();
	    BasePage.setScrollFunctionality();
	    logger.info("Test WEB_74 has passed");
	}
	@Test(enabled=false)
	public void WEB_75() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify responsiveness of page");
	    test.info("Verified responsiveness of page");
	    lpo.setLogin();
	    BasePage.setResponsivenessOfPages();
	    logger.info("Test WEB_75 has passed");
	}
	@Test (enabled=false)
	public void WEB_76() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the release notes must be able to manually authored");
	    test.info("Verified the release notes must be able to manually authored");
	    ap.setReleaseNotes();
	    logger.info("Test WEB_76 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_77() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify clicking on the tab will display the product page where they can see more information about the product.");
	    test.info("Verified clicking on the tab will display the product page where they see more information about the product.");
	    lpo.setLogin();
	    pp.setInfoOfProducts();
	    logger.info("Test WEB_77 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_78() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the error message position");
	    test.info("Verified the error message position");
	    ums.setErrorMessages();
	    logger.info("Test WEB_78 has passed");
	}
	

	@Test (enabled=false)
	public void WEB_79() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify users can be assigned to one product or multiple products");
	    test.info("Verified users can be assigned to one product or multiple products");
	    ums.setAssigningMultipleProducts();
	    logger.info("Test WEB_79 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_80() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify users can be assigned to one product or multiple products");
	    test.info("Verified users can be assigned to one product or multiple products");
	    ums.setAdminForMultipleCompanies();
	    logger.info("Test WEB_80 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_81() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify if the user selects role as Admin, then by default the user gets admin rights to all products in the company");
	    test.info("Verified if the user selects role as Admin, then by default the user gets admin rights to all products in the company");
	    ums.setAdminRights();
	    logger.info("Test WEB_80 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_82() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the user must be able to manually author the footer");
	    test.info("Verified the user must be able to manually author the footer");
	    ap.setAuthFooter();
	    logger.info("Test WEB_82 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_83() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the need technical support is responsible for providing user the technical support by navigating them to client view");
	    test.info("Verified the need technical support is responsible for providing user the technical support by navigating them to client view");
	    lpo.setLogin();
	    pp.setTechnicalSupport();
	    logger.info("Test WEB_83 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_84() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify the related product is responsible for displaying products which the user has access to");
	    test.info("Verified the related product is responsible for displaying products which the user has access to");
	    lpo.setLogin();
	    pp.setRelatedProducts();
	    logger.info("Test WEB_84 has passed");
	}
	
	@Test(enabled=false)
	public void WEB_85() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify for you is responsible for displaying content as per the users licence");
	    test.info("Verified for you is responsible for displaying content as per the users licence");
	    ums.setDisplayingContentBasedOnLicence();
	    logger.info("Test WEB_85 has passed");
	}
	
	@Test (enabled=false)
	public void WEB_86() throws Exception{
		Driver.getDriver().get(read1.getCellData("VALUE", 13));
		ExtentTest test = extent.createTest("Verify all resources is dedicated to all applicable product-content specific items");
	    test.info("Verified all resources is dedicated to all applicable product-content specific items");
	    lpo.setLogin();
	    pp.setAllResourcesContent();
	    logger.info("Test WEB_86 has passed");
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