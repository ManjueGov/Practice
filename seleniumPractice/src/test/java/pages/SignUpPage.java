package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Properties;

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

    public void entersLoginDetails() {
        firstNameTextField.click();
        firstNameTextField.sendKeys("Aa Zz");
        lastNameTextField.click();
        lastNameTextField.sendKeys("A Z");
        mailTextField.click();
        mailTextField.sendKeys("Aa1@gmail.com");
        passwordTextField.click();
        passwordTextField.sendKeys("AaBaCc12");
        passwordConfirmTextField.click();
        passwordConfirmTextField.sendKeys("AaBaCc12");
    }
}