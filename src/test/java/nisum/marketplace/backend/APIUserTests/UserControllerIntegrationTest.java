package nisum.marketplace.backend.APIUserTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.Logging.LoggingTests;
import nisum.marketplace.backend.UserController;
import nisum.marketplace.backend.model.Address;
import nisum.marketplace.backend.model.User;
import nisum.marketplace.backend.repository.UserRepo;
import nisum.marketplace.backend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= BackendApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class UserControllerIntegrationTest {
    @LocalServerPort
    private int port = 3306;
    static String baseURI;

    @Autowired
    UserController userController;
    public static LoggingTests logger;
    static ResponseEntity<?> res;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public int getStatusCode(){
        return res.getStatusCodeValue();
    }

    public ResponseEntity<List<User>> getAllCards() throws Exception {
        //logger.logInfo(action.andDo(print()).toString());
        return userController.getAllCards();
    }

    @Test
    public void getUserByID_success() throws Exception{
        int id=1;
        System.err.println("get UserID.");
        res = userController.getUserByID(id);
        System.err.println(res.getBody());
        Assert.assertEquals(200, res.getStatusCodeValue());
    }

    @Test
    public void getUserByEmail_success() throws Exception{
        String email ="bobby.joe@gmail.com";
        System.err.println("get User by Email.");
        res = userController.getUserByEmail(email);
        System.err.println(res.getBody());
        Assert.assertEquals(200, res.getStatusCodeValue());
    }

    //Needs editing
    public ResponseEntity<?> createUser(User user) throws Exception{
        User newUser = new User(6, "test@nisum.com", "Jane", "Doe", "pass123", "1234567890");

        ResponseEntity<?> createdUser = userController.createUser(newUser);
        Assert.assertEquals(201,createdUser.getStatusCodeValue());
        return createdUser;
    }

    //Needs editing
    public ResponseEntity<?> updateUser(Integer userId, User user){
        return null;
    }

    public ResponseEntity<?> deleteUser(Integer userId){
        int id=6;
        try{
            res = userController.deleteUser(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
