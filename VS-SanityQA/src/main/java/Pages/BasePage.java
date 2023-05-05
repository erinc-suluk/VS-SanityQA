package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;

public class BasePage extends HelperFunctions {
	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
		} 
	
	@FindBy(id="initEmail")
	private static WebElement email;
	
	@FindBy(className="a-btn a-btn-primary a-btn-xl")
	private static WebElement nextButton;
	
	@FindBy(className="a-text-input a-input-lg ng-pristine ng-invalid ng-touched")
	private static WebElement password;
	
	@FindBy(className="a-btn a-btn-primary a-btn-xl mt-4 submit-btn")
	private static WebElement submitButton;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private static WebElement footer;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/static-assets/pwc-final-logo.svg']")
	private static WebElement logo;
	
	@FindBy(xpath="//button[@id='searchButtonHeader']")
	private static WebElement search;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private static WebElement footerHome;
	
	@FindBy(xpath="//div[@class='cmp-leftnavigation__items']//a")
	private static List<WebElement> leftNavigationItems2;
	
	@FindBy(xpath="//div[@class='cmp-leftnavigation__items']//span")
	private static List<WebElement> leftNavigationItems;
	
	@FindBy(xpath="//a[@href='#collapseNavBtn']")
	private static WebElement collapseButton;
	
	@FindBy(xpath="//span[@class='ap-icon icon-enter-left-outline']")
	private static WebElement expandButton;
	
	@FindBy(tagName="img")
	private static List<WebElement> productsListImages;
	
	@FindBy(tagName="a")
	private static List<WebElement> alltags;
	
	@FindBy(xpath="//span[@class='cmp-header__cta-avatar-initials']")
	private static WebElement userInitials;
	
	@FindBy(xpath="//a[@href='/us/en/legal.html']")
	private static WebElement legalLink;
	
	@FindBy(xpath="//a[@href='/us/en/products.html']")
	private static WebElement productsLink;
	
	@FindBy(xpath="//a[@href='/us/en/security.html']")
	private static WebElement securityLink;
	
	@FindBy(xpath="//a[@href='/us/en/compliance.html']")
	private static WebElement complianceLink;
	
	@FindBy(xpath="//a[@href='/us/en/privacy0.html']")
	private static WebElement privacyLink;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private static WebElement myProductsTitle;
	
	
	
	static Logger logger=Logger.getLogger("BasePage");
	
	
	
	
	
	public static void setHomePageTemplateElements() throws Exception {
		
		if(footer.isDisplayed() && logo.isDisplayed() && search.isDisplayed()) {
			Assert.assertTrue(true);//
		}else {
			 String errorMessage = "Missing Home Page Template Elements";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		//	Assert.assertTrue(false);
		}
	}
	
	public static void setFooterTextandPosition() {
		String actualFooterText=footer.getText();
		String expectedFooterText="© 2023 PwC. All rights reserved. PwC refers to the US member firm of the PwC network or one of its subsidiaries or affiliates.";
		System.out.println(actualFooterText);
		Assert.assertEquals(actualFooterText, expectedFooterText);
		Point locationOfFooter=footer.getLocation();
		int x = locationOfFooter.getX();
		int y = locationOfFooter.getY();
		Assert.assertTrue(x >= 0 && y >= 0);
	}
	
public static void setFooterHome() throws Exception {
	String actualColor = footerHome.getCssValue("color");
	String actualHexCodeForColor = Color.fromString(actualColor).asHex();
	String expectedColor="rgba(37, 37, 37, 1)";
	String expectedHexCodeForColor="#252525";
	
	System.out.println(actualColor);
	System.out.println(actualHexCodeForColor);
	
	
	
	if(footerHome.getCssValue("font-size").equals("16px") && footerHome.getCssValue("font-family").equals("\"PwC Helvetica Neue\"") && actualColor.equals(expectedColor)&&
			actualHexCodeForColor.equals(expectedHexCodeForColor)) {
		 String successMessage = "The footer section size style and design are fixed";
	        logger.info(successMessage);
		Assert.assertTrue(true);
	}else {
		 String errorMessage = "The footer section size style and design are not fixed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
	//	Assert.assertTrue(false);
	}
	
	
    
	
	}
