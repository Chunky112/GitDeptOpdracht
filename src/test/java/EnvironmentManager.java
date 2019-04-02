import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {

    private WebDriver driver;

    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/Andy/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        this.driver = driver;
    }

    public void shutDownDriver() {
        this.driver.quit();
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }
}
