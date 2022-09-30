package nisum.marketplace.backend.APICartItemsTests;

import com.fasterxml.jackson.databind.ObjectMapper;

import nisum.marketplace.backend.model.CartItems;

import nisum.marketplace.backend.service.CartItemsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartItemsControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    String baseURI = "/api/cartitems/";

    @Mock
    private CartItemsService cartItemsService;

    CartItems mockCartItems;

    private static final Logger logger = LogManager.getLogger(CartItemsControllerUnitTest.class);

    //When updating the cart via the API, the webpage should respond with a 200 Status code if the cart exists and a JSON response.
    //Or it responds with an error code(404)) if the cart does not exist

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    public static void setUp(){
        logger.info("API TEST LOG BEGIN: CartItemsControllerTest");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        logger.info("API TEST LOG COMPLETED: CartItemsControllerTest");
    }


    @Test
    public void getCart_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/cartitems/getcart");

        try{
            List<CartItems> listCartItems;
            when (listCartItems = cartItemsService.getCart()).thenReturn(listCartItems);
            this.mockMvc.perform(get(baseURI+"getcart"))
                    .andExpect(status().isOk())
                    .andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched Cart");

    }

    @Test
    public void findCartByID_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/cartitems/getcart/{id}");
        Integer id = 1;
        when(mockCartItems = cartItemsService.findCartById(id)).thenReturn(mockCartItems);
        MvcResult res = this.mockMvc.perform(get(baseURI + "getcart/" + id)).andReturn();
        String body = res.getResponse().getContentAsString();
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched Cart By ID");
    }

    @Test
    public void createCart_success() throws Exception{
        logger.info("Test POST METHOD WITH ENDPOINT: /api/cartitems/createcart");
        int id = 500;
        this.mockMvc.perform(post(baseURI + "/createcart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new CartItems(id, 48, "960113408", 10)))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Created Cart");
    }

    @Test
    public void updateCart_success() throws Exception{
        logger.info("Test PUT METHOD WITH ENDPOINT: /api/cartitems/updatecart");
        int id=500;
        try{
            this.mockMvc.perform(put(baseURI + "/updatecart/" + id)
                            .content(asJsonString(new CartItems(id, 22, "960113408", 25)))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Updated Cart item");
    }

    @Test
    public void deleteCart_success() throws Exception{
        logger.info("Test DELETE METHOD WITH ENDPOINT: /api/cartitems/deletecart/{id}");
        int id = 500;
        try{
            when(cartItemsService.deleteById(id)).thenReturn(true);
            this.mockMvc.perform(delete(baseURI + "deletecart/" + id))
                    .andDo(print())
                    .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Deleted Cart item");
    }

    /*@Test
    public void getProduct_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/cartitems/productfrominvent/{upc}");
        String upc = "100000000001";
        try {
            this.mockMvc.perform(get(baseURI + "/productfrominvent/" + upc)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched Product UPC");
    }*/
}
