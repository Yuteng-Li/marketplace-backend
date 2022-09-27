package nisum.marketplace.backend.APIAddressTests.StepDefs;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.http.ContentType;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import io.restassured.module.webtestclient.response.WebTestClientResponse;
import nisum.marketplace.backend.AddressController;
import nisum.marketplace.backend.model.Address;

import java.util.Map;
import org.junit.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;


import java.util.List;

@CucumberContextConfiguration
public class AddressControllerIntegrationStepDefs{
    //ResponseEntity<?> res;
    static WebTestClient client;
    static WebTestClientResponse res;
    ObjectMapper mapper;
    Boolean a = Boolean.valueOf("true");
    String uri;
    //@Autowired
    //AddressController controller;
    @ParameterType(value = "true|TRUE|True|false|False|FALSE|")
    public Boolean booleanValue(String value){
        return Boolean.valueOf(value);
    }
    @DataTableType
    public Address createAddress(Map<String,String> address){
        return new Address(
                Integer.parseInt(address.get("addressId")),
                Integer.parseInt(address.get("userId")),
                address.get("name"),
                address.get("streetOne"),
                address.get("streetTwo"),
                address.get("city"),
                address.get("state"),
                address.get("zip"),
                Boolean.valueOf(address.get("billStatus")),
                Boolean.valueOf(address.get("shipStatus"))
        );
    }

    @Given("Setting up with port number {int}")
    public void setup(int port){
        uri = "http://localhost:"+ port +"/api/address/";
        System.err.println("I am in setup "+uri);
        client = WebTestClient.bindToServer().baseUrl(uri).build();
        RestAssuredWebTestClient.webTestClient(client);
        System.err.println("I finished setting up.");
        //controller = new AddressController();
    }

    @When("I send a GET request for address id {int}")
    public void getRequest(int id) throws Exception {
        System.err.println("I am in get request");
        //res = template.getForEntity(String.valueOf(id),Address.class);
        res = RestAssuredWebTestClient.given().get("getAddress/"+ id);
        //res = controller.getAddressById(id);
    }

    @Then("I should receive a status {int} if it exists.")
    public void checkResults(int statusCode){
        Assert.assertEquals(statusCode,res.getStatusCode());
    }

    @When("I send a GET request for all addresses")
    public void iSendAGETRequestForAllAddresses() {
        res = RestAssuredWebTestClient.given().get("getAllAddresses");
    }

    @When("I send a PUT request for address id: {int}")
    public void iSendAPUTRequestForAddressId(Integer addressId,List<Address> list) {
        res = RestAssuredWebTestClient.given().body(list.get(0)).contentType("application/json").put("updateAddress/"+(addressId));
        //System.err.println(res.getBody().prettyPrint());
    }

    @When("I send a POST request with a new address")
    public void iSendAPOSTRequestWithANewAddressInfoWithAddressIdForUserId(List<Address> list) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonAddress  = mapper.writeValueAsString(list.get(0));
        res = RestAssuredWebTestClient.given().body(jsonAddress).contentType(ContentType.JSON).post("createAddress");
    }

    @When("I send a DELETE request with the address id {int}")
    public void iSendADELETERequestWithTheAddressIdId(int id){
        res = RestAssuredWebTestClient.given().delete("deleteAddress/"+id);
        //System.err.println(res.getBody().prettyPrint());
    }

}
