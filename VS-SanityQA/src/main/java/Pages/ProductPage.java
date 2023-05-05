package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class ProductPage extends HelperFunctions {
	public ProductPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//div[@class='cmp-error__title']")
	private WebElement errorTitle;
	
	@FindBy(xpath="//div[@class='cmp-error__description']")
	private WebElement errorDescription;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-select'])[1]")
	private WebElement myProductCatDropdown;
	
	@FindBy(xpath="//h1[@class='cmp-all-resources__top-bar-title']")
	private WebElement allResources;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5resources;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5resources;
	
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']")
	private static List<WebElement> myProductCatDropdownList;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private WebElement footerContent;
	
	@FindBy(xpath="//div[@class='ap-footer-link-group']")
	private WebElement footerLinkGroup;
	
	@FindBy(xpath="//span[.='Next']")
	private WebElement nextButtonforResources;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample10.pdf.coredownload.inline.pdf.coredownload.inline.pdf']")
	private WebElement firstResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample13.png.coredownload.inline.png.coredownload.inline.png']")
	private WebElement secondResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/sample16.jpg.coredownload.inline.jpg.coredownload.inline.jpg']")
	private WebElement thirdResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/7E1c.gif.coredownload.inline.gif.coredownload.inline.gif']")
	private WebElement forthResource;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-2/myproducts/gif.coredownload.inline.gif.gif.coredownload.inline.gif.coredownload.inline.gif']")
	private WebElement fifthResource;
	
	@FindBy(xpath="//button[@id='showMore']")
	private WebElement viewMoreButton;
	
	@FindBy(xpath="//button[@id='showLess']")
	private WebElement viewLessButton;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/my-products.html']")
	private WebElement myProductItemOnSitemap;
	
	@FindBy(xpath="//div[@class='ap-dropdown-option-item']//span[1]")
	private static List<WebElement> myProductCatDropdownList2;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-select'])[1]")
	private WebElement selectDropdown;
	
	@FindBy(xpath="//*[@id=\"listPage\"]/div/div/div[2]/div[3]")
	private WebElement cardCat;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-select'])[1]")
	private WebElement documentDropdown;
	
	
	@FindBy(xpath="//div[@class='cmp-all-resources__card-category']")
	private WebElement cardCategory;
	
	@FindBy(xpath="//img[@src='/us/en/errors/403/_jcr_content/root/container/container/error/image.coreimg.svg/1668507894105/403-error-illus-%281%29.svg']")
	private WebElement errorImage;
	
	@FindBy(xpath="//div[@id='searchProductDropdown']")
	private WebElement productDropdown;
	
	@FindBy(xpath="//div[@id='docDropdown']")
	private WebElement catDropdown;
	
	@FindBy(xpath="//div[@id='searchSortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//input[@id='gatedSearchInput']")
	private WebElement myProductSearchField;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[1]")
	private WebElement resource1;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[2]")
	private WebElement resource2forProduct2;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[3]")
	private WebElement resource3forProduct2;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[4]")
	private WebElement resource4forProduct2;
	
	@FindBy(xpath="(//div[@class='cmp-all-resources__card-title']//a)[5]")
	private WebElement resource5forProduct2;
	
	@FindBy(xpath="//a[@href='/us/en/my-products/product-2.html']")
	private WebElement product2;
	
	@FindBy(xpath="//a[@href='/us/en/my-products/product-4.html']")
	private WebElement product4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/Transparency-Hub-Support-Guide-test.pdf.coredownload.inline.pdf']")
	private WebElement resource1forProduct4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/Resell Data Processing addendum.png.coredownload.inline.png']")
	private WebElement resource2forProduct4;
	
	@FindBy(xpath="//a[@href='/content/dam/productcentral/en_us/products/product-4/myproducts/sample7.jpg.coredownload.inline.jpg']")
	private WebElement resource3forProduct4;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5Assets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5Assets;
	
	@FindBy(xpath="//div[@class='cmp-my-products-tile__title']")
	private static List<WebElement> titleofAssets;
	
	@FindBy(xpath="//div[@class='cmp-all-resources__card-title']//a")
	private static List<WebElement> allresourcesContentLink;
	
	@FindBy(xpath="//div[@class='cmp-for-you__txt']")
	private WebElement forYouTitle;
	
	@FindBy(xpath="//span[.='Product 2']")
	private WebElement product2Title;
	
	@FindBy(xpath="//span[.='Product 4']")
	private WebElement product4Title;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/my-products.html']")
	private WebElement myProductOnLeftNavigation;
	
	@FindBy(xpath="//div[@class='cmp-hero-promotion']")
	private WebElement heroPromotion;
	
	@FindBy(xpath="((//div[@class='cmp-tabs__tab-search-container'])[1]//li)[position()=1]")
	private WebElement firstProduct;
	
	@FindBy(xpath="//span[@class='cmp-header__cta-avatar-initials']")
	private WebElement userInitials;
	
	@FindBy(xpath="//div[@class='cmp-need-technical-support__text-container']")
	private WebElement technicalSupportTitle;
	
	@FindBy(xpath="//div[@class='cmp-related-products__title']")
	private WebElement relatedProductsTitle;
	
	@FindBy(xpath="(//div[@class='cmp-related-products__carousel-title'])[position()=1]")
	private WebElement relatedProduct1;
	
	@FindBy(xpath="(//div[@class='cmp-related-products__carousel-title'])[position()=2]")
	private WebElement relatedProduct2;
	
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
	
	@FindBy(xpath="//a[.='Go To Client View']")
	private WebElement technicalSupportButton;
	
	@FindBy(xpath="//ol[@class='cmp-tabs__tablist']//a//li//div//span[1]")
	private static List<WebElement> allProducts;
	
	
	
	
	
	
	
	
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	
	
	
	
	
	
	
	
	public void setDocCategory() throws Exception {
		HelperFunctions.scrollToElement(allResources);
		read1.setExcelFile("./testdata.xlsx", "Tag Taxonomy");
        
		for(WebElement eachdocCat: myProductCatDropdownList) {
			System.out.println(eachdocCat.getText());
			
			if(eachdocCat.getText().contains(read1.getCellData("Portfolio", 1))&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 2))
					&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 3))
					&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 4))
					&&eachdocCat.getText().contains(read1.getCellData("Portfolio", 5))){
				
				Assert.assertTrue(true);}else {Assert.assertTrue(false);}}
		
		for(WebElement eachdocCat:myProductCatDropdownList) {
			if(eachdocCat.getText().contains(read1.getCellData("Portfolio", 1))) {
				eachdocCat.click();
				break;
			}
		}	
		
		
	}
	
	public void setFooterWithoutLogin() {
		HelperFunctions.scrollToElement(footerContent);
	
	        if(footerContent.isDisplayed() && footerLinkGroup.isEnabled() ) {
	        	Assert.assertTrue(true);
	        }else {
	        	Assert.assertTrue(false);
	        }
	
	}
	
	public void setFooterWithLogin() throws Exception {
		
		HelperFunctions.scrollToElement(footerContent);
		
	        System.out.println(footerContent.getText());
	       
	        if(footerContent.isDisplayed() && footerLinkGroup.isDisplayed() ) {
	        	Assert.assertTrue(true);
	        }else {
	        	Assert.assertTrue(false);
	        }
	      
	
	}
	
	public void setErrorMessage() throws Exception  {
	
	    
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 36));
	    HelperFunctions.staticWait(5);
	    String actualErrorTitle=errorTitle.getText();
	    String expectedErrorTitle=read1.getCellData("VALUE", 38);
		String actualErrorDescription=errorDescription.getText();
		String expectedErrorDescription=read1.getCellData("VALUE", 37);
		Assert.assertEquals(actualErrorTitle, expectedErrorTitle, "Actual and expected error title do not match");
		Assert.assertEquals(actualErrorDescription, expectedErrorDescription, "Actual and expected error description do not match");
	    
		
	}
	
	public void setErrorPage() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    read1.setExcelFile("./testdata.xlsx", "QA");
	    Driver.getDriver().get(read1.getCellData("VALUE", 36));
	    HelperFunctions.staticWait(5); 
		if(errorImage.isDisplayed() && errorTitle.isDisplayed() &errorDescription.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    
		
	}
	
	
	
