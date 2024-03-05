package pages;

import org.openqa.selenium.WebDriver;

public class MainMenu extends BasePage{

    public MainMenu(WebDriver driver) {
        super(driver);
    }
    public static final String profileMenu = "//span[contains(@class, 'dropdown2 submenuModal1')]";
    public static final String logout = "//*[@id='qa-ACCOUNT_DROPDOWN_LOGOUT']";
}
