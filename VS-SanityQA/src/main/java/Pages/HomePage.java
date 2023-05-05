package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class HomePage extends HelperFunctions {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	@FindBy(xpath="//img[@class='cmp-hero__image']")
	private WebElement promotionBannerImage;
	
	@FindBy(xpath="//div[@class='cmp-hero__description']")
	private WebElement descriptionOfPromotionBanner;
	
	@FindBy(xpath="//div[@class='cmp-hero']")
	private WebElement promotionBanner;
	
	@FindBy(xpath="//div[@class='cmp-leftnavigation__items']")
	private static List<WebElement> leftNavigationItems2;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entries']//a")
	private static List<WebElement> homePageTiles;
	
	@FindBy(xpath="(//div[@class='cmp-tiles__entry-title'])[1]")
	private WebElement legalTile;
	
	@FindBy(xpath="//div[@class='cmp-product-list__search-bar-container']")
	private WebElement landingPageComponentForLegalTile;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entry-title']")
	private static List<WebElement> titleOfTiles;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement oneStopTitle;
	
	@FindBy(xpath="//div[@class='cmp-tiles__entry-desc']")
	private static List<WebElement> descriptionOfTiles;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement title;
	
	@FindBy(xpath="//div[@class='text cmp-tiles__description']")
	private WebElement descriptionOfTitle;
	
	@FindBy(xpath="(//a[@href='/us/en/my-products.html'])[1]")
	private WebElement logintoMyProduct;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/homepage-demo/jcr:content/root/container/container/tiles/title']")
	private WebElement titleforAuthor;
	
	@FindBy(xpath="//button[@id='searchButtonHeader']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@id='globalSearchInput']")
	private WebElement searchInput;
	
	@FindBy(xpath="//div[@id='searchProductDropdown']")
	private WebElement productDropdown;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']//div//label")
	private static List<WebElement> productDropdownList;
	
	@FindBy(xpath="//input[@id='change-navigator']")
	private WebElement changeNavigatorCheckbox;
	
	@FindBy(xpath="//div[@id='docDropdown']")
	private WebElement catDropdown;
	
	@FindBy(xpath="//div[@id='searchSortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//input[@id='data-processing-addendum']")
	private WebElement dataAppCheckbox;
	
	@FindBy(xpath="//input[@id='documentation']")
	private WebElement documentationCheckbox;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[1]")
	private WebElement dataAppTitle;
	
	@FindBy(xpath="(//div[@class='cmp-search-results__card-title'])[2]")
	private WebElement documentationTitle;
	
	@FindBy(xpath="//span[@class='sdk-HeaderFileInfoView-fileBreadCrumb sdk-HeaderFileInfoView-fileBreadCrumbNormal']")
	private WebElement dataAppContent;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-option-item'])//input")
	private static List<WebElement> catDropdownCheckboxes;
	
	@FindBy(xpath="((//div[@class='cmp-search-results__page ap-page-container'])//div[3])[position()=1 or position()=2 or position()=3 or position()=4 or position()=5 or position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> resultList;
	
	@FindBy(xpath="(//a[@href='/us/en/my-products.html'])[1]")
	private WebElement loginToMyProductLink;
	
	@FindBy(xpath="(//*[@id='searchProductDropdown']/div[2])//div")
	private static List<WebElement> productDropdownItems;
	
	@FindBy(xpath="//*[@id='docDropdown']/div[2]//div")
	private static List<WebElement> catDropdownItems;
	
	@FindBy(xpath="(//div[@class='ap-dropdown-list show'])[2]//div//label")
	private static List<WebElement> catDropdownList;
	
	@FindBy(xpath="//div[@data-href='/content/pc/us/en/my-products/product-4.html']")
	private WebElement loginLink;
	
	@FindBy(xpath="//img[@id='PwCLogo']")
	private WebElement pwcLogo;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@class='ap-dropdown-option-checkbox']")
	private static List<WebElement> productCheckbox;
	
	@FindBy(xpath="//div[@class='cmp-search-results__card-title']")
	private static List<WebElement> resultsTitles;
	
	@FindBy(xpath="//div[@class='ap-dropdown-list show']")
	private static List<WebElement> productDropdownList2;
	
	@FindBy(xpath="//div[@class='cmp-pdfviewer']")
	private WebElement pdfViewer;
	
	@FindBy(xpath="//div[@class='cmp-tiles__products-link']")
	private static List<WebElement> loginToMyProductsLinks;
	
	@FindBy(xpath="//div[@id='resultsContainer']//div//a")
	private WebElement resultContainer;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private WebElement breadCrumb;
	
	@FindBy(xpath="//input[@aria-label='Search Product']")
	private WebElement searchProducts;
	
	@FindBy(xpath="//div[@class='ap-option-item']")
	private WebElement optionItem;
	
	@FindBy(xpath="//a[@class='cmp-product-list__card-link']")
	private WebElement resultLink;
	
	
	
	
	
	
	ReadXLSdata read2=new ReadXLSdata();
	
	
	
	
	
	
	
	
	
	
	

	
	static Logger logger=Logger.getLogger("HomePage");
	
	
	
	public void setImage() throws Exception {
	    HelperFunctions.waitForPageToLoad(3);
	    Boolean image = (Boolean) ((JavascriptExecutor) Driver.getDriver())
	        .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" "
	            + "&& arguments[0].naturalWidth > 0", promotionBannerImage);
	    if (!image) {
	        String errorMessage = "The promotion banner does not contain an image";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);

	    } else {
	        String successMessage = "The promotion banner contains an image";
	        logger.info(successMessage);
	    }
	}
	public void setDescriptionOfBanner() throws Exception {
		 HelperFunctions.waitForPageToLoad(10);
		    read2.setExcelFile("./testdata.xlsx", "QA");
		    String actual = descriptionOfPromotionBanner.getText();
		    String expected = read2.getCellData("VALUE", 29);
		    if (!actual.equals(expected)) {
		        String errorMessage = "The promotion banner does not match with the expected text.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		    }else {
		        String successMessage = "The promotion banner contains an image";
		        logger.info(successMessage);
		    }
	}
	
	
	public void setPromotionBanner() throws Exception {
		HelperFunctions.waitForPageToLoad(3);
		if(!promotionBanner.isDisplayed()) {
			 String successMessage = "The promotion banner contains an image";
		        logger.info(successMessage);
			 Assert.assertTrue(true);
	      } else {
	    	  String errorMessage = "The promotion banner does not match with the expected text.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
	     //   logger.error("The promotion banner is not visible to all users on homepage");
	      }
		
	}
	
	
	public void sethomePageTiles() throws Exception {
		HelperFunctions.waitForPageToLoad(3);
		for(WebElement TilesItems:homePageTiles) {
			if(TilesItems.isDisplayed()) {
				 String successMessage = "The promotion banner contains an image";
			        logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				 String errorMessage = "Missing home page tile";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
				//logger.error("Missing home page tile");
			}
	}
		
	}
	public void setLegalTile() {
		
		HelperFunctions.waitForPageToLoad(5);
		for (WebElement link : homePageTiles) {
		    try {
		        String expectedUrl = link.getAttribute("href");
		        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
		        WebElement linkClickable = wait.until(ExpectedConditions.elementToBeClickable(link));
		        linkClickable.click();
		        String actualUrl = Driver.getDriver().getCurrentUrl();
		        Assert.assertEquals(expectedUrl, actualUrl);
		    } catch (StaleElementReferenceException e) {
		      
		    }
		}
   
		
	}

	public void setTitleOfTiles() throws Exception {
		for(WebElement eachTitle:titleOfTiles) {
			if(eachTitle.isDisplayed()) {
				 String successMessage = "Tiles contain a title";
			        logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				  String errorMessage = "Tiles do not contain a title";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
				//logger.error("Tiles do not contain a title");
			}
	}
		
		
	}
	
	public void setOneStopTitle() throws Exception {
		HelperFunctions.waitForPageToLoad(3);
		read2.setExcelFile("./testdata.xlsx", "QA");
		String actualTitle=oneStopTitle.getText();
		String expectedTitle=read2.getCellData("VALUE", 30);
		
	//	Assert.assertEquals(actualTitle, expectedTitle, "Actual and expected title do not match");
		 if (!actualTitle.equals(expectedTitle)) {
			  String errorMessage = "Actual and expected title do not match";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		  }else {
			  String successMessage = "Actual and expected title match";
		        logger.info(successMessage);
		  }
	}
	
	public void setDescriptionOfTiles() throws Exception {
		for(WebElement eachDescription: descriptionOfTiles) {
			System.out.println(eachDescription.getCssValue("-webkit-line-clamp"));
			if(eachDescription.getCssValue("-webkit-line-clamp").equals("6")) {
				 String successMessage = "The description is 6 lines";
			        logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				 String errorMessage = "The description is more than 6 lines";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
//				logger.error("The description is more than 6 lines");
				
			}
		}
	}
	
	public void setTitleAndDescription() throws Exception {
		HelperFunctions.waitForPageToLoad(3);
		if(title.isDisplayed() && descriptionOfTitle.isDisplayed()) {
			String successMessage = "Verified title and description";
	        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			String errorMessage = "Not verified title and description";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
//			logger.error("The title or description does not exist on homepage");
			
		}
	}
	
	public void setTitleforAuthor() {
		
	}
	
    public void setSearchButton() throws Exception {
    	HelperFunctions.waitForPageToLoad(3);
    	searchButton.click();
    	HelperFunctions.staticWait(3);
    	
        searchInput.sendKeys("products");
        searchInput.sendKeys(Keys.ENTER);
        if(productDropdown.isDisplayed() && catDropdown.isDisplayed() && sortingDropdown.isDisplayed()) {
        	 String successMessage = "dropdowns are displayed";
		        logger.info(successMessage);
        	Assert.assertTrue(true);
        }else {
        	 String errorMessage = "dropdowns are not displayed";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
        	//Assert.assertTrue(false);
        }
        HelperFunctions.staticWait(3);
        productDropdown.click();
        changeNavigatorCheckbox.click();
        HelperFunctions.staticWait(3);
        catDropdown.click();
        dataAppCheckbox.click();
        documentationCheckbox.click();
        catDropdown.click();
     //   Assert.assertEquals(dataAppTitle.getText(), "Data Processing Addendum");
        if (!dataAppTitle.getText().equals("Data Processing Addendum")) {
			  String errorMessage = "Texts are not matching";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		  }else {
			  String successMessage = "Texts are matching";
		        logger.info(successMessage);
		  }
        Assert.assertEquals(documentationTitle.getText(), "Documentation");
        if (!documentationTitle.getText().equals("Documentation")) {
			  String errorMessage = "Texts are not matching";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		  }else {
			  String successMessage = "Texts are matching";
		        logger.info(successMessage);
		  }
        
        dataAppTitle.click();
  
        if(pdfViewer.isDisplayed()) {
        	String successMessage = "Pdf is displayed";
	        logger.info(successMessage);
    			Assert.assertTrue(true);
    		}else {
    			 String errorMessage = "Pdf is not displayed";
 		        logger.error(errorMessage);
 		        throw new Exception(errorMessage);
   		//	logger.error("Data App content is not displayed");
    			
    		}
        
        
        
        
        
        
	}
    
    public void setSortedResult() throws Exception {
    	HelperFunctions.waitForPageToLoad(3);
    	searchButton.click();
    	HelperFunctions.staticWait(3);
    	
        searchInput.sendKeys("products");
        searchInput.sendKeys(Keys.ENTER);
        HelperFunctions.staticWait(3);
        productDropdown.click();
       // changeNavigatorCheckbox.click();
        HelperFunctions.staticWait(3);
        productDropdown.click();
        HelperFunctions.staticWait(3);
        catDropdown.click();
        for(int i=0; i<catDropdownCheckboxes.size(); i++)
		{
			if(catDropdownCheckboxes.get(i).isDisplayed() && catDropdownCheckboxes.get(i).isEnabled())
			{
                  // System.out.println("Checkbox is displayed at index : " + i + " Clicking on it now");
                   catDropdownCheckboxes.get(i).click();
			}
		}
        HelperFunctions.staticWait(3);
        catDropdown.click();
        HelperFunctions.staticWait(3);
        
        ArrayList<String> obtainedList = new ArrayList<>(); 
        for(WebElement we:resultList){
        	   obtainedList.add(we.getText());
        	   //System.out.println(obtainedList);
        	}
        	ArrayList<String> sortedList = new ArrayList<>();   
        	for(String s:obtainedList){
        	sortedList.add(s);
        	//System.out.println(sortedList);
        	}
        	Collections.sort(sortedList);
        //	Assert.assertTrue(sortedList.equals(obtainedList));
        	 if (!sortedList.equals(obtainedList)) {
				  String errorMessage = "The promotion banner does not match with the expected text.";
			        logger.error(errorMessage);
			        throw new Exception(errorMessage);
			  }else {
				  String successMessage = "The promotion banner contains an image";
			        logger.info(successMessage);
			  }

    
    	
    	
    	
    	
    }
    public void setDropdown() throws Exception {
    	HelperFunctions.waitForPageToLoad(3);
    	searchButton.click();
    	HelperFunctions.staticWait(3); 
    	
        searchInput.sendKeys("products");
        searchInput.sendKeys(Keys.ENTER);
        HelperFunctions.staticWait(3);
        if(productDropdown.isEnabled() && productDropdown.isDisplayed()) 
        { 
        	String successMessage = "Product Dropdown is enabled and visible";
	        logger.info(successMessage);
        } 
       else { 
    	   String errorMessage = "Product Dropdown is not visible";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
          
       } 
        productDropdown.click();
        changeNavigatorCheckbox.click();
        HelperFunctions.staticWait(3);
        if(catDropdown.isEnabled() && catDropdown.isDisplayed()) 
        { 
        	String successMessage = "Category Dropdown is enabled and visible";
	        logger.info(successMessage);
        } 
       else { 
    	   String errorMessage = "Category Dropdown is not visible";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
         
       } 
        catDropdown.click();
        dataAppCheckbox.click();
        documentationCheckbox.click();
        catDropdown.click();
        if (!dataAppTitle.getText().equals("Data Processing Addendum")) {
			  String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		  }else {
			  String successMessage = "Texts are matching";
		        logger.info(successMessage);
		  }
      
        if (!documentationTitle.getText().equals("Documentation")) {
			  String errorMessage = "Texts are not matching.";
		        logger.error(errorMessage);
		        throw new Exception(errorMessage);
		  }else {
			  String successMessage = "Texts are matching";
		        logger.info(successMessage);
		  }
        
        dataAppTitle.click();
        //Driver.getDriver().switchTo().frame(0);
        if(pdfViewer.isDisplayed()) {
        	String successMessage = "pdf viewer is displayed";
	        logger.info(successMessage);
			Assert.assertTrue(true);
		}else {
			String errorMessage = "pdf viewer is not displayed";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
//			logger.error("Data App content is not displayed");
			
		}
            
	}
    
    public void setLogintoMyProduct() {
    	HelperFunctions.waitForPageToLoad(3);
    	loginToMyProductLink.click();
    }
    
    public void setDropdownList() {
    	HelperFunctions.waitForPageToLoad(3);
    	searchButton.click();
    	HelperFunctions.staticWait(3);
    	
        searchInput.sendKeys("products");
        searchInput.sendKeys(Keys.ENTER);
        HelperFunctions.staticWait(3);
        if(productDropdown.isEnabled() && productDropdown.isDisplayed()) 
        { 
           System.out.println("Product Dropdown is enabled and visible"); 
        } 
       else { 
           System.out.println("Product Dropdown is not visible"); 
       }   
        
        
    }
    public void setDropdownList2() throws Exception {
    	HelperFunctions.staticWait(3);
    	productDropdown.click();
    	
    	 FileInputStream file = new FileInputStream("C:\\Users\\erong\\git\\ProductCentralProject-Automation1\\testdata.xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(file);
         XSSFSheet sheet = workbook.getSheetAt(1); 
    	HelperFunctions.staticWait(3);
        int columnIndex2 = 1;
        HashSet<String> cellValues2 = new HashSet<String>();
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            XSSFRow row = sheet.getRow(rowNum);
            if(row == null) continue;
            XSSFCell cell = row.getCell(columnIndex2);
            if(cell == null) continue;
            cellValues2.add(cell.getStringCellValue());
        }
        for (WebElement element2 : productDropdownList) {
            if(element2.isDisplayed() && element2.isEnabled()){
                String elementText2 = element2.getText();
                if(elementText2!=null && !elementText2.isEmpty()){
                    Assert.assertTrue(cellValues2.contains(elementText2), "element text: " + elementText2 + " not found in the column: " + columnIndex2);
                }else{
                    System.out.println("Element text is empty or null, skipping the element");
                }
            }else{
                System.out.println("Element is not interactable or not visible, skipping the element");
            }
        }
    	HelperFunctions.staticWait(3); 
    	catDropdown.click();
    	 HelperFunctions.staticWait(3);
         int columnIndex3 = 0;
         HashSet<String> cellValues3 = new HashSet<String>();
         for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
             XSSFRow row = sheet.getRow(rowNum);
             if(row == null) continue;
             XSSFCell cell = row.getCell(columnIndex3);
             if(cell == null) continue;
             cellValues3.add(cell.getStringCellValue());
         }
         for (WebElement element3 : catDropdownList) {
             if(element3.isDisplayed() && element3.isEnabled()){
                 String elementText3 = element3.getText();
                 if(elementText3!=null && !elementText3.isEmpty()){
                     Assert.assertTrue(cellValues3.contains(elementText3), "element text: " + elementText3 + " not found in the column: " + columnIndex3);
                 }else{
                     System.out.println("Element text is empty or null, skipping the element");
                 }
             }else{
                 System.out.println("Element is not interactable or not visible, skipping the element");
             }
         }
       
        
        }
    
   public void setSearchResult() {
	   HelperFunctions.waitForPageToLoad(3);
   	searchButton.click();
   	HelperFunctions.staticWait(3);
   	
       searchInput.sendKeys("products");
       searchInput.sendKeys(Keys.ENTER);
       HelperFunctions.staticWait(3);
       productDropdown.click();
       String expectedProductName="master-data-management";
       for(int i=0; i<productCheckbox.size(); i++) {
    	   if(productCheckbox.get(i).getAttribute("id").equalsIgnoreCase(expectedProductName)) {
    		   productCheckbox.get(i).click();
    	   }
       }
       productDropdown.click();
       HelperFunctions.staticWait(3);
       String actualProductName=resultContainer.getAttribute("data-product-name");
       System.out.println(actualProductName);
       Assert.assertEquals(actualProductName, expectedProductName);
       resultContainer.click();
       HelperFunctions.staticWait(3);
      // breadCrumb.click();
      // HelperFunctions.staticWait(3);
       String actualTitle=oneStopTitle.getText();
       String expectedTitle="Master Data Management";
       Assert.assertEquals(actualTitle, expectedTitle);
       breadCrumb.click();
       HelperFunctions.staticWait(3);
       searchProducts.click();
       searchProducts.sendKeys(expectedTitle);
       optionItem.click();
       HelperFunctions.staticWait(3);
       String actualTitle2=resultLink.getAttribute("data-product-name");
       Assert.assertEquals(actualTitle2, expectedTitle);


   }
   
    
    
    
    public void setLoginToMyProductLink() {
    	HelperFunctions.waitForPageToLoad(5);
    	 JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
 	    js2.executeScript("window.scrollBy(0,250)", "");
 	   HelperFunctions.staticWait(3);
    	for(WebElement each:loginToMyProductsLinks) {
    		each.click();
    		break;
    		
    	}
  
    	if(pwcLogo.isDisplayed() && email.isDisplayed() && next.isDisplayed()) {
    		Assert.assertTrue(true);
    	}else {
    		Assert.assertTrue(false);
    	}
    }
        
        
        
    
	
	
	
	
	
	
	
	
	
	
	
	
	
}
