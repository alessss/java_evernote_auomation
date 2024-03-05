package pages;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage{
    public static final String loginLink = "//span[text()='Log in']";
    public static final String ContinueWithoutAccepting = "//button[contains(text(), 'Continue without accepting')]";
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage(){
        driver.get(Constants.baseURL);
    }
    public void clickOnContinue() {
        waitForElement(MainPage.ContinueWithoutAccepting).click();
    }

    public void clickOnLoin(){
        waitForElement(MainPage.loginLink).click();
    }

}