public static void setLeftNavigationItems2() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	for(WebElement items:leftNavigationItems2) {
		if(!items.isDisplayed()) {
			 String errorMessage = "Changing to the home page or side nave";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		
		}else {
			 String successMessage = "No change to the home page or side nave";
		        logger.info(successMessage);
		        Assert.assertTrue(true);
		//	Assert.assertTrue(false);
		} 
	
	}
	legalLink.click();
	HelperFunctions.waitForPageToLoad(5);
	for(WebElement items:leftNavigationItems2) {
		if(items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
			logger.error("Left Navigation is not visible on Legal Page");
		}}
	productsLink.click();
	HelperFunctions.waitForPageToLoad(5);
	for(WebElement items:leftNavigationItems2) {
		if(items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
			logger.error("Left Navigation is not visible on Product Listing Page");
		}}
	securityLink.click();
	HelperFunctions.waitForPageToLoad(5);
	for(WebElement items:leftNavigationItems2) {
		if(items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
			logger.error("Left Navigation is not visible on Security Page");
		}}
	complianceLink.click();
	for(WebElement items:leftNavigationItems2) {
		if(items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
			logger.error("Left Navigation is not visible on Compliance Page");
		}}
	privacyLink.click();
	for(WebElement items:leftNavigationItems2) {
		if(items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
			logger.error("Left Navigation is not visible on Privacy Page");
		}}
	
	
	
		

}
public static void setCollapseButton() throws Exception {
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
     executor.executeScript("arguments[0].click();", collapseButton);
	for(WebElement items:leftNavigationItems) {
		if(!items.isDisplayed()) {
			String successMessage = "The navigation Items are displayed";
	        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			 String errorMessage = "The navigation Items are not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		}
	}
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
     executor2.executeScript("arguments[0].click();", expandButton);
	for(WebElement items:leftNavigationItems) {
		if(items.isDisplayed()&& collapseButton.isDisplayed()) {
			String successMessage = "The navigation Items are displayed";
	        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
		
		}
	}
	HelperFunctions.staticWait(3);
	legalLink.click();
	HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
    executor3.executeScript("arguments[0].click();", collapseButton);
	for(WebElement items:leftNavigationItems) {
		if(!items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
    executor4.executeScript("arguments[0].click();", expandButton);
	for(WebElement items:leftNavigationItems) {
		if(items.isDisplayed()&& collapseButton.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	productsLink.click();
	HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
    executor5.executeScript("arguments[0].click();", collapseButton);
	for(WebElement items:leftNavigationItems) {
		if(!items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
    executor6.executeScript("arguments[0].click();", expandButton);
	for(WebElement items:leftNavigationItems) {
		if(items.isDisplayed()&& collapseButton.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	securityLink.click();
	HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
    executor7.executeScript("arguments[0].click();", collapseButton);
	for(WebElement items:leftNavigationItems) {
		if(!items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
		
		}
	}
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
    executor8.executeScript("arguments[0].click();", expandButton);
	for(WebElement items:leftNavigationItems) {
		if(items.isDisplayed()&& collapseButton.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	complianceLink.click();
	HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
    executor9.executeScript("arguments[0].click();", collapseButton);
	for(WebElement items:leftNavigationItems) {
		if(!items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
    executor10.executeScript("arguments[0].click();", expandButton);
	for(WebElement items:leftNavigationItems) {
		if(items.isDisplayed()&& collapseButton.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	privacyLink.click();
	HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
    executor11.executeScript("arguments[0].click();", collapseButton);
	for(WebElement items:leftNavigationItems) {
		if(!items.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor12 = (JavascriptExecutor) Driver.getDriver();
    executor12.executeScript("arguments[0].click();", expandButton);
	for(WebElement items:leftNavigationItems) {
		if(items.isDisplayed()&& collapseButton.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			
		}
	}
	
	
}

public static void setAllImages()  {
	HelperFunctions.waitForPageToLoad(5);
	int brokenImages=0;
    System.out.println(productsListImages.size());
    for(WebElement image:productsListImages) {
        if(image.getAttribute("src")== null || image.getAttribute("src").isEmpty()) {
            brokenImages++;
        }
      }
      System.out.println("The number of broken images : "+brokenImages);
      if(brokenImages!=0) {
          Assert.assertTrue(false);
      }else {
          Assert.assertTrue(true);
      }
      HelperFunctions.staticWait(5);
      legalLink.click();
      int brokenImagesforLegal=0;
      System.out.println(productsListImages.size());
      for(WebElement image:productsListImages) {
          if(image.getAttribute("src")== null || image.getAttribute("src").isEmpty()) {
        	  brokenImagesforLegal++;
          }
        }
        System.out.println("The number of broken images : "+brokenImagesforLegal);
        if(brokenImages!=0) {
            Assert.assertTrue(false);
        }else {
            Assert.assertTrue(true);
        }
        HelperFunctions.staticWait(5);
        securityLink.click();
        int brokenImagesforsecurity=0;
        System.out.println(productsListImages.size());
        for(WebElement image:productsListImages) {
            if(image.getAttribute("src")== null || image.getAttribute("src").isEmpty()) {
            	brokenImagesforsecurity++;
            }
          }
          System.out.println("The number of broken images : "+brokenImagesforsecurity);
          if(brokenImages!=0) {
              Assert.assertTrue(false);
          }else {
              Assert.assertTrue(true);
          }
          HelperFunctions.staticWait(5);
    }




	

public static void setLeft() {
	System.out.println("No of links are "+ alltags.size());  
    
	//checking the links fetched.
	for(int i=0;i<alltags.size();i++)
	{
	    WebElement E1= alltags.get(i);
	    String url= E1.getAttribute("href");
	    if(url!=null) {
	    	System.out.println(url); 
	    	
	    }
	    
	  
	}
}


public static void setAllSectionsOnHeader() {
	HelperFunctions.waitForPageToLoad(5);
	if(logo.isDisplayed() && search.isDisplayed() && userInitials.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
}

public static void setScrollFunctionality()  {
	HelperFunctions.waitForPageToLoad(5);
	JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");           
    HelperFunctions.staticWait(3);
    System.out.println("Scrolled down performed on My Product Page");   
    HelperFunctions.staticWait(3);
    legalLink.click();
    JavascriptExecutor js2 = (JavascriptExecutor)Driver.getDriver();
	js2.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");           
    HelperFunctions.staticWait(3);
    System.out.println("Scrolled down performed on Legal Page");  
    productsLink.click();
    JavascriptExecutor js3 = (JavascriptExecutor)Driver.getDriver();
   	js3.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");           
    HelperFunctions.staticWait(3);
    System.out.println("Scrolled down performed on Products Page");
    securityLink.click();
    JavascriptExecutor js4 = (JavascriptExecutor)Driver.getDriver();
   	js4.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");           
    HelperFunctions.staticWait(3);
    System.out.println("Scrolled down performed on Security Page");
 
	
}
public static void setResponsivenessOfPages()  {
	HelperFunctions.waitForPageToLoad(3);
	Assert.assertTrue(myProductsTitle.isDisplayed());
	legalLink.click();
	System.out.println(Driver.getDriver().getCurrentUrl());
	 String hrefValue = legalLink.getAttribute("href");
	 String currentUrl = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue, currentUrl);
    HelperFunctions.staticWait(3);
    productsLink.click();
    HelperFunctions.waitForPageToLoad(3);
    System.out.println(Driver.getDriver().getCurrentUrl());
    String hrefValue2 = productsLink.getAttribute("href");
	 String currentUrl2 = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue2, currentUrl2);
    HelperFunctions.staticWait(3);
    securityLink.click();
    HelperFunctions.waitForPageToLoad(3);
    System.out.println(Driver.getDriver().getCurrentUrl());
    String hrefValue3 = securityLink.getAttribute("href");
	 String currentUrl3 = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue3, currentUrl3);
	HelperFunctions.staticWait(3);
	complianceLink.click();
	HelperFunctions.waitForPageToLoad(3);
	System.out.println(Driver.getDriver().getCurrentUrl());
	String hrefValue4 = complianceLink.getAttribute("href");
	 String currentUrl4 = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue4, currentUrl4);
	HelperFunctions.staticWait(3);
	privacyLink.click();
	HelperFunctions.waitForPageToLoad(3);
	System.out.println(Driver.getDriver().getCurrentUrl());
	String hrefValue5 = privacyLink.getAttribute("href");
	 String currentUrl5 = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue5, currentUrl5);
	
 
	
}

}
