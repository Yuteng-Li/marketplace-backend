package nisum.marketplace.backend.APIUserTests;

import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.model.CreditCard;
import nisum.marketplace.backend.model.User;
import nisum.marketplace.backend.repository.UserRepo;
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
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class UserRepoIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepo repo;

    @Test
    public void getAll(){
        List<User> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getUser_id() + " " + e.getEmail()));
        Assert.assertNotNull(list);
    }

    @Test
    public void getUserByID(){
        Integer id = 1;
        System.err.println(repo.findById(id).get().getUser_id());
        Assert.assertEquals(id, repo.findById(id).get().getUser_id());
    }

    /*@Test
    public void findByEmail(){
        String email = "bobby.joe@gmail.com";
        System.err.println(repo.findByemail(email).get().getEmail());
        Assert.assertEquals(email, repo.findByemail(email).get().getEmail());
    }*/

    @Test
    public void createUser(){
        User newUser = new User(1, "test@nisum.com", "Jane", "Doe", "pass123", "1234567890");

        User savedUser = repo.save(newUser);

        System.err.println(savedUser.getUser_id() + " " + repo.findById(savedUser.getUser_id()).isPresent());
        Assert.assertTrue(repo.findById(savedUser.getUser_id()).isPresent());
    }

    @Test
    public void deleteUserByID(){
        Integer id=2;
        repo.deleteById(id);
        List<User> list = repo.findAll();
        list.forEach((e)->System.err.println(e.getUser_id()+" "+e.getEmail()));
        Assert.assertTrue(repo.findById(id).isEmpty());
    }
}
