import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement pwField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String username) {
        loginField.sendKeys(username);
    }

    public void fillPassword(String password) {
        pwField.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