public void setDisplayResources() {
	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;}
	
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.scrollToElement(allResources); 
	HelperFunctions.staticWait(3);
     for(WebElement eachResources: first5resources) {
    	 if(eachResources.isDisplayed()) {
    		 Assert.assertTrue(true);
    	 }else {
    		 Assert.assertTrue(false);
    	 }
     }
     HelperFunctions.staticWait(3);
     HelperFunctions.scrollToElement(nextButtonforResources);
     HelperFunctions.staticWait(3);
     JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
     executor.executeScript("arguments[0].click();", nextButtonforResources);
    // nextButtonforResources.click();
     HelperFunctions.staticWait(3);
     for(WebElement eachResources2: last5resources) {
    	 if(eachResources2.isDisplayed()) {
    		 Assert.assertTrue(true);
    	 }else {
    		 Assert.assertTrue(false);
    	 }
     }
     
    }
public void setNewTabAssets() throws Exception {

	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;}
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(allResources); 
    HelperFunctions.staticWait(3);
    String hrefValue = resource1.getAttribute("href");
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", resource1);
    //resource1.click();
    HelperFunctions.staticWait(3);
    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
    Driver.getDriver().switchTo().window(tabs.get(2));
    System.out.println(Driver.getDriver().getCurrentUrl());
	 String currentUrl = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue, currentUrl);
   // Driver.getDriver().close();
   // Driver.getDriver().switchTo().window(tabs.get(1));
   // HelperFunctions.staticWait(3);
	
}

