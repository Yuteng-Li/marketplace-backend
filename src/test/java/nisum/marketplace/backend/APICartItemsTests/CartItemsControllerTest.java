package nisum.marketplace.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.repository.CartItemsRepo;
import nisum.marketplace.backend.service.CartItemsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@ContextConfiguration(classes = BackendApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CartItemsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CartItemsRepo cartItemsRepository;

    @InjectMocks
    private CartItemsController cartItemsController = new CartItemsController();

    @Mock
    private CartItemsService cartItemsService;

    //When updating the cart via the API, the webpage should respond with a 200 Status code if the cart exists and a JSON response.
    //Or it responds with an error code(404)) if the cart does not exist

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getCart_success() throws Exception{
        this.mockMvc.perform(get("/api/cartitems/getcart")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getCartByID_success() throws Exception{
        this.mockMvc.perform(get("/api/cartitems/getcart/{id}", 1))
                //.accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createCart_success() throws Exception{

        this.mockMvc.perform(post("/api/cartitems/createcart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new CartItems(2, 1, "100000000001", 1)))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateCart_success() throws Exception{
        this.mockMvc.perform(put("/api/cartitems/updatecart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new CartItems(1, 1, "100000000001", 4)))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCart_success() throws Exception{
        this.mockMvc.perform(delete("/api/cartitems/deletecart/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk());
    }
}