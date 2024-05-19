package hu.elte.selenium;

import hu.elte.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage extends BasePage {
    public ChatPage(WebDriver driver, ConfigReader configReader) {
        super(driver, configReader);
    }

    public boolean hasChatCard(String name) {
        var locator = By.xpath("//div[contains(@class,'chat-channel-card')]" +
                "//span[contains(@class, chat-channel-card__name) and text()='" + name + "']");

        return !driver.findElements(locator).isEmpty();
    }
}
