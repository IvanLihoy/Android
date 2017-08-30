package Pages;


import Utils.Tools;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesPage extends Tools{

    public FilesPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Files']")
    private WebElement filesLabel;

    // For file uploading:
    @FindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'fab_button')]")
    private WebElement plusButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Upload files']")
    private WebElement uploadFilesButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Amaze']")
    private WebElement amazeFilesManager;
    @FindBy(xpath = "//android.widget.TextView[@text='TestFile.txt']")
    private WebElement testFile;
    @FindBy(xpath = "//android.widget.Button[@text='ALLOW']")
    private WebElement allowAccesButton;
    private String ALLOW_ACCESS = "//android.widget.Button[@text='ALLOW']";
    private String OUR_FILE = "//android.widget.TextView[@text='TestFile.txt']";

    // For file removing:
    @FindBy(xpath = "//android.widget.TextView[@text='TestFile.txt']/following-sibling::android.widget.ImageView[@content-desc='list_item_right_side_image']")
    private WebElement fileMenu;
    @FindBy(xpath = "//android.widget.TextView[@text='Delete']")
    private WebElement deleteButton;
    @FindBy(xpath = "//android.widget.Button[@text='DELETE']")
    private WebElement confirmdeleteButton;

    public void uploadFile(){
        filesLabel.click();
        boolean fileIsNotPresent = driver.findElementsByXPath(OUR_FILE).isEmpty();
        if (!fileIsNotPresent){ deleteFile();}
        waitForElementDisplayed(plusButton);
        plusButton.click();
        waitForElementDisplayed(uploadFilesButton);
        uploadFilesButton.click();
        sleep(2);
        waitForElementDisplayed(amazeFilesManager);
        amazeFilesManager.click();
        waitForElementDisplayed(testFile);
        testFile.click();
        boolean accessPopupIsNotPresent = driver.findElementsByXPath(ALLOW_ACCESS).isEmpty();
        if (!accessPopupIsNotPresent) allowAccesButton.click();
        waitForElementDisplayed(testFile);

    }

    public void deleteFile(){
        waitForElementDisplayed(testFile);
        fileMenu.click();
        waitForElementDisplayed(deleteButton);
        deleteButton.click();
        waitForElementDisplayed(confirmdeleteButton);
        confirmdeleteButton.click();
        sleep(2);
    }


}
