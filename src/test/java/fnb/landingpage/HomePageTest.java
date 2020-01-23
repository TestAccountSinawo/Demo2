package fnb.landingpage;

import fnb.login.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.BaseTest;

@Feature("FNBLife - Landing Page")
public class HomePageTest extends BaseTest {
    WebDriver driver;
    LoginPage homePage;

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        homePage = new LoginPage(driver);
    }

    @Description("Confirm if the user has landed on the right page")
    @Test(description = "Confirming the Title of the landing Page")
    public void homePageTitle() {
        String expectedTitle = "Home - First National Bank - FNB";
        driver.get("https://online.p.fnb.co.za/");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not MATCH");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
