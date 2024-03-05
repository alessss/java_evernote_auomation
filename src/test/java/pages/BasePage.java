package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElement(String xpath){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element;
    }

    public List<WebElement> getListOfElements(String xpath){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return driver.findElements(By.xpath(xpath));
    }

    public String getElementText(String xpath){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element.getText();
    }

    public void clickElement(String xpath){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }

    public boolean elementIsDisplayed(String xpath) {
        try {
            waitForElement(xpath).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
