package Pages;


import Utils.Tools;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Tools{

    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Sign in']")
    private WebElement signInButton;
    @FindBy(xpath = "//android.widget.EditText[@text='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//android.widget.EditText[@text='Password']")
    private WebElement passField;
    @FindBy(xpath = "//android.widget.Button[@text='SIGN IN']")
    private WebElement signInFinalbutton;
    @FindBy(xpath = "//android.widget.Button[@text='NOT NOW']")
    private WebElement notNowButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Recents']")
    private WebElement recentsLabel;

    private String popup = "//android.widget.Button[@text='YES, CONTINUE']";

    public void doLogin(){
        signInButton.click();
        waitForElementDisplayed(emailField);
        emailField.sendKeys("testusermail2017@gmail.com");
        passField.sendKeys("Password11");
        waitForElementClickable(signInFinalbutton);
        signInFinalbutton.click();
        boolean computerPopupIsNotPresent = driver.findElements(By.xpath(popup)).isEmpty();
        if(!computerPopupIsNotPresent) notNowButton.click();
        waitForElementDisplayed(recentsLabel);
    }


}
