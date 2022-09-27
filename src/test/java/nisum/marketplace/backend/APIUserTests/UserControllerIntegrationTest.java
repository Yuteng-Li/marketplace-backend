package nisum.marketplace.backend.APIUserTests;

import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.Logging.LoggingTests;
import nisum.marketplace.backend.UserController;
import nisum.marketplace.backend.model.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerIntegrationTest {
    @LocalServerPort
    private int port = 3303;

    @Autowired
    UserController userController;
    public static LoggingTests logger;
    static ResponseEntity<?> res;

    /*
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeAll
    public static void setUp(){
        logger.info("API TEST LOG BEGIN: UserControllerUnitTest");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        logger.info("API TEST LOG COMPLETED: UserControllerUnitTest");
    }*/

    @Test
    public void getAllCards() throws Exception {
        ResponseEntity<List<User>> list = userController.getAllCards();
        Assert.assertEquals(200,list.getStatusCodeValue());
    }

    @Test
    public void getUserByID_success() throws Exception{
        int id=1;
        res = userController.getUserByID(id);
        Assert.assertEquals(200,res.getStatusCodeValue());
    }

    @Test
    public void getUserByEmail_success() throws Exception{
        String email ="bobby.joe@gmail.com";
        res = userController.getUserByEmail(email);
        Assert.assertEquals(200, res.getStatusCodeValue());
    }

    //Autoincrements
    @Test
    public void createUser() throws Exception{
        User newUser = new User(13, "test@nisum.com", "Jane", "Doe", "pass123", "1234567890");
        res = userController.createUser(newUser);
        Assert.assertEquals(201, res.getStatusCodeValue());
    }
    @Test
    public void updateUser(){
        Integer id = 13;
        User updatedUser = new User(id, "test@nisum.com", "John", "Doe", "pass123", "1234567890");
        res = userController.updateUser(id, updatedUser);
        Assert.assertEquals(201, res.getStatusCodeValue());
    }

    @Test
    public void deleteUser(){
        int id=13;
        res = userController.deleteUser(id);
        Assert.assertEquals(200, res.getStatusCodeValue());
    }
}
