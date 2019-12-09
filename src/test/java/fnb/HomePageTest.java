package fnb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void homePageTitle() {

        String expectedTitle = "Home - First National Bank - FNB";
        driver.navigate().to("https://online.p.fnb.co.za/");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not MATCH");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
