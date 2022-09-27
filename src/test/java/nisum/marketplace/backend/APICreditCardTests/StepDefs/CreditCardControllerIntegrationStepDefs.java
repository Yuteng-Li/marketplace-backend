package nisum.marketplace.backend.APICreditCardTests.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import nisum.marketplace.backend.CreditCardController;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
//@CucumberContextConfiguration
public class CreditCardControllerIntegrationStepDefs {
    CreditCardController controller;
    static ResponseEntity<?> res;
    Integer ccId;

    @Given("I have a credit card {int}")
    public void i_have_a_credit_card(Integer number){
        controller = new CreditCardController();
        ccId = number;
    }
    @When("I send a GET request for the credit card")
    public void i_send_a_get_request_for_the_credit_card(){
        res = controller.getCardByID(ccId);
    }

    @Then("I should receive a status {int} if the card is found.")
    public void iShouldReceiveAStatusCodeIfTheCardIsFound(int code) {
        Assert.assertEquals(code,res.getStatusCodeValue());
    }
}
