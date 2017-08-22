package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {

    protected AndroidDriver driver;

    protected void sleep(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
        }
    }

    protected void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementDisplayed(WebElement element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementDisplayedCss(String cssSelector) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    protected void waitForElementDisplayedXpath(String xPath) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    protected void waitForElementClickableLong(WebElement element, int pause) {
        new WebDriverWait(driver, pause).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementDisplayedLong(WebElement element, int pause) {
        new WebDriverWait(driver, pause).until(ExpectedConditions.visibilityOf(element));
    }

}
