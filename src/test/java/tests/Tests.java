package tests;

import Constants.Constants;
import helpers.Helpers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class Tests {
    private WebDriver driver;
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private NotePage notePage;
    private MainMenu mainMenu;

    public Tests() {
    }

    public static void login(){
        mainPage.openMainPage();
        mainPage.clickOnContinue();
        mainPage.clickOnLoin();
        loginPage.submitEmail(Constants.correctEmail);
        loginPage.submitPassword(Constants.correctPassword);
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.pathToChromedriver);
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        notePage = new NotePage(driver);
        mainMenu = new MainMenu(driver);
    }

    @Test
    public void testLoginWithWrongEmail() {
        mainPage.openMainPage();
        mainPage.clickOnContinue();
        mainPage.clickOnLoin();
        loginPage.submitEmail(Constants.wrongEmail);
        assert(loginPage.elementIsDisplayed(LoginPage.errorMessageWrongEmail));
    }

    @Test
    public void testLoginWithCorrectEmail() {
        login();
        assert(notePage.elementIsDisplayed(NotePage.newNoteButton));
    }

    @Test
    public void testLoginCreateNoteLogout() throws InterruptedException {
        login();
        assert(notePage.elementIsDisplayed(NotePage.openNotesList));
        notePage.clickElement(NotePage.openNotesList);
        int notesBefore = Helpers.extractDigit(notePage.getElementText(NotePage.notesNumber));
        notePage.clickNewNoteButton();
        notePage.waitForElement(NotePage.justNow);
        driver.switchTo().frame(driver.findElement(By.id(Constants.editorFrameId)));
        notePage.sendKeysToElement(NotePage.textPlaceholder, Constants.titleTextToEnter);
        driver.switchTo().defaultContent();
        notePage.waitForElement(NotePage.lastCreatedMessage).equals(Constants.titleTextToEnter);
        int notesAfter = Helpers.extractDigit(notePage.getElementText(NotePage.notesNumber));
        assert(notesAfter - notesBefore == 1);
        Thread.sleep(5000);
        mainMenu.clickElement(MainMenu.profileMenu);
        mainMenu.clickElement(MainMenu.logout);
        loginPage.waitForElement(LoginPage.email);
        Assert.assertEquals(Constants.urlAfterLogout, driver.getCurrentUrl());
    }

    @Test
    public void testOpenLastNoteCreated(){
        login();
        notePage.clickElement(NotePage.openNotesList);
        notePage.waitForElement(NotePage.lastCreatedMessage).click();
        notePage.waitForElement(NotePage.lastCreatedMessage).equals(Constants.titleTextToEnter);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
