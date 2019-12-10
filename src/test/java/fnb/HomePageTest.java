package fnb;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.BaseTest;

public class HomePageTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        super.setup();
        System.out.println("First line");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Description("Confirming the Title of the landing Page")
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
