package steps;

import cucumber.api.java8.En;
import pages.AccountActivityPage;

import static steps.BaseSteps.pageStore;

/**
 * Created by manjunatha-lap on 13/02/2017.
 */
public class AccoutActivitySteps implements En {
    public AccoutActivitySteps() {
        And("^he choose to create an event as <calendarEvents>$", () -> {
            pageStore.get(AccountActivityPage.class).chooseToCreateEvent();
        });
    }
}
