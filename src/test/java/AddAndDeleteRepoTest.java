import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AddAndDeleteRepoTest {

    private EnvironmentManager environmentManager;
    private WebDriver driver;
    private LoginPage loginPage;
    private OtherPage otherPage;

    private String reponame = "Testjeeeeee";
    private String username = "Chunky112";
    private String password = "......";

    @Before
    public void startBrowser() {
        environmentManager = new EnvironmentManager();
        environmentManager.initWebDriver();
        driver = environmentManager.getWebDriver();
        loginPage = new LoginPage(driver);
        otherPage = new OtherPage(driver);
    }

    @Test
    public void githubTest(){
        driver.get("https://github.com/login");

        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginBtn();

//        Home
        otherPage.clickNewBtn();
        otherPage.fillRepoName(reponame);
        otherPage.clickCreateRepoBtn();

//        RepositoryPage
        otherPage.clickReadMeTxtLink();

//        FileEditorPage
        otherPage.clickCommitFileBtn();

//        Header
        otherPage.clickHomeBtnWithLogo();

//        Home
        otherPage.clickSpecificRepo(reponame);

//        RepositoryPage
        otherPage.clickSpecificRepoSettings(username, reponame);
        otherPage.clickDeleteRepo();

//        Popup
        otherPage.fillInRepoName(reponame);
        otherPage.clickConfirmDeleteRepo();

        otherPage.assertThatRepoIsDeleted(reponame);
    }

    @After
    public void tearDown() {
        environmentManager.shutDownDriver();
    }
}