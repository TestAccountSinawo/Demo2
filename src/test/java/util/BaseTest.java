package util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public void setup() {
        WebDriverManager.chromedriver().setup();
    }
}
