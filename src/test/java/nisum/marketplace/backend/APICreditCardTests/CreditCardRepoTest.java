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
        list.forEach((e)->System.err.println(e.getCardholder_name() + " " + e.getCredit_card_id()));
        Assert.assertNotNull(list);
    }

    @Test
    public void getCreditCardByID(){
        Integer id = 1;
        System.err.println(repo.findById(id).get().getCredit_card_id());
        Assert.assertEquals(id, repo.findById(id).get().getCredit_card_id());

    }

    @Test
    public void createCreditCard(){
        CreditCard card = new CreditCard();
        card.setUser_id(1);
        card.setCardholder_name("Bobby Joe");
        card.setLast_four_card_number("1234");
        card.setExpiration_year("22");
        card.setExpiration_month("12");

        CreditCard savedCard = repo.save(card);

        System.err.println(savedCard.getCredit_card_id() + " " + repo.findById(savedCard.getCredit_card_id()).isPresent());
        Assert.assertTrue(repo.findById(savedCard.getCredit_card_id()).isPresent());
    }

    @Test
    public void updateCreditCard(){
        CreditCard card = new CreditCard();
        card.setCredit_card_id(7);
        card.setUser_id(1);
        card.setCardholder_name("TESTBobby Joe");//setCardholderName();
        card.setLast_four_card_number("1234");//setCardNumber();
        card.setExpiration_year("22");//setExpirationYear();
        card.setExpiration_month("12");//setExpirationMonth();

        CreditCard saveCard = repo.save(card);

        Assert.assertTrue(repo.findById(saveCard.getCredit_card_id()).isPresent());

    }

    @Test
    public void deleteCreditCardByID(){
        Integer id = 18;

        repo.deleteById(id);
        List<CreditCard> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getCardholder_name() + " " + e.getCredit_card_id()));
        Assert.assertTrue(repo.findById(id).isEmpty());
    }

}
