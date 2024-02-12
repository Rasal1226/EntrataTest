package entratafunction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Entrata {




    public void screenshot(WebDriver driver, String Function, String Folder) {
        JavascriptExecutor je = (JavascriptExecutor) driver;

        if (Function.equalsIgnoreCase("Resources")) {
            je.executeScript("window.scrollBy(0, -1700)", "");
            Loopscreshot1(driver, Folder, "Resources_i");
            je.executeScript("window.scrollBy(0, 500)", "");
            Loopscreshot1(driver, Folder, "Resources_ii");
            je.executeScript("window.scrollBy(0, 500)", "");
            Loopscreshot1(driver, Folder, "Resources_iii");
            je.executeScript("window.scrollBy(0, 500)", "");
            Loopscreshot1(driver, Folder, "Resources_iv");
        }

    }

    public void Loopscreshot1(WebDriver driver, String folderPath, String namescr) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(screenshot, new File( ".\\src\\test\\screenshot\\" + folderPath + "\\" + namescr + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickDeclineButtonIfAvailable(WebElement declineButton) {
        try {
            if (declineButton.isDisplayed()) {
                // If it's visible, click on it
                declineButton.click();
                System.out.println("Clicked on Decline button.");
            }
        } catch (NoSuchElementException e) {
            // If the button is not found, log a message
            System.out.println("Decline button is not available, so it was not clicked.");
        }
    }
}
