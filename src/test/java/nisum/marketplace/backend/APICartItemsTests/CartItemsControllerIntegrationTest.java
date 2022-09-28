package nisum.marketplace.backend.APICartItemsTests;

import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.CartItemsController;
import nisum.marketplace.backend.Logging.LoggingTests;

import nisum.marketplace.backend.model.CartItems;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc

public class CartItemsControllerIntegrationTest {
    @LocalServerPort
    private int port = 3303;

    @Autowired
    CartItemsController cartItemsController;
    public static LoggingTests logger;
    static ResponseEntity<?> res;
    /*@BeforeAll
    public static void setUp(){
        logger.info("API TEST LOG BEGIN: CartItemsControllerTest");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        logger.info("API TEST LOG COMPLETED: CartItemsControllerTest");
    }*/


    @Test
    public void getCart_success() throws Exception{
        ResponseEntity<Object> list = cartItemsController.getCart();
        Assert.assertEquals(200,list.getStatusCodeValue());

    }

    @Test
    public void getCartByID_success() throws Exception{
        int id = 4;
        res = cartItemsController.getCartById(id);
        Assert.assertEquals(200, res.getStatusCodeValue());
    }

    @Test
    public void createCart_success() throws Exception{
        CartItems cartItems = new CartItems(2, 1, "100000000001", 1);
        res = cartItemsController.createCart(cartItems);
        Assert.assertEquals(200, res.getStatusCodeValue());
    }

    @Test
    public void updateCart_success() throws Exception{
        Integer id = 3;
        CartItems newCartItems = new CartItems(id, 1, "100000000001", 1);
        res = cartItemsController.updateCart(id, newCartItems);
        Assert.assertEquals(200, res.getStatusCodeValue());
    }

    @Test
    public void deleteCart_success() throws Exception{
        int id=3;
        res = cartItemsController.deleteCart(id);
        Assert.assertEquals(200, res.getStatusCodeValue());
    }

    //LocalPort connectivity issues. Still works
    @Test
    public void getProductByUPC_success() throws Exception{
        //String tempUrl = "localhost:8081/api/products/get/";
        String upc = "100000000001";
        res = cartItemsController.getProduct(upc);
        Assert.assertEquals(200, res.getStatusCodeValue());
    }
}