public void setMyProductSitemap() {
	HelperFunctions.waitForPageToLoad(3);
	if(myProductItemOnSitemap.isDisplayed()) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
	}
}

public void setTagsAccompany() {
	HelperFunctions.staticWait(3);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;}
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(viewMoreButton); 
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", selectDropdown);
    
    String expected1="Technical Guide";
    
    
	for(WebElement tags:myProductCatDropdownList2) {
		System.out.println(tags.getText());
		if(tags.getText().contains("Technical Guide")) {
			JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
		    executor2.executeScript("arguments[0].click();", tags);
		Assert.assertEquals(cardCat.getText(), expected1);
		}
	}
	HelperFunctions.staticWait(3);
 /*	JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
    executor2.executeScript("arguments[0].click();", selectDropdown);
    HelperFunctions.staticWait(3);
	String expected2="Resel Alliance Terms";
	for(WebElement tags:myProductCatDropdownList2) {
		System.out.println(tags.getText());
		if(tags.getText().contains("Resel Alliance Terms")) {
		tags.click();
		Assert.assertEquals(cardCat.getText(), expected2);
		}
	}*/
	
	
}

public void setMyProductSearch() {
	
	HelperFunctions.waitForPageToLoad(3);
	myProductSearchField.click();
	myProductSearchField.sendKeys("Product 2");
	myProductSearchField.sendKeys(Keys.ENTER);
	HelperFunctions.waitForPageToLoad(3);
	if(productDropdown.isEnabled() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }
	
}

public void setResourcesBasedonProducts() {
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(allResources);  
    if(resource1.isDisplayed() ) {
	   Assert.assertTrue(true);
   }else
	   Assert.assertTrue(false);
    String text1=resource1.getText();
    System.out.println(text1);
    HelperFunctions.staticWait(3);
   myProductItemOnSitemap.click();
   HelperFunctions.waitForPageToLoad(5); 
   for(int i=0;i<allProducts.size();i++) {
		allProducts.get(1).click();
		break;
   }
   HelperFunctions.staticWait(3);
  // product4.click();
   HelperFunctions.scrollToElement(allResources);
   HelperFunctions.staticWait(3);
 
   String text2=resource1.getText();
   System.out.println(text2);
   Assert.assertNotEquals(text1, text2);
   HelperFunctions.staticWait(3);
   if(resource1.isDisplayed()  ) {
	   Assert.assertTrue(true);
   }else
	   Assert.assertTrue(false);
   
}

public void setNotSupportMultiSelect() {
	//HelperFunctions.waitForPageToLoad(3);
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(documentDropdown);
	HelperFunctions.staticWait(3);
	JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    executor.executeScript("arguments[0].click();", documentDropdown);
   // documentDropdown.click();    
	    for(WebElement tags:myProductCatDropdownList) {
			tags.click();
			break;
			
		}
	    for(WebElement tags:myProductCatDropdownList) {
	    	Assert.assertFalse(tags.isDisplayed());
	    }
	    
	   
}

