package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public static final String email = "//*[@id='username']";
    public static final String password = "//*[@id=\"password\"]";
    public static final String submitButton = "//input[@name='evaluateUsername' and @id='loginButton']";
    public static final String signInButton = "//input[@name='login' and @id='loginButton']";
    public static final String errorMessageWrongEmail = "//div[@id='responseMessage' and contains(text(), 'There is no account for the username or email you entered.')]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void submitEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPage.email)));
        emailField.click();
        emailField.sendKeys(email);
        waitForElement(LoginPage.submitButton).click();
    }

    public void submitPassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPage.password)));
        passwordField.click();
        passwordField.sendKeys(password);
        waitForElement(LoginPage.signInButton).click();
    }
}
