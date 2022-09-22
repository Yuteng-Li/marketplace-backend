package nisum.marketplace.backend;

import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.service.CartItemsService;
import org.junit.Assert;
import org.junit.Test;
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

    @Test
    public void updateCart(){
        CartItems newCart = new CartItems(1, 1, "100000000001", 1);
        Assert.assertNotNull(service.updateCart(newCart));
    }

    @Test
    public void getCart(){
        List<CartItems> list = service.getCart();
        Assert.assertNotNull(list);
    }

    @Test
    //Delete by CartItemId
    public void deleteById(){
        Integer id = 3;
        Assert.assertTrue(service.deleteById(id));
    }

    @Test
    //Find by CartItemId
    public void findCartById(){
        Integer id = 2;
        Assert.assertNotNull(service.findCartById(id));
    }

    @Test
    public void createSale(){
        CartItems newCart = new CartItems(1, 1, "100000000001", 1);
        Assert.assertNotNull(service.createSale(newCart));
    }
}
