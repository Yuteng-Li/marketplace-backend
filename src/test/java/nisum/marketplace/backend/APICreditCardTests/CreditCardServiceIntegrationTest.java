package nisum.marketplace.backend.APICreditCardTests;


import nisum.marketplace.backend.model.CreditCard;
import nisum.marketplace.backend.service.CreditCardService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CreditCardServiceIntegrationTest {

    @Autowired
    private CreditCardService service;

    @Test
    public void getAll() throws Exception{
        List<CreditCard> list = service.getAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void getCreditCardByID() throws Exception{
        Integer id = 1;
        Assert.assertNotNull(service.getCreditCardByID(id));
    }

    @Test
    public void createCreditCard() throws Exception{
        CreditCard card = new CreditCard();
        card.setUser_id(1);
        card.setCardholder_name("Bobby Joe");
        card.setLast_four_card_number("1234");
        card.setExpiration_year("22");
        card.setExpiration_month("12");

        Assert.assertEquals(card, service.createCreditCard(card));
    }

    @Test
    public void updateCreditCard() throws Exception{
        Integer id = 9;

        CreditCard card = new CreditCard();
        card.setCredit_card_id(id);
        card.setUser_id(1);
        card.setCardholder_name("Bobby Joe");
        card.setLast_four_card_number("1234");
        card.setExpiration_year("22");
        card.setExpiration_month("12");

        Assert.assertNotNull(service.updateCreditCard(id, card));
    }

    @Test
    public void deleteCreditCardByID() throws Exception{
        Integer id = 1;
        Assert.assertTrue(service.deleteCreditCardByID(id));
    }
}
