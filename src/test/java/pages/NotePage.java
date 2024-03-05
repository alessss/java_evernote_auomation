package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotePage extends BasePage{
    public NotePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public static final String newNoteButton = "//span[text()='New Note']";

    public static final String notesNumber = "//*[@id='qa-NOTES_HEADER_NOTE_COUNT']";

    public static final String openNotesList = "//*[@id=\"qa-NAV_ALL_NOTES\"]/span";

    public static final String justNow = "//div[text() = 'Just now']";

    public static final String textPlaceholder = "//textarea[@placeholder='Title']";

    public static final String lastCreatedMessage = "//button[@tabindex='0']";

    public void clickNewNoteButton(){
        waitForElement(NotePage.newNoteButton).click();
    }

    public void sendKeysToElement(String xpath, String keys){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
        element.sendKeys(keys);
    }








}
