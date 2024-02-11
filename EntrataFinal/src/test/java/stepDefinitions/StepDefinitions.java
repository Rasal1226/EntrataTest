package stepDefinitions;


import entratafunction.Entrata;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import webpageclasses.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class StepDefinitions {
    public HomePage hp;
    public Entrata er;
    WebDriver driver;


    @Given("User is on Entrata application")
    public void iAmOnTheRegistrationPage() {

        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
        hp = new HomePage(driver);
        er=new Entrata();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Navigate to a specific URL
        driver.get("https://www.entrata.com/");


    }


    @When("User clicks on product")
    public void userClicksOnProduct() {
        hp = new HomePage(driver);
        Actions act = new Actions(driver);

        // Perform mouse hover action
        act.moveToElement(hp.product).perform();

        try {
            // Explicitly wait for the product link to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a maximum of 10 seconds
            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(hp.product));

            // Click on the product link
            productLink.click();


            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a maximum of 10 seconds
            WebElement marketingAndLeasing = wait1.until(ExpectedConditions.elementToBeClickable(hp.marketingAndLeasingLink));
            marketingAndLeasing.click();


        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }

    @Then("User is navigated to Marketing and Leasing page successfully")
    public void iShouldBeRegisteredSuccessfully() {
        String pageTitle = driver.getTitle();
        // Expected page title
        String expectedTitle = "Property Management Software | Entrata";

        // Assert that the current page title matches the expected title
        Assert.assertEquals(expectedTitle, pageTitle);

    }


    @And("I enter {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void iEnterAnd(String firstName, String lastName, String email, String phone, String companyName, String uid, String jobTitle) throws InterruptedException {

        hp.watchdemo.click();
        Thread.sleep(2000);
        hp.firstName.sendKeys(firstName);
        hp.lastName.sendKeys(lastName);
        hp.emailId.sendKeys(email);
        hp.phoneNO.sendKeys(phone);
        hp.Company.sendKeys(companyName);
        hp.selectUnitCountByValue("1 - 10");
        hp.title.sendKeys(jobTitle);
    }

    @Then("User fills the watch demo form successfully")
    public void verifywatchdemoformfilledsuccessfully() {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(".\\src\\test\\screenshot\\screenshot.png"));

            File screenshotFile = new File("filled_form_page_screenshot.png");
            Assert.assertTrue("Screenshot file does not exist", screenshot.exists());
            System.out.println("Screenshot file exists.");

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }


    @Then("User able to navigate {string}")
    public void userAbleToNavigate(String Entrata_navigation_snap) throws InterruptedException {

        hp.Resources.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gatsby-focus-wrapper']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/a[1]")));

       er.screenshot(driver,"Resources",Entrata_navigation_snap);
        Assert.assertTrue("Resources link is clickable",  hp.Resources.isDisplayed());

    }

}
