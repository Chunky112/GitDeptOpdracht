import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtherPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //	HOME
    @FindBy(xpath = "//h2[contains(.,\"Repositories\")]//a[@href='/new']")
    private WebElement newBtn;

    @FindBy(xpath = "//input[@name='repository[name]']")
    private WebElement repoNameField;

    @FindBy(xpath = "//button[contains(.,'Create repository')]")
    private WebElement createRepoBtn;

    //	REPO PAGE
    @FindBy(xpath = "//a[contains(.,'README')]")
    private WebElement readMeLinkText;

    //  FILE EDITOR PAGE
    @FindBy(xpath = "//button[contains(.,'Commit new file')]")
    private WebElement commitFileBtn;

    //	HEADER MENU
    @FindBy(xpath = "//a[@class='header-logo-invertocat']")
    private WebElement homeBtnWithLogo;

    //	REPO PAGE
    @FindBy(xpath = "//summary[contains(.,'Delete')]")
    private WebElement deleteRepoBtn;

    //	POP UP @ RepoPage
    @FindBy(xpath = "//details-dialog[@aria-label='Delete repository']//input[@name='verify']")
    private WebElement repoNameInputField;

    @FindBy(xpath = "//details-dialog[@aria-label='Delete repository']//button[@type='submit']")
    private WebElement confirmDeleteRepoBtn;


    public OtherPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver,15);
    }

    public void clickNewBtn() {
        newBtn.click();
    }

    public void fillRepoName(String name) {
        repoNameField.sendKeys(name);
    }

    public void clickReadMeTxtLink() {
        readMeLinkText.click();
    }

    public void clickCommitFileBtn() {
        commitFileBtn.click();
    }

    public void clickHomeBtnWithLogo() {
        homeBtnWithLogo.click();
    }

    public void fillInRepoName(String keysToSend) {
        repoNameInputField.sendKeys(keysToSend);
    }

    public void clickConfirmDeleteRepo() {
        confirmDeleteRepoBtn.click();
    }

    public void clickCreateRepoBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='repository_name'][contains(@class,'autocheck-successful')]")));
        createRepoBtn.click();
    }

    public void clickSpecificRepo(String reponame) {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[@title='"+reponame+"']"))).click();
    }

    public void clickSpecificRepoSettings(String username, String reponame) {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//a[@href='/"+username+"/"+reponame+"/settings']"))).click();
    }

    public void clickDeleteRepo() {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//summary[contains(.,'Delete')]"))).click();
    }

    public void assertThatRepoIsDeleted(String reponame) {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//a[contains(.,'Explore GitHub')]")));
        Assert.assertTrue("Deleten van de repo ging niet goed.",
                driver.findElements(By.xpath("//span[@title='"+reponame+"']")).size() < 1);
    }
}