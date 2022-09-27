package nisum.marketplace.backend.APIUserTests;

import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.model.User;
import nisum.marketplace.backend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService service;

    @Test
    public void getAll(){
        List<User> list = service.getAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void getUserById() throws Exception {
        Integer id = 2;
        Assert.assertNotNull(service.getUserByID(id));
    }

    @Test
    public void getUserEmail() throws Exception {
        String email = "bobby.joe@gmail.com";
        Assert.assertNotNull(service.getUserEmail(email));
    }

    @Test
    public void CreateUser() throws Exception {
        User newUser = new User(1, "test@nisum.com", "Jane", "Doe", "pass123", "1234567890");
        Assert.assertNotNull(service.createUser(newUser));
    }

    @Test
    public void updateUser() throws Exception {
        Integer id = 2;
        User updatedUser = new User(1, "test@nisum.com", "John", "Doe", "pass123", "1234567890");
        Assert.assertNotNull(service.updateUser(id, updatedUser));
    }

    @Test
    public void deleteUserByID() throws Exception {
        Integer id = 3;
        Assert.assertTrue(service.deleteUserByID(id));
    }
}
