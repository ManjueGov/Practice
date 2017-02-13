package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Properties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha-lap on 13/02/2017.
 */
public class AccountActivityPage {
    public WebDriver driver;

    @FindBy(css = "a[href='/calendar']")
    private WebElement calenderLink;

    @FindBy(className = "day_number")
    private List<WebElement> daysLink;

    @FindBy(css = ".btn-xs.btn.btn-default.calendar-event")
    private List<WebElement> particularDayLink;

    @FindBy(css = "a['btn-xs btn btn-default calendar-event']")
    private WebElement calenderEventLink;

    public AccountActivityPage(WebDriver driver) {this.driver = driver; }

    public void chooseToCreateEvent() {
        WebDriverWait wait = new WebDriverWait(driver, Properties.waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(calenderLink));
        calenderLink.click();
        System.out.println("=============="+daysLink.size());
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        for(int i =0;i<daysLink.size();i++){
            if(daysLink.get(i).getText().equals(currentDate)){
                particularDayLink.get(i).click();
            }
        }
//        particularDayLink.get(daysLink.size()-1).click();
    }
}