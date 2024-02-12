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
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;


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
        er = new Entrata();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Navigate to a specific URL
        driver.get("https://www.entrata.com/");
        // Set a short timeout for dynamic wait




    }


    @When("User clicks on product")
    public void userClicksOnProduct() {
        hp = new HomePage(driver);
        Actions act = new Actions(driver);

        // Perform mouse hover action
        act.moveToElement(hp.product).perform();

        try {
            // Explicitly wait for the product link to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for a maximum of 10 seconds
            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(hp.product));

            // Click on the product link
            productLink.click();


            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for a maximum of 10 seconds
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

        er.screenshot(driver, "Resources", Entrata_navigation_snap);
        Assert.assertTrue("Resources link is not clickable", hp.Resources.isDisplayed());

    }


    @When("User navigated to login window")
    public void userClicksOnTheLink() {

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String win1 = driver.getWindowHandle();
        System.out.println("Window ID before clicking the button: " + win1);

// Click signin button
        hp.signIn.click();

// Get the window handle of the main window after clicking the sign in
        String win2 = driver.getWindowHandle();
        System.out.println("Window ID after clicking the button: " + win2);
        System.out.println("Title of signin window is :" + driver.getTitle());

        try {
            // Attempt to find the Decline button
            WebElement declineButton = hp.decline;

            // If the button is found, click on it
            if (declineButton.isDisplayed()) {
                declineButton.click();
                System.out.println("Clicked on Decline button.");
            } else {
                // If the button is not found, log a message and continue with execution
                System.out.println("Decline button is not available, so it was not clicked.");
            }
        } catch (NoSuchElementException e) {
            // If the button is not found, log a message and continue with execution
            System.out.println("Decline button is not available, so it was not clicked.");
        }

// Reset implicit wait after handling the cookie
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        hp.Clientlogin.click();

        String win3 = driver.getWindowHandle();
        System.out.println("Window ID after clicking the button: " + win3);
        System.out.println("Title of client window is :" + driver.getTitle());

    }

    @Then("User returns to the main window")
    public void userReturnsToTheMainWindow() {

        Assert.assertEquals("Expected number of windows is not met", 1, driver.getWindowHandles().size());
    }
}