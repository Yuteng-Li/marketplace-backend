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
public class CreditCardServiceTest {

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
        card.setUserID(1);
        card.setBankName("TEST");
        card.setCardholderName("Bobby Joe");
        card.setCardType("TEST");
        card.setCardNumber("1234567812345678");
        card.setSecurityNumber("111");
        card.setExpiration("2022-12-25");

        Assert.assertEquals(card, service.createCreditCard(card));
    }

    @Test
    public void updateCreditCard() throws Exception{
        Integer id = 12;

        CreditCard card = new CreditCard();
        card.setCreditCardID(id);
        card.setUserID(1);
        card.setBankName("TESTUPDATE");
        card.setCardholderName("Bobby Joe");
        card.setCardType("TESTUPDATE");
        card.setCardNumber("1234567812345678");
        card.setSecurityNumber("111");
        card.setExpiration("2022-12-25");

        Assert.assertNotNull(service.updateCreditCard(id, card));
    }

    @Test
    public void deleteCreditCardByID() throws Exception{
        Integer id = 1;
        Assert.assertTrue(service.deleteCreditCardByID(id));
    }
}
