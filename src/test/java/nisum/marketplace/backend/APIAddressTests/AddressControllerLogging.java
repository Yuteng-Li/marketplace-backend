/*package nisum.marketplace.backend.APIAddressTests;

import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.LoggingTests;
import nisum.marketplace.backend.model.Address;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ContextConfiguration(classes= BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc

 */
public class AddressControllerLogging {
    /*
    @LocalServerPort
    private int port = 3305;
    //@Autowired
    //private MockMvc mock;
    String baseURI = "/address/";
    //@MockBean
    //private UserAddressService service;
    Address mockAddress;
    @Autowired
    private static TestRestTemplate template;
    public static LoggingTests logger;

    //@Autowired
    //AddressController controller;

    @BeforeClass
    public static void setUpLog(){
        System.err.println("I set up stuff.");
        template = new TestRestTemplate();
        logger = new LoggingTests("Address","Controller Test");
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
        ResponseEntity<Address> res = this.template.getForEntity("http://localhost:"
                +port+"/api/address/getAddress/"+id, Address.class);
        Assert.assertEquals(200,res.getStatusCodeValue());
        //logger.logPass("Status code: "+res.getStatusCode()+"\n"+res.getBody().toString());
        //this.mock.perform(get(baseURI+"getAddress/"+id))
          //      .andExpect(status().isOk())
            //    .andDo(print());
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
