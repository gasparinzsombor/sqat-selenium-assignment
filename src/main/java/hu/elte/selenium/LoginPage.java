package hu.elte.selenium;

import hu.elte.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInputLocator = By.xpath("//form[@id='login-form']//input[@id='login-account-name']");
    private final By passwordInputLocator = By.xpath("//form[@id='login-form']//input[@id='login-account-password']");
    private final By loginButtonLocator = By.xpath("//button[@id='login-button']");

    public LoginPage(WebDriver driver, ConfigReader configReader) {
        super(driver, configReader);
    }

    public HomePage login() {
        var username = configReader.get("username");
        var password = configReader.get("password");

        driver.findElement(usernameInputLocator).sendKeys(username);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();

        var home = new HomePage(driver, configReader);
        home.waitUntilLoggedIn();

        return home;
    }
}
