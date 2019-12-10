package fnb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(how = How.ID, using = "user")
    WebElement username;
    @FindBy(how = How.ID, using = "pass")
    WebElement password;
    @FindBy(how = How.ID, using = "OBSubmit")
    WebElement loginBtn;

    WebDriverWait wait;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,60);
    }
    public void loginToFnbOnSite(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
