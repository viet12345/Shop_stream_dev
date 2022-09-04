package POM_structure.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_Page {
    //Page Factory Locator
    @FindBy(name = "email") private WebElement email_locator;

    @FindBy(name = "password") private WebElement password_locator;

    @FindBy(xpath = "//button[@class='btn w-100 form-submit py-3']") private WebElement btn_login_locator;

    @FindBy(xpath = "//a[@href='https://shop-merchant.adamo.tech/forgot-password']") private WebElement forgot_password_locator;

    @FindBy(xpath = "//a[@href='https://shop-merchant.adamo.tech/sign-up']") private WebElement sign_up_locator;

    @FindBy(xpath = "/html/body/div/main/div/div[2]/div/div/div[2]/form/div[1]/span") private WebElement mail_validate_message;

    @FindBy(xpath = "//div[@class='form-group form-group-signup']//span[@class='text-danger pt-2']") private WebElement email_validate;
    @FindBy(xpath = "//div[@class='form-group form-group-signup mt-5']//span[@class='text-danger pt-2']") private WebElement pw_validate;

    //Ham tao
    public Login_Page(WebDriver driver)
    {
        //Khoi tao page factory
        PageFactory.initElements(driver, this);
    }

    //Thuc hien login
    public void doLogin(String email, String password) throws InterruptedException {
        email_locator.sendKeys(email);
        Thread.sleep(1000);
        password_locator.sendKeys(password);
        Thread.sleep(1000);
        btn_login_locator.click();
    }

    public void doLoginfail(String email, String password, String message) throws InterruptedException {
        email_locator.sendKeys(email);
        Thread.sleep(1000);
        password_locator.sendKeys(password);
        Thread.sleep(1000);
        btn_login_locator.click();
        Thread.sleep(1000);
        switch (message) {
            case "The email field is required." -> {
                email_validate.getText().equals(message);
                System.out.println("Email là bắt buộc pass");
            }
            case "The password field is required." -> {
                pw_validate.getText().equals(message);
                System.out.println("Pw là bắt buộc pass");
            }
            default -> System.out.println("Login với thông tin sai");
        }
    }
    //Clear field
    public void clearFields (){
        email_locator.clear();
        password_locator.clear();
    }
}
