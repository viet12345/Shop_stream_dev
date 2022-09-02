package donalduck_library.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ValidateUIHelpers {
    private final int timeOutWaitForPageLoaded = 10;

    //Ham tao
    public ValidateUIHelpers(WebDriver driver)
    {
        int timeOutWait = 5;
        WebDriverWait wait = new WebDriverWait(driver, timeOutWait);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
    }
}
