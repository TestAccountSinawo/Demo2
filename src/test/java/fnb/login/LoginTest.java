package fnb.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.BaseTest;

import static fnb.data.TestData1.CorrectData.*;
import static fnb.data.TestData1.IncorrectData.*;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerFactory.getLogger(HeadlessTest.class);

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        driver.get("https://online.p.fnb.co.za/");
        wait = new WebDriverWait(driver, 60);
    }

    @Test(description = "The unregistered user should not be able to login to the online portal")
    public void unsuccessfulLogin() {
        loginPage.loginToFnbOnSite(INCORRECT_USERNAME, INCORRECT_PASSWORD);

        if (driver.getCurrentUrl().equals("https://online.p.fnb.co.za/")) {
            String pageSource = driver.getPageSource();
            Assert.assertTrue(pageSource.contains(VALIDATION_ERROR), "Login was not successful!");
            log.info("====Displayed message ====: {}",pageSource);
        } else {
            System.out.println("Not navigated to the correct page");
        }
    }

    @Test(description = "As the registered user I should be able to login to the Online Portal")
    public void successfulLogin() throws InterruptedException {
        loginPage.loginToFnbOnSite(CORRECT_USERNAME, CORRECT_PASSWORD);
        String loginPageTitle = driver.getTitle();
        System.out.println(loginPageTitle);
        Assert.assertEquals(loginPageTitle, "Home - First National Bank - FNB", "Make sure you are successfully logged on");
        log.info("===Page Title: {}===",loginPageTitle);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
