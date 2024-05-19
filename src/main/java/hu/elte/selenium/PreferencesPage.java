package hu.elte.selenium;

import hu.elte.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreferencesPage extends BasePage {
    protected final By profileTabLocator = By.cssSelector("li.user-nav__preferences-profile");

    public PreferencesPage(WebDriver driver, ConfigReader configReader) {
        super(driver, configReader);
    }

    public ProfilePage clickProfileTab() {
        driver.findElement(profileTabLocator).click();

        return new ProfilePage(driver, configReader);
    }
}
