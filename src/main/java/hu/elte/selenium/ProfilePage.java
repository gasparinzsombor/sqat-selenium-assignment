package hu.elte.selenium;

import hu.elte.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends PreferencesPage {

    private final By userBioTextareaLocator = By.cssSelector("div[data-setting-name='user-bio'] textarea");
    private final By timezoneDropdownLocator = By.cssSelector("div.pref-timezone summary");
    private final By timezoneOptionLocator = By.cssSelector("div.pref-timezone li[data-name='Europe/Budapest']");
    private final By locationInputLocator = By.cssSelector("input#edit-location");
    private final By websiteInputLocator = By.cssSelector("input#edit-website");
    private final By progLanguagesUsedInputLocator =
            By.cssSelector("div.user-field-programming-languages-used input");
    private final By progLanguagesInterestedInputLocator =
            By.cssSelector("div.user-field-programming-languages-interested-in input");
    private final By booksReadInputLocator =
            By.cssSelector("div.user-field-which-elixir-books-have-you-gotread input");
    private final By devOsInputLocator = By.cssSelector("div.user-field-dev-os input");
    private final By prodOsInputLocator = By.cssSelector("div.user-field-production-os input");
    private final By workInputLocator = By.cssSelector("div.user-field-work input");
    private final By saveProfileButtonLocator = By.cssSelector("button.save-changes");


    public ProfilePage(WebDriver driver, ConfigReader configReader) {
        super(driver, configReader);
    }

    public void fillInProfileData() {
        var userBio = configReader.get("userBio");
        this.driver.findElement(userBioTextareaLocator).clear();
        this.driver.findElement(userBioTextareaLocator).sendKeys(userBio);

        this.driver.findElement(timezoneDropdownLocator).click();
        this.driver.findElement(timezoneOptionLocator).click();

        var location = configReader.get("location");
        this.driver.findElement(locationInputLocator).clear();
        this.driver.findElement(locationInputLocator).sendKeys(location);

        var website = configReader.get("website");
        this.driver.findElement(websiteInputLocator).clear();
        this.driver.findElement(websiteInputLocator).sendKeys(website);

        var progLanguagesUsed = configReader.get("programmingLanguagesUsed");
        this.driver.findElement(progLanguagesUsedInputLocator).clear();
        this.driver.findElement(progLanguagesUsedInputLocator).sendKeys(progLanguagesUsed);

        var progLanguagesInterested = configReader.get("programmingLanguagesInterestedIn");
        this.driver.findElement(progLanguagesInterestedInputLocator).clear();
        this.driver.findElement(progLanguagesInterestedInputLocator).sendKeys(progLanguagesInterested);

        var booksRead = configReader.get("booksRead");
        this.driver.findElement(booksReadInputLocator).clear();
        this.driver.findElement(booksReadInputLocator).sendKeys(booksRead);

        var devOs = configReader.get("devOS");
        this.driver.findElement(devOsInputLocator).clear();
        this.driver.findElement(devOsInputLocator).sendKeys(devOs);

        var prodOs = configReader.get("prodOS");
        this.driver.findElement(prodOsInputLocator).clear();
        this.driver.findElement(prodOsInputLocator).sendKeys(prodOs);

        var work = configReader.get("work");
        this.driver.findElement(workInputLocator).clear();
        this.driver.findElement(workInputLocator).sendKeys(work);

        this.driver.findElement(saveProfileButtonLocator).click();
    }
}
