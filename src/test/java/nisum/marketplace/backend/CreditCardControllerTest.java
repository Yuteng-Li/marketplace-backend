package nisum.marketplace.backend;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.model.CreditCard;
import nisum.marketplace.backend.service.CreditCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@ContextConfiguration(classes = BackendApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(CreditCardController.class)
public class CreditCardControllerTest {

//    @MockBean
//    private CreditCardService service;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllCardsTest() throws Exception{
        this.mvc.perform(get("/api/creditCard/getCards"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getCardByIDTest() throws Exception{
        this.mvc.perform(get("/api/creditCard/getCard/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
        //Bobby Joe is return
    }

    //CODE NEEDS TO BE UPDATED FOR IT TO BE TESTED
    @Test
    public void createCardTest() throws Exception{
        CreditCard card = new CreditCard();
        card.setUserID(1);
        card.setBankName("TEST");
        card.setCardholderName("Bobby Joe");
        card.setCardType("TEST");
        card.setCardNumber("1234567812345678");
        card.setSecurityNumber("111");
        card.setExpiration("2022-12-25");

        this.mvc.perform(post("/api/creditCard/createCard")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(card)))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    public void updateCardTest() throws Exception{
        //increment by 1 to update the card that was updated
        CreditCard card = new CreditCard();
        card.setCreditCardID(11);
        card.setUserID(1);
        card.setBankName("TESTUPDATE");
        card.setCardholderName("Bobby Joe");
        card.setCardType("TESTUPDATE");
        card.setCardNumber("1234567812345678");
        card.setSecurityNumber("111");
        card.setExpiration("2022-12-25");

        this.mvc.perform(put("/api/creditCard/updateCard/{id}", 11)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(card)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteCardTest() throws Exception{
        //increment by 1 to delete the updated card
        this.mvc.perform(delete("/api/creditCard/deleteCard/{id}", 11))
                .andExpect(status().isOk());
    }



    private static String asJsonString(final Object obj) {
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
