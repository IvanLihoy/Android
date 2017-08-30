import Pages.FilesPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends DriverConfig {

    private static LoginPage loginPage;
    private static FilesPage filesPage;

    @BeforeTest(dependsOnMethods = "runApp")
    protected void initPages(){
        loginPage = new LoginPage(driver);
        filesPage = new FilesPage(driver);
    }

    @Test(groups = "login")
    protected void successLoginTest(){
        loginPage.doLogin();
    }

    @Test(groups = "upload", dependsOnGroups = "login")
    protected void uploadFileTest(){
        filesPage.uploadFile();
    }

    @Test(dependsOnGroups = {"login","upload"})
    protected void deleteFileTest(){
        filesPage.deleteFile();
    }


}
