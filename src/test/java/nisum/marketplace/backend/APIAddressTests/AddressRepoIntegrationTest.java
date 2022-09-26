package nisum.marketplace.backend.APIAddressTests;

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
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AddressRepoIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserAddressRepository repo;
    //public static Address newAddress = new Address(7,1,"Mary Jane",
      //      "123 Hell street","Upper unit","San Francisco",
        //    "CA","94321",false,true);
    @Test
    public void findByIdNum(){
        Integer id = 6;
        System.err.println(repo.findById(id).get().getAddressID());
        Assert.assertEquals(id,repo.findById(id).get().getAddressID());
    }
    @Test
    public void delete(){
        Integer id=63;
        repo.deleteById(id);
        List<Address> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getRecipientName()+" "+e.getAddressID()));
        Assert.assertTrue(repo.findById(id).isEmpty());
    }
    @Test
    public void getAll(){
        List<Address> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getRecipientName()+" "+e.getAddressID()));
        Assert.assertNotNull(list);
    }
    @Test
    public void saveCheck(){
        Address newAddress = new Address(null,2,"Mary Jane",
                     "123 Hell street","Upper unit","San Francisco",
                   "CA","94321",false,true);
        Address savedAddress = repo.save(newAddress);
        System.err.println(savedAddress.getAddressID()+" "+repo.findById(savedAddress.getAddressID()).isPresent());
        Assert.assertTrue(repo.findById(savedAddress.getAddressID()).isPresent());

    }
    @Test
    public void existById(){
        Integer id=6;
        System.err.println(repo.findById(id).get().getAddressID());
        Assert.assertTrue(repo.existsById(id));
    }
}
