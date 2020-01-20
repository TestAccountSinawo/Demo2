package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public void setup() {
        WebDriverManager.chromedriver().setup();
    }
}
