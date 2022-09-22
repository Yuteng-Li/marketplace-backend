package nisum.marketplace.backend;

import nisum.marketplace.backend.model.Address;
import nisum.marketplace.backend.repository.UserAddressRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AddressRepoIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserAddressRepository repo;
    public static Address newAddress = new Address(7,1,"Mary Jane",
            "123 Hell street","Upper unit","San Francisco",
            "CA","94321",false,true);
    @Test
    public void findByIdNum(){
        Integer id = 7;
        Assert.assertNotNull(repo.findById(id));
    }

    @Test
    public void saveCheck(){
        Address foundAddress;
        repo.save(newAddress);
        if(repo.findById(7).isPresent()){
            foundAddress = repo.findById(7).get();
            Assert.assertEquals(newAddress,foundAddress);
        }
    }
    @Test
    public void existById(){
        repo.save(newAddress);
        Assert.assertTrue(repo.existsById(newAddress.getAddressID()));
    }
}
