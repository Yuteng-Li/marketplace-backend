package nisum.marketplace.backend.APICreditCardTests;


import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.CreditCardController;
import nisum.marketplace.backend.model.CreditCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CreditCardControllerIntegrationTest {
    @LocalServerPort
    private int port = 3303;

    @Autowired
    CreditCardController creditCardController;

    static ResponseEntity<?> response;


    @Test
    public void getAllCreditCards() throws Exception {
        ResponseEntity<List<CreditCard>> list = creditCardController.getAllCards();
        Assert.assertNotNull(list);
    }

    @Test
    public void getCreditCardByID(){
        Integer id = 1;
        Assert.assertNotNull(creditCardController.getCardByID(id));
    }

    @Test
    public void createCreditCard(){
        CreditCard card = new CreditCard();
        card.setUser_id(1);
        card.setCardholder_name("Bobby Joe");
        card.setLast_four_card_number("1234");
        card.setExpiration_year("22");
        card.setExpiration_month("12");

        Assert.assertEquals(card, creditCardController.createCard(card).getBody());
    }

    @Test
    public void updateCreditCardByID(){
        Integer id = 11;

        CreditCard card = new CreditCard();
        card.setCredit_card_id(id);
        card.setUser_id(1);
        card.setCardholder_name("Bobby Joe");
        card.setLast_four_card_number("1234");
        card.setExpiration_year("22");
        card.setExpiration_month("12");

        Assert.assertNotNull(creditCardController.updateCard(id, card));
    }

    @Test
    public void deleteCreditCardByID(){
        Integer id = 8;

        Assert.assertEquals(200, creditCardController.deleteCard(id).getStatusCodeValue());
    }

}
