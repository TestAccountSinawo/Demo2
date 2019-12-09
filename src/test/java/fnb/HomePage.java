package fnb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Factory;

public class HomePage {

    @FindBy(how = How.ID, using = "user")
    WebElement username;
    @FindBy(how = How.ID, using = "pass")
    WebElement password;
    @FindBy(how = How.ID, using = "OBSubmit")
    WebElement loginBtn;

    public HomePage(){

    }
    public void loginToFnbOnSite(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
