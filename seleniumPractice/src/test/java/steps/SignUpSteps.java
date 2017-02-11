package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import pages.SignUpPage;

import static steps.BaseSteps.pageStore;

/**
 * Created by manjunatha-lap on 10/02/2017.
 */
public class SignUpSteps extends BaseSteps implements En {
    public SignUpSteps() {
        When("^user choose to start signup an account$", () -> {
            pageStore.get(SignUpPage.class).signUpAccount();
        });
        And("^he enters the details for signup$", () -> {
            pageStore.get(SignUpPage.class).entersLoginDetails();
        });
    }
}