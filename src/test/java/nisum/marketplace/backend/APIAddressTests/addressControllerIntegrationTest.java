package nisum.marketplace.backend.APIAddressTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.AddressController;
import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.Logging.LoggingTests;
import nisum.marketplace.backend.model.Address;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureMockMvc

public class addressControllerIntegrationTest {
    @LocalServerPort
    private int port = 3305;
    static String baseURI;
    //@Autowired
    //private TestRestTemplate template;
    @Autowired
    AddressController addressController;
    public static LoggingTests logger;
    static ResponseEntity<?> res;
/*
    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.logFail(description.getDisplayName()+" failed. "+e.getMessage());
            super.failed(e, description);
        }
    };

    @BeforeClass
    public static void setUpLog() throws Exception {
        System.err.println("I set up stuff.");
        baseURI = "/api/address/";
        logger = new LoggingTests("Address","Controller Test");
        //LoggingTests.setup("Address","Controller Test");
    }
    @AfterClass
    public static void tearDown(){
        logger.tearDown();
    }

 */
    //@Test
    public ResponseEntity<?> getAddress(Integer addressId) throws Exception {
        int id=2;
        System.err.println("get Address.");
        //res = this.template.getForEntity("http://localhost:"
          //      +port+baseURI+"getAddress/"+id, Address.class);
        //Assert.assertEquals(200,res.getStatusCodeValue());
        ObjectMapper map = new ObjectMapper();
        String jsonString = map.writeValueAsString(res.getBody());
        res = addressController.getAddressById(addressId);
        return res;
        //logger.logPass("Status code: "+res.getStatusCode()+"\n"+jsonString);

    }
    public int getStatusCode(){
        return res.getStatusCodeValue();
    }

    //@Test
    public ResponseEntity<?> createAddresses(Address address) throws Exception{
        Address newAddress = new Address();
        newAddress.setCity("San Francisco");
        newAddress.setIsBilling(true);
        newAddress.setIsShipping(false);
        newAddress.setRecipientName("Billy Jane");
        newAddress.setStreet("1233 Hell St");
        newAddress.setStreet2("Upper Unit");
        newAddress.setState("CA");
        newAddress.setZip("94233");
        newAddress.setUserID(1);
        newAddress.setAddressID(6);
        ObjectMapper mapper = new ObjectMapper();
        String jsonAddress = mapper.writeValueAsString(newAddress);
        ResponseEntity<?> createdAddress = addressController.createAddress(address);
        //res = this.template.postForEntity("http://localhost:"
          //      +port+"/api/address/createAddress", newAddress,Address.class);
        //Assert.assertEquals(201,res.getStatusCodeValue());
        Assert.assertEquals(201,createdAddress.getStatusCodeValue());
        return createdAddress;
    }

    //@Test
    public ResponseEntity<List<Address>> getAllAddresses(){
        //logger.logInfo(action.andDo(print()).toString());
        return addressController.getAllAddresses();
    }

    //@Test
    public ResponseEntity<?> updateAddress(Integer addressId, Address address){
        int id=3;
        try{
            ObjectMapper map = new ObjectMapper();
            Address newAddress = new Address(3,3,"Mary Jane",
                    "123 Hell street","Upper unit","San Francisco",
                    "California","94321",false,true);
            String jsonAddress = map.writeValueAsString(newAddress);
            res  = addressController.updateAddress(addressId,address);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


    //@Test
    public ResponseEntity<?> deleteAddress(Integer addressId){
        int id=3;
        try{
           res = addressController.deleteAddress(addressId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
