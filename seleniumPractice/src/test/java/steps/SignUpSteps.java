package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import entities.SignUpDetails;
import pages.SignUpPage;
import utils.ExcelReader;

import static steps.BaseSteps.pageStore;

/**
 * Created by manjunatha-lap on 10/02/2017.
 */
public class SignUpSteps extends BaseSteps implements En {
    public SignUpSteps() {
        When("^user choose to start signup an account$", () -> {
            pageStore.get(SignUpPage.class).signUpAccount();
        });
        And("^he enters the details as (\\w+)$", (String signUpDetailsID) -> {
            SignUpDetails signUpDetails = new ExcelReader(excelSheetFileName).getSignUpDetails(signUpDetailsID);
            System.out.println(signUpDetails.getFirstName());
            pageStore.get(SignUpPage.class).entersLoginDetails(signUpDetails);
        });
    }
}