package webpageclasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;


	@FindBy(xpath="//a[contains(@class, \"button-default solid-dark-button\")]")
	public WebElement watchdemo;


	@FindBy(id="FirstName")
	public WebElement firstName;
	
	@FindBy(id="LastName")
	public WebElement lastName;
	
	@FindBy(id="Email")
	public WebElement emailId;
	
	@FindBy(id="Company")
	public WebElement Company;
	
	@FindBy(id="Phone")
	public WebElement phoneNO;
	
	@FindBy(id="Unit_Count__c")
	public WebElement Ucount;
	
	@FindBy(id="Title")
	public WebElement title;
	


	@FindBy(xpath="//div[@class='main-nav-link' and text()='Products']")
	public WebElement product;



	@FindBy(xpath = "//a[@href='/products/marketing-and-leasing']")
	public WebElement marketingAndLeasingLink;
   

	@FindBy(xpath = "//a[contains(@class, 'fat-nav-links')]")
	public WebElement ProspectPortal;
	
	@FindBy(xpath = "//a[@title='Marketing & Leasing Product - Image Slide - CRM']")
	public WebElement learn;
	
	//xpath for navgations
	@FindBy(xpath="//*[@id='gatsby-focus-wrapper']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/a[1]")
	public WebElement Resources;
	
    
    public HomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    public void selectUnitCountByValue(String value) {
        Select dropdown = new Select(Ucount);
        dropdown.selectByValue(value);
    }
    
}
    
    

