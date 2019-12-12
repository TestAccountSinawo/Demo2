package fnb.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(how = How.ID, using = "user")
    WebElement username;
    @FindBy(how = How.ID, using = "pass")
    WebElement password;
    @FindBy(how = How.ID, using = "OBSubmit")
    WebElement loginBtn;
    @FindBy(how = How.XPATH, using = "(//h3[@class='    '])[1]")
    WebElement errorText;

    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
    }

    public void loginToFnbOnSite(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();

    }

    public String validationError() {
        return errorText.getText();
    }
}
