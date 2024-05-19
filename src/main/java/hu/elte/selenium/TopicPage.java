package hu.elte.selenium;

import hu.elte.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopicPage extends BasePage {
    public TopicPage(WebDriver driver, ConfigReader configReader) {
        super(driver, configReader);
    }

    public boolean hasTitle(String title) {
        var locator = By.xpath("//div[contains(@class, 'title-wrapper')]//a[text()='" + title + "']");
        return !this.driver.findElements(locator).isEmpty();
    }
}
