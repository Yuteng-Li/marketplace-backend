package nisum.marketplace.backend.APIAddressTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.AddressController;
import nisum.marketplace.backend.model.Address;
import nisum.marketplace.backend.service.UserAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressController.class)
public class AddressControllerUnitTest {
    @Autowired
    private MockMvc mock;
    String baseURI = "/api/address/";
    @MockBean
    private UserAddressService service;
    Address mockAddress;

    @Test
    public void getAddress() throws Exception {
        int id=2;
        //Address mockAddress;
        when(mockAddress = service.getAddressById(id)).thenReturn(mockAddress);
        this.mock.perform(get(baseURI+"getAddress/"+id))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getAllAddresses(){
        try{
            List<Address> listAddress;
            when(listAddress = service.getAll()).thenReturn(listAddress);
            this.mock.perform(get(baseURI+"getAllAddresses"))
                    .andExpect(status().isOk())
                    .andDo(print());
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
                    "CA","94321",false,true);
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

        /*ResponseEntity<Address> res = this.template.postForEntity("http://localhost:"
		+port+"/address/createAddress", newAddress,Address.class);

         */
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
    }

}
