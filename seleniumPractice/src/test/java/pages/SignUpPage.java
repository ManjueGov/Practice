package pages;

import entities.SignUpDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Properties;

import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha-lap on 10/02/2017.
 */
public class SignUpPage {
    public WebDriver driver;

    @FindBy(xpath = "//div[1]/a[1]")
    private WebElement signUpButton;

    @FindBy(id = "user_first_name")
    private WebElement firstNameTextField;

    @FindBy(id = "user_last_name")
    private WebElement lastNameTextField;

    @FindBy(id = "user_email")
    private WebElement mailTextField;

    @FindBy(id = "user_password")
    private WebElement passwordTextField;

    @FindBy(id = "user_password_confirmation")
    private WebElement passwordConfirmTextField;

    @FindBy(css = "input[name='commit'][type='submit']")
    private WebElement submitButton;

    public SignUpPage(WebDriver driver){ this.driver = driver; }

    public void signUpAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Properties.waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
        driver.getWindowHandles().size();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entersLoginDetails(SignUpDetails signUpDetails) {
        firstNameTextField.click();
//        firstNameTextField.sendKeys("Aa Zz");
        firstNameTextField.sendKeys(signUpDetails.getFirstName());
        lastNameTextField.click();
//        lastNameTextField.sendKeys("A Z");
        lastNameTextField.sendKeys(signUpDetails.getLastName());
        mailTextField.click();
//        mailTextField.sendKeys("Aa1@gmail.com");
        mailTextField.sendKeys(signUpDetails.getEmailID());
        passwordTextField.click();
//        passwordTextField.sendKeys("AaBaCc12");
        passwordTextField.sendKeys(signUpDetails.getPassword());
        passwordConfirmTextField.click();
//        passwordConfirmTextField.sendKeys("AaBaCc12");
        passwordConfirmTextField.sendKeys(signUpDetails.getConfirmPassword());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        submitButton.click();
    }
}