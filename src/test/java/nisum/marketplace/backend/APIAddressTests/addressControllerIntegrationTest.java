package nisum.marketplace.backend.APIAddressTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.Logging.LoggingTests;
import nisum.marketplace.backend.model.Address;
import org.junit.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureMockMvc

public class addressControllerIntegrationTest {
    @LocalServerPort
    private int port = 3305;
    //@Autowired
    //private MockMvc mock;
    static String baseURI;
    //@MockBean
    //private UserAddressService service;
    Address mockAddress;
    @Autowired
    private TestRestTemplate template;
    public static LoggingTests logger;
    static ResponseEntity<Address> res;

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.logFail(description.getDisplayName()+" failed. "+e.getMessage());
            super.failed(e, description);
        }
    };



    //@Autowired
    //AddressController controller;

    @BeforeClass
    public static void setUpLog() throws Exception {
        System.err.println("I set up stuff.");
        baseURI = "/api/address/";
        logger = new LoggingTests("Address","Controller Test");
        //LoggingTests.setup("Address","Controller Test");
        if(logger!=null){
            System.err.println(true);
        }

    }
    @AfterClass
    public static void tearDown(){
        logger.tearDown();
    }
    @Test
    public void getAddress() throws Exception {
        int id=2;
        System.err.println("get Address.");
        //Address mockAddress;
        //when(mockAddress = service.getAddressById(id)).thenReturn(mockAddress);
        //logger.logInfo(mockAddress.toString());
        res = this.template.getForEntity("http://localhost:"
                +port+baseURI+"getAddress/"+id, Address.class);
        //Assert.assertEquals(200,res.getStatusCodeValue());
        //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        //String convertedJson = ow.writeValueAsString(res.getBody());
        ObjectMapper map = new ObjectMapper();
        String jsonString = map.writeValueAsString(res.getBody());
        logger.logPass("Status code: "+res.getStatusCode()+"\n"+jsonString);

        //this.mock.perform(get(baseURI+"getAddress/"+id))
          //      .andExpect(status().isOk())
            //    .andDo(print());
    }
    public int getStatusCode(){
        return res.getStatusCodeValue();
    }

/*
    @Test
    public void getAllAddresses(){
        try{
            List<Address> listAddress;
            when(listAddress = service.getAll()).thenReturn(listAddress);
            ResultActions action = this.mock.perform(get(baseURI+"getAllAddresses"))
                    .andExpect(status().isOk());
            logger.logInfo(action.andDo(print()).toString());
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Test
    public void updateAddress(){
        int id=3;
        try{
            ObjectMapper map = new ObjectMapper();
            Address newAddress = new Address(3,3,"Mary Jane",
                    "123 Hell street","Upper unit","San Francisco",
                    "California","94321",false,true);
            String jsonAddress = map.writeValueAsString(newAddress);
            when(service.updateAddress(3,newAddress)).thenReturn(newAddress);
            this.mock.perform(put(baseURI+"updateAddress/"+id).content(jsonAddress).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void createAddresses() throws Exception{
        Address newAddress = new Address();
        newAddress.setCity("San Francisco");
        newAddress.setIsBilling(true);
        newAddress.setIsShipping(false);
        newAddress.setRecipientName("Billy Jane");
        newAddress.setStreet("1233 Hell St");
        newAddress.setStreet2("Upper Unit");
        newAddress.setState("California");
        newAddress.setZip("94233");
        newAddress.setUserID(5);
        newAddress.setAddressID(2);
        ObjectMapper mapper = new ObjectMapper();
        String jsonAddress = mapper.writeValueAsString(newAddress);

        //ResponseEntity<Address> res = this.template.postForEntity("http://localhost:"
		//+port+"/address/createAddress", newAddress,Address.class);


        //when(service.createAddress(newAddress)).getMock();
        this.mock.perform(post("/address/createAddress").content(jsonAddress).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void deleteAddress(){
        int id=3;
        try{
            when(service.deleteAddressById(id)).thenReturn(true);
            this.mock.perform(delete(baseURI+"deleteAddress/"+id))
                    .andExpect(status().isOk())
                    .andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

}
