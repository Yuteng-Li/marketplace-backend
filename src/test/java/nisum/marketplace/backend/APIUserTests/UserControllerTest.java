package nisum.marketplace.backend.APIUserTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.BackendApplication;
import nisum.marketplace.backend.UserController;
import nisum.marketplace.backend.model.User;
import nisum.marketplace.backend.repository.UserRepo;
import nisum.marketplace.backend.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ContextConfiguration(classes = BackendApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepo userRepository;

    @InjectMocks
    private UserController userController = new UserController();

    @Mock
    private UserService userService;

    private static final Logger logger = LogManager.getLogger(UserControllerTest.class);

    //When updating the cart via the API, the webpage should respond with a 200 Status code if the cart exists and a JSON response.
    //Or it responds with an error code(404)) if the cart does not exist

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    public static void setUp(){
        logger.info("API TEST LOG BEGIN: UserControllerTest");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        logger.info("API TEST LOG COMPLETED: UserControllerTest");
    }


    @Test
    public void getAllCards_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/user/getUsers");

        this.mockMvc.perform(get("/api/user/getUsers")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched All Cards");

    }

    @Test
    public void getUserByID_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/user/getUserByID/{id}");
        this.mockMvc.perform(get("/api/user/getUserByID/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched User By ID");
    }

    @Test
    public void getUserByEmail_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/user/getUserByEmail/{email}");
        this.mockMvc.perform(get("/api/user/getUserByEmail/{email}", "test@nisum.com")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched User By Email");
    }

    @Test
    public void createUser_success() throws Exception{
        logger.info("Test POST METHOD WITH ENDPOINT: /api/user/createUser");

        User user = new User();
        user.setUser_id(1);
        user.setEmail("test@nisum.com");
        user.setFirst_name("John");
        user.setLast_name("Doe");
        user.setUser_password("pass123");
        user.setPhone("1234567890");

        this.mockMvc.perform(post("/api/user/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new User()))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Created Cart");
    }

    @Test
    public void updateUser_success() throws Exception{
        logger.info("Test PUT METHOD WITH ENDPOINT: /api/user/updateUser/{id}");

        this.mockMvc.perform(put("/api/user/updateUser/{id}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new User(6, "test@nisum.com", "Jane", "Doe", "pass123", "1234567890")))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Updated Cart item");
    }

    @Test
    public void deleteUser_success() throws Exception{
        logger.info("Test DELETE METHOD WITH ENDPOINT: /api/user/deleteUser/{id}");
        this.mockMvc.perform(delete("/api/user/deleteUser/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk());
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Deleted Cart item");
    }
}
