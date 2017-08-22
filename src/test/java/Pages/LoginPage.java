package Pages;


import Utils.Tools;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Tools{

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button[@text='LOG IN']")
    private WebElement loginButton;
    @FindBy(xpath = "//android.widget.EditText[@text='Email Address']")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passField;
    @FindBy(xpath = "//android.widget.Button[@content-desc='Log In Log In']")
    private WebElement loginFinalbutton;
    @FindBy(xpath = "//android.widget.TextView[@text='All Files']")
    private WebElement allFiles;
    @FindBy(xpath = "//android.widget.Button[@text='ALLOW']")
    private WebElement allowAccessButton;
    private String allowAccess = "//android.widget.Button[@text='ALLOW']";

    public void doLogin(){
        loginButton.click();
        waitForElementDisplayed(emailField);
        emailField.sendKeys("testusermail2017@gmail.com");
        passField.sendKeys("Password11");
        waitForElementClickable(loginFinalbutton);
        loginFinalbutton.click();
        boolean accessWindowNotRequired = driver.findElements(By.xpath(allowAccess)).isEmpty();
        if(!accessWindowNotRequired) allowAccessButton.click();
        waitForElementDisplayed(allFiles);
    }


}
