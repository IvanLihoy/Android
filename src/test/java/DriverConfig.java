import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverConfig {

    protected AndroidDriver driver;

    @BeforeTest(alwaysRun = true)
    protected void runApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Samsung Galaxy S7");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET,"true");
        capabilities.setCapability(MobileCapabilityType.APP,"D:\\apk_s\\DB.apk");
        capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES,"true"); // чистка системных файлов требуется после удаления приложения параметром FULL_REST
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.dropbox.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.dropbox.android.activity.DbxMainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    protected void closeApp(){
        driver.quit();
    }

}