public void setLoadMoreButton() {
	//HelperFunctions.waitForPageToLoad(3);
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(viewMoreButton);
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      if(viewLessButton.isDisplayed()) {
      	for(WebElement eachAsset: first5Assets) {
      		if(eachAsset.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      	      	Assert.assertTrue(false);
            }
      	}
      	for(WebElement eachAsset2:last5Assets) {
      		if(eachAsset2.isDisplayed()) {
      			Assert.assertTrue(true);
      		}
      	}
      }else {
      	Assert.assertTrue(false);
      }
	
	
}

public void setClickLoadMoreButton() {
	//HelperFunctions.waitForPageToLoad(3);
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(viewMoreButton);
	
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      
      	
      	for(WebElement eachAsset2:last5Assets) {
      		if(eachAsset2.isDisplayed() && viewLessButton.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      			Assert.assertTrue(false);
      		}
      	}
      
	
	
}

public void setClickLoadLessButton() {
	//HelperFunctions.waitForPageToLoad(3);
	//product2.click();
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(viewMoreButton);
      JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
      executor.executeScript("arguments[0].click();", viewMoreButton);
      
      	
      if(viewLessButton.isDisplayed()) {
        	for(WebElement eachAsset: first5Assets) {
        		if(eachAsset.isDisplayed()) {
        			Assert.assertTrue(true);
        		}else {
        	      	Assert.assertTrue(false);
              }
        	}
        	for(WebElement eachAsset2:last5Assets) {
        		if(eachAsset2.isDisplayed()) {
        			Assert.assertTrue(true);
        		}
        	}
        }else {
        	Assert.assertTrue(false);
        }
      
      JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
      executor2.executeScript("arguments[0].click();", viewLessButton);
      
      if(viewMoreButton.isDisplayed()) {
      	for(WebElement eachAsset: first5Assets) {
      		if(eachAsset.isDisplayed()) {
      			Assert.assertTrue(true);
      		}else {
      	      	Assert.assertTrue(false);
            }
      	}
      	for(WebElement eachAsset2:last5Assets) {
      		if(!eachAsset2.isDisplayed()) {
      			Assert.assertTrue(true);
      		}
      	}
      }else {
      	Assert.assertTrue(false);
      }
  	
      
	
	
}

public void setTitleOfAssets() {
	
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.waitForPageToLoad(3);
	HelperFunctions.scrollToElement(forYouTitle);
    int hasMoreThan3Line=0;
    System.out.println(titleofAssets.size());
	for(WebElement eachTitleOfAssets: titleofAssets) {
		System.out.println(eachTitleOfAssets.getCssValue("-webkit-line-clamp"));
		if(eachTitleOfAssets.getCssValue("-webkit-line-clamp").equals("3")) {
			Assert.assertTrue(true);
		}else {
			hasMoreThan3Line++;
			System.out.println(hasMoreThan3Line);
			Assert.assertTrue(false);
//			logger.error("The description is more than 6 lines");
			
		}
	}
}

public void setActiveTab() {
	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		
		String s = allProducts.get(0).getCssValue("color");
		String s2 = allProducts.get(1).getCssValue("color");
		Assert.assertNotEquals(s, s2);
		Assert.assertTrue(s.equals("rgba(65, 83, 133, 1)"));
		System.out.println("Color is :" + s); 
		break;
	}
	HelperFunctions.staticWait(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(1).click();
		
		String s = allProducts.get(0).getCssValue("color");
		String s2 = allProducts.get(1).getCssValue("color");
		Assert.assertNotEquals(s, s2);
		Assert.assertTrue(s2.equals("rgba(65, 83, 133, 1)"));
		System.out.println("Color is :" + s); 
		break;
	}
	

}

public void setFirstTabActive() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	myProductOnLeftNavigation.click();
	HelperFunctions.waitForPageToLoad(5);
	read1.setExcelFile("./testdata.xlsx", "QA");
	String activeColor=read1.getCellData("VALUE", 39);
	String fp=firstProduct.getCssValue("color");
	if(fp.equals(activeColor)) {
		Assert.assertTrue(true);
	}else {
    	Assert.assertTrue(false);
    }
    

}

public void setHeroPromotion() {
	HelperFunctions.waitForPageToLoad(5);
	 String attr = heroPromotion.getAttribute("src");
	    if (attr == null){
	        System.out.println("Hero promotion is not clickable");
	        Assert.assertTrue(true);
	    }

	    else {
	    	System.out.println("Hero promotion is clickable");
	    	Assert.assertTrue(false);
	    }

	
	
}

