package nisum.marketplace.backend.APICartItemsTests;

import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.repository.CartItemsRepo;
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
public class CartItemsRepoIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CartItemsRepo repo;

    @Test
    public void findCartById(){
        Integer id = 500;
        System.err.println(repo.findById(id).get().getCart_item_id());
        Assert.assertEquals(id,repo.findById(id).get().getCart_item_id());
    }
    @Test
    public void deleteById(){
        Integer id=500;
        repo.deleteById(id);
        List<CartItems> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getUser_id()+" "+e.getCart_item_id()));
        Assert.assertTrue(repo.findById(id).isEmpty());
    }
    @Test
    public void getAll(){
        List<CartItems> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getUser_id()+" "+e.getCart_item_id()));
        Assert.assertNotNull(list);
    }
    @Test
    public void saveCheck(){
        CartItems newCart = new CartItems(500,22,"960113408", 1);
        CartItems savedCart = repo.save(newCart);
        System.err.println(savedCart.getCart_item_id()+" "+repo.findById(savedCart.getCart_item_id()).isPresent());
        Assert.assertTrue(repo.findById(savedCart.getCart_item_id()).isPresent());

    }
    @Test
    public void existById(){
        Integer id=500;
        System.err.println(repo.findById(id).get().getCart_item_id());
        Assert.assertTrue(repo.existsById(id));
    }
}
