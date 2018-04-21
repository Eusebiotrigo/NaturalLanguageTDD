package com.vlcjug.softtesting.automation;

import com.vlcjug.softtesting.stepdefinitions.SpringIntegrationTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Ignore;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class StepDefinitions extends SpringIntegrationTest {

    @When("^the client calls /api/time")
    public void theClientRequestsTheTime() {
        executeGet("http://localhost:", "/api/time");
    }

    @Then("^the client receives current hour in natural language$")
    public void theClientReceivesHourInNaturalLanguage() throws Throwable {
        final LocalDateTime now = LocalDateTime.now();
        String expectedValueInString = null;
        final int currentHour = now.getHour();
        switch (currentHour) {
            case 4:
            case 16:
                expectedValueInString = "cuatro";
                break;
            case 1:
            case 13:
                expectedValueInString = "una";
                break;
            case 5:
            case 17:
                expectedValueInString = "cinco";
                break;
            case 9:
            case 21:
                expectedValueInString = "nueve";
                break;
            case 0:
            case 12:
                expectedValueInString = "doce";
                break;
            case 11:
            case 23:
                expectedValueInString = "once";
                break;
            default:
        }

        final String returnedString = latestResponse.getBody();

        assertThat(returnedString).contains(expectedValueInString);
        if (currentHour == 1 || currentHour == 13) {
            assertThat(returnedString).startsWith("Es la ");
        } else {
            assertThat(returnedString).startsWith("Son las ");
        }
    }
}
