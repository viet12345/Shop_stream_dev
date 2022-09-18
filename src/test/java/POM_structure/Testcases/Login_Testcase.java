package POM_structure.Testcases;

import donalduck_library.helper.*;
import POM_structure.Base.Setup_Base;
import POM_structure.Pages.Login_Page;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class Login_Testcase extends Setup_Base {
    private WebDriver driver;
    public Login_Page LoginPage;

    @BeforeClass
    public void setUp() throws Exception {
        driver = getDriver();
//        recordVideoHelpers.startRecord("Login screen");
    }

    @Test
    public void signIn1() throws FileNotFoundException, InterruptedException {
        LoginPage = new Login_Page(driver);
        LoginPage.doLogin("viet1@adamodigital.com","12345678");
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://brands-dev.shopstream360.com/");
    }

    @Test (dataProvider = "loginData")
    public void signIn2(String username, String password,String message) throws InterruptedException {
        LoginPage = new Login_Page(driver);
        LoginPage.doLoginfail(username,password,message);
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://brands-dev.shopstream360.com/sign-in");
    }


    @DataProvider
    public Object[][] loginData() throws InterruptedException {
        return new Object[][]
                {
                        { "", "12345678","The email field is required." },
                        { "viet1@gmail.com", "","The password field is required."},
                        { "viet1@gmail.com", "123123123","Password or email do not correct"}
                };
    }


//    @AfterMethod
//    public void takeScreenshot(ITestResult result) throws InterruptedException {
//        Thread.sleep(1000);
//        if (ITestResult.FAILURE == result.getStatus())
//        {
//            captureHelpers.captureScreenshot(driver, "Login screen");
//        }
//    }
}




