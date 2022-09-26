package nisum.marketplace.backend.APICreditCardTests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import nisum.marketplace.backend.model.CreditCard;
import nisum.marketplace.backend.repository.CreditCardRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CreditCardRepoTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    private CreditCardRepository repo;

    @Test
    public void getAll(){
        List<CreditCard> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getCardholderName() + " " + e.getCreditCardID()));
        Assert.assertNotNull(list);
    }

    @Test
    public void getCreditCardByID(){
        Integer id = 1;
        System.err.println(repo.findById(id).get().getCreditCardID());
        Assert.assertEquals(id, repo.findById(id).get().getCreditCardID());

    }

    @Test
    public void createCreditCard(){
        CreditCard card = new CreditCard();
        card.setUserID(1);
        card.setCardholderName("Bobby Joe");
        card.setCardNumber("1234567812345678");
        card.setExpirationYear("2022");
        card.setExpirationMonth("12");

        CreditCard savedCard = repo.save(card);

        System.err.println(savedCard.getCreditCardID() + " " + repo.findById(savedCard.getCreditCardID()).isPresent());
        Assert.assertTrue(repo.findById(savedCard.getCreditCardID()).isPresent());
    }

    @Test
    public void deleteCreditCardByID(){
        Integer id = 7;

        repo.deleteById(id);
        List<CreditCard> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getCardholderName() + " " + e.getCreditCardID()));
        Assert.assertTrue(repo.findById(id).isEmpty());
    }

}
