package nisum.marketplace.backend.APIAddressTests.StepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.http.Method;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import io.restassured.module.webtestclient.response.WebTestClientResponse;
import nisum.marketplace.backend.model.Address;
import org.junit.Assert;
import org.springframework.test.web.reactive.server.WebTestClient;

@CucumberContextConfiguration
public class AddressControllerIntegrationStepDefs{
    //ResponseEntity<Address> res;
    static WebTestClient client;
    static WebTestClientResponse res;
    String uri;
    @Given("Setting up with port number {int}")
    public void setup(int port){
        uri = "http://localhost:"+ port +"/api/address/getAddress";
        System.err.println("I am in setup "+uri);
        client = WebTestClient.bindToServer().baseUrl(uri).build();
        RestAssuredWebTestClient.webTestClient(client);
        System.err.println("I finished setting up.");
    }

    @When("I send a GET request for address id {int}")
    public void getRequest(int id) throws Exception {
        System.err.println("I am in get request");
        //res = template.getForEntity(String.valueOf(id),Address.class);
        res = RestAssuredWebTestClient.given().get(String.valueOf(id));

    }

    @Then("I should receive a status 200 if it exists.")
    public void checkResults(){
        Assert.assertEquals(200,res.getStatusCode());
    }
}
