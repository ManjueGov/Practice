package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.BaseSteps;

import java.util.Iterator;
import java.util.List;

/**
 * Created by manjunatha-lap on 13/02/2017.
 */
public class BasePage {

    public WebDriver driver;

    protected void clickLinkByHref(String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        System.out.println("\n "+anchors.size());
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }
}