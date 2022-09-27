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

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CreditCardControllerIntegrationTest {
    @LocalServerPort
    private int port = 3305;

    @Autowired
    static CreditCardController controller = new CreditCardController();
    static ResponseEntity<?> res;

    @Test
    public void createCard(){
        CreditCard card = new CreditCard();
        card.setUser_id(1);
        card.setCredit_card_id(8);
        card.setCardholder_name("Bobby Joe");
        card.setLast_four_card_number("5678");
        card.setExpiration_year("22");
        card.setExpiration_month("12");
        res = controller.createCard(card);
        Assert.assertEquals(200,res.getStatusCodeValue());
    }
    @Test
    public void getCardById(){
        res = controller.getCardByID(7);
        Assert.assertEquals(200,res.getStatusCodeValue());
    }
}
