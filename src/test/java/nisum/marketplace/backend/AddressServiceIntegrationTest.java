package nisum.marketplace.backend;

import nisum.marketplace.backend.model.Address;
import nisum.marketplace.backend.service.UserAddressService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

public class AddressServiceIntegrationTest {
    @Autowired
    private UserAddressService service;


    @Test
    public void getAll(){
        List<Address> list = service.getAll();
        Assert.assertNotNull(list);
    }
    @Test
    public void getAddressById() throws Exception {
        Integer id = 2;
        Assert.assertNotNull(service.getAddressById(id));
    }
    @Test
    public void deleteAddressById() throws Exception{
        Integer id = 4;
        Assert.assertTrue(service.deleteAddressById(id));
    }
    @Test
    public void updateAddress() throws Exception{
        Integer id = 1;
        int newid = 3;
        Address newAddress = new Address(1,1,"Mary Jane",
                "123 Hell street","Upper unit","San Francisco",
                "CA","94321",false,true);
        Assert.assertNotNull(service.updateAddress(id,newAddress));
    }
    @Test
    public void createAddress() throws Exception{
        Address newAddress = new Address(null,1,"Mary Jane",
                "194 The Good Place","Upper unit","San Francisco",
                "CA","94321",false,true);
        Assert.assertNotNull(service.createAddress(newAddress));
    }
}