public void setUserInitials() throws Exception {
	read1.setExcelFile("./testdata.xlsx", "QA");
	HelperFunctions.waitForPageToLoad(3);
	String email=read1.getCellData("DATA", 1);
	String firstInit=email.substring(0,1);
	String lastInit=email.substring(email.indexOf(".")+1);
	String lastInit2=lastInit.substring(0,1);
	String userInitials2=userInitials.getText();
	String firstAndLastInit=firstInit+lastInit2;
	System.out.println(userInitials.getText());
	System.out.println(firstInit+lastInit2);
	Assert.assertTrue(userInitials2.equalsIgnoreCase(firstAndLastInit));
	
	
}



public void setInfoOfProducts() {
	HelperFunctions.waitForPageToLoad(5);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
    HelperFunctions.staticWait(3);
    HelperFunctions.scrollToElement(forYouTitle);
	WebElement first = titleofAssets.stream().findFirst().get();
	System.out.println(first.getText());
	System.out.println("----");
    HelperFunctions.staticWait(3);
	JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
	js2.executeScript("window.scrollBy(0,-1200)", "");
	HelperFunctions.staticWait(3);

	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(1).click();
		break;
    }
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement( forYouTitle);
	HelperFunctions.staticWait(3);
    WebElement first2 = titleofAssets.stream().findFirst().get();
	System.out.println(first2.getText());
	HelperFunctions.staticWait(3);
	Assert.assertNotEquals(first, first2);

   
   
    
}

public void setRelatedProducts() throws Exception {

	HelperFunctions.waitForPageToLoad(3);
    for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
    HelperFunctions.staticWait(3);
    HelperFunctions.scrollToElement(relatedProductsTitle);
    String actualTitle=relatedProduct1.getText();
    String actualTitle2=relatedProduct2.getText();
    HelperFunctions.staticWait(3);
	JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
	js2.executeScript("window.scrollBy(0,-2500)", "");
	HelperFunctions.staticWait(3);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(1).click();
		break;
    }
	HelperFunctions.staticWait(3);
	 HelperFunctions.scrollToElement(relatedProductsTitle);
	 String actualTitle3=relatedProduct1.getText();
	 String actualTitle4=relatedProduct2.getText();
	 HelperFunctions.staticWait(3);
	 Assert.assertNotEquals(actualTitle, actualTitle3);
	 Assert.assertNotEquals(actualTitle2, actualTitle4);
  
	
}

public void setAllResourcesContent() {
	HelperFunctions.waitForPageToLoad(5);
	for(int i=0;i<allProducts.size();i++) {
		allProducts.get(0).click();
		break;
    }
	HelperFunctions.staticWait(3);
	HelperFunctions.scrollToElement(allResources);
	HelperFunctions.staticWait(3);
	 String a=".pdf";
	 String b=".png";
	 String c=".jpg";
	 String d=".gif";
	 String e=".mp4";
	 String f=".mp3";
	 
	 List<String> list = new ArrayList<String>();
    for(WebElement each:allresourcesContentLink) {
    	list.add(each.getAttribute("href").substring(each.getAttribute("href").length()-4));
    }
    if(list.contains(a)||list.contains(b)||list.contains(c)||list.contains(d)||list.contains(e)||list.contains(f)) {
    	Assert.assertTrue(true);
    }else {
    	Assert.assertTrue(false);
    }

   
        
   
   
}

public void setTechnicalSupport() throws Exception {
	HelperFunctions.waitForPageToLoad(5);
	HelperFunctions.scrollToElement(technicalSupportButton);
    HelperFunctions.staticWait(5);
    System.out.println(technicalSupportButton.getAttribute("href"));
    String hrefValue = technicalSupportButton.getAttribute("href");
    technicalSupportButton.click();
    ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
    Driver.getDriver().switchTo().window(tabs2.get(2));
    HelperFunctions.staticWait(5);
	 String currentUrl = Driver.getDriver().getCurrentUrl();
	 Assert.assertEquals(hrefValue, currentUrl);

}

	
	
	
	
	
	
	

 
	
	

	
	
	

	
	
	
	
	
	

}
