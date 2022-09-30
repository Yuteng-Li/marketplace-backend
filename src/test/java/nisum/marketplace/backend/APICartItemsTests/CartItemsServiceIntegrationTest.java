package nisum.marketplace.backend.APICartItemsTests;

import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.service.CartItemsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

public class CartItemsServiceIntegrationTest {

    @Autowired
    private CartItemsService service;

    //private static final Logger logger = LogManager.getLogger(CartItemsControllerUnitTest.class);

    /*@Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.error(e.getMessage());
            logger.error(description.getDisplayName());
            super.failed(e, description);
        }
    };*/

    @Test
    public void updateCart() throws Exception {
        Integer id = 500;
        CartItems newCart = new CartItems(500, 22, "960113408", 23);
        Assert.assertNotNull(service.updateCart(id, newCart));
    }

    @Test
    public void getCart(){
        List<CartItems> list = service.getCart();
        Assert.assertNotNull(list);
    }

    @Test
    //Delete by CartItemId
    public void deleteById(){
        Integer id = 500;
        Assert.assertTrue(service.deleteById(id));
    }

    @Test
    //Find by CartItemId
    public void findCartById() throws Exception {
        Integer id = 500;
        Assert.assertNotNull(service.findCartById(id));
    }

    @Test
    public void createSale(){
        CartItems newCart = new CartItems(500, 22, "960113408", 32);
        Assert.assertNotNull(service.createSale(newCart));
    }
}
