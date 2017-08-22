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
    }

    @Test
    protected void successLoginTest(){
        loginPage.doLogin();
    }


}
