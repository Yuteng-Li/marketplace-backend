package nisum.marketplace.backend.APICreditCardTests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.model.CreditCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;



@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(CreditCardController.class)
public class CreditCardControllerUnitTest {

//    @MockBean
//    private CreditCardService service;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllCardsTest() throws Exception{
        MvcResult res = mvc.perform(get("/api/creditCard/getCards"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getCardByIDTest() throws Exception{
        MvcResult res = mvc.perform(get("/api/creditCard/getCard/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        //Bobby Joe is return
    }


    @Test
    public void createCardTest() throws Exception{
        CreditCard card = new CreditCard();
        card.setUser_id(1);//setUserID(1);
        card.setCardholder_name("Bobby Joe");//setCardholderName();
        card.setLast_four_card_number("1234");//setCardNumber();
        card.setExpiration_year("22");//setExpirationYear();
        card.setExpiration_month("12");//setExpirationMonth();


        MvcResult res = mvc.perform(post("/api/creditCard/createCard")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(card)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

    }
//
    @Test
    public void updateCardTest() throws Exception{
//        //increment by 1 to update the card that was updated

        CreditCard card = new CreditCard();
        card.setCredit_card_id(7);//setUserID(1);
        card.setUser_id(1);
        card.setCardholder_name("TESTBobby Joe");//setCardholderName();
        card.setLast_four_card_number("1234");//setCardNumber();
        card.setExpiration_year("22");//setExpirationYear();
        card.setExpiration_month("12");//setExpirationMonth();

        MvcResult res = mvc.perform(put("/api/creditCard/updateCard/{id}", 7)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(card)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void deleteCardTest() throws Exception{
        //increment by 1 to delete the updated card

        MvcResult res = mvc.perform(delete("/api/creditCard/deleteCard/{id}", 11))
                .andExpect(status().isOk())
                .andReturn();
    }



    private static String asJsonString(final Object obj) {
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
