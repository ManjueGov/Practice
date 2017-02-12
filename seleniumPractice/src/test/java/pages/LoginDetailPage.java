package pages;

import entities.LoginDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Properties;

/**
 * Created by manjunatha-lap on 12/02/2017.
 */
public class LoginDetailPage {

    public WebDriver driver;

    @FindBy(id = "user_email")
    private WebElement loginID;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(css = "input[name='commit'][type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div/ul[2]/li[2]/a")
    private WebElement logOutButton;

    public LoginDetailPage(WebDriver driver){this.driver = driver;}

    public void choosesToLogin(LoginDetails loginDetails) {
        WebDriverWait wait = new WebDriverWait(driver, Properties.waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(loginID));
        loginID.click();
        loginID.sendKeys(loginDetails.getEmailID());
        password.click();
        password.sendKeys(loginDetails.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
    }
}
