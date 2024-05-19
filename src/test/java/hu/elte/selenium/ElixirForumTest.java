package hu.elte.selenium;

import hu.elte.config.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElixirForumTest {
    private WebDriver driver;
    private HomePage homePage;
    private ConfigReader configReader;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        var options = new ChromeOptions();

        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        configReader = new ConfigReader();

        homePage = new HomePage(driver, configReader);
    }

    @Test
    public void loginLogoutTest() {
        visitHome();

        var homePage = this.homePage.clickLoginButton().login();
        homePage.logout();
    }

    @Test
    public void searchTest() {
        visitHome();

        var homePage = this.homePage.clickLoginButton().login();

        var searchParam = configReader.get("searchParameter");

        homePage.searchForText(searchParam);
    }

    @Test
    public void staticPagesTest() {
        var pageUrls = configReader.getArray("staticPageUrls");
        var pageTitles = configReader.getArray("staticPageTitles");

        for (int i = 0; i < pageUrls.length; i++) {
            driver.get(pageUrls[i]);

            assertEquals(pageTitles[i], driver.getTitle());
        }
    }

    @Test
    public void visitPreferencesPageTest() {
       visitHome();

        this.homePage
                .clickLoginButton()
                .login()
                .goToPreferencesPage();
    }

    @Test
    public void visitChatPageTest() {
       visitHome();

        var chatPage = this.homePage
                .clickLoginButton()
                .login()
                .goToChatPage();

        var chatName = configReader.get("chatName");

        assertTrue(chatPage.hasChatCard(chatName));
    }

    @Test
    public void changeProfileInfoTest() {
        visitHome();

        this.homePage
                .clickLoginButton()
                .login()
                .goToPreferencesPage()
                .clickProfileTab()
                .fillInProfileData();
    }

    @Test
    public void openTopicPageTest() {
        visitHome();

        var title = configReader.get("topicTitle");
        var topicPage = this.homePage.goToTopicPage(title);

        assertTrue(topicPage.hasTitle(title));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private void visitHome() {
        var baseUrl = configReader.get("baseUrl");
        this.driver.get(baseUrl);
    }
}
