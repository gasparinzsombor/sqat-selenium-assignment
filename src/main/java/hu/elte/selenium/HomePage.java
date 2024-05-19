package hu.elte.selenium;

import hu.elte.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final By loginButtonLocator = By.cssSelector("button.login-button");
    private final By accountButtonLocator =By.xpath(".//li[@id='current-user']");
    private final By profileButtonLocator = By.xpath(".//a[@id='user-menu-button-profile']");
    private final By logoutButtonLocator = By.cssSelector("li.logout");
    private final By preferencesButtonLocator = By.cssSelector("li.preferences");
    private final By searchButtonLocator = By.cssSelector("#search-button");
    private final By searchInputLocator = By.cssSelector("#search-term");
    private final By chatButtonLocator =
            By.xpath("//ul[contains(@class, 'icons')]//a[@href='/chat']");
    private final By chatFullscreenButtonLocator =
            By.xpath("//nav[contains(@class, 'c-navbar__actions')]//button[contains(@class, 'c-navbar__full-page-button')]");

    public HomePage(WebDriver driver, ConfigReader configReader) {
        super(driver, configReader);
    }

    public LoginPage clickLoginButton() {
        this.driver.findElement(loginButtonLocator).click();
        return new LoginPage(driver, configReader);
    }

    public void logout() {
        this.driver.findElement(accountButtonLocator).click();
        this.driver.findElement(profileButtonLocator).click();
        this.driver.findElement(logoutButtonLocator).click();
    }

    public PreferencesPage goToPreferencesPage() {
        this.driver.findElement(accountButtonLocator).click();
        this.driver.findElement(profileButtonLocator).click();
        this.driver.findElement(preferencesButtonLocator).click();

        return new PreferencesPage(driver, configReader);
    }

    public ChatPage goToChatPage() {
        this.driver.findElement(chatButtonLocator).click();
        this.driver.findElement(chatFullscreenButtonLocator).click();

        return new ChatPage(driver, configReader);
    }


    public void searchForText(String text) {
        this.driver.findElement(searchButtonLocator).click();
        this.driver.findElement(searchInputLocator).sendKeys(text);
        this.driver.findElement(searchInputLocator).sendKeys(Keys.ENTER);
        this.driver.findElement(searchInputLocator).sendKeys(Keys.ENTER);
    }

    public TopicPage goToTopicPage(String title) {
        var locator = By.xpath("//a[text()='" + title + "']");
        this.driver.findElement(locator).click();

        return new TopicPage(driver, configReader);
    }

    public void waitUntilLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountButtonLocator));
    }

}
