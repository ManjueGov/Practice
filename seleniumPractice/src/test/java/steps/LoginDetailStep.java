package steps;

import cucumber.api.java8.En;
import entities.LoginDetails;
import pages.LoginDetailPage;
import utils.ExcelReader;

import static steps.BaseSteps.pageStore;

/**
 * Created by manjunatha-lap on 12/02/2017.
 */
public class LoginDetailStep extends BaseSteps implements En {
    public LoginDetailStep() {
        And("^he chooses to login as (\\w+)$", (String loginDetailsID) -> {
            LoginDetails loginDetails = new ExcelReader(excelSheetFileName).getLoginDetails(loginDetailsID);
            System.out.println(loginDetails.getEmailID());
            pageStore.get(LoginDetailPage.class).choosesToLogin(loginDetails);
        });
    }
}
