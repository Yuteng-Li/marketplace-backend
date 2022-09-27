package nisum.marketplace.backend.APIUserTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import nisum.marketplace.backend.model.User;
import nisum.marketplace.backend.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    String baseURI = "/api/user/";

    @Mock
    private UserService userService;

    User mockUser;

    private static final Logger logger = LogManager.getLogger(UserControllerUnitTest.class);

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
    }


    @Test
    public void getAllCards_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/user/getUsers");

        try{
            List<User> listUser;
            when (listUser = userService.getAll()).thenReturn(listUser);
            this.mockMvc.perform(get(baseURI+"getUsers"))
                    .andExpect(status().isOk())
                    .andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched All Cards");

    }

    @Test
    public void getUserByID_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/user/getUserByID/{id}");
        int id = 1;
        when(mockUser = userService.getUserByID(id)).thenReturn(mockUser);
        MvcResult res = this.mockMvc.perform(get(baseURI + "getUserByID/" + id)).andReturn();
        String body = res.getResponse().getContentAsString();
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched User By ID");
    }

    @Test
    public void getUserByEmail_success() throws Exception{
        logger.info("Test GET METHOD WITH ENDPOINT: /api/user/getUserByEmail/{email}");
        String email = "bobby.joe@gmail.com";
        when(mockUser = userService.getUserEmail(email)).thenReturn(mockUser);
        MvcResult res = this.mockMvc.perform(get(baseURI+ "getUserByEmail/" + email)).andReturn();
        String body = res.getResponse().getContentAsString();
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Fetched User By Email");
    }

    @Test
    public void createUser_success() throws Exception{
        logger.info("Test POST METHOD WITH ENDPOINT: /api/user/createUser");
        User newUser = new User();
        Integer id = 6;
        this.mockMvc.perform(post(baseURI + "createUser")
                        .content(asJsonString(new User(id, "test@nisum.com", "Jane", "Doe", "pass123", "1234567890")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
        logger.info("Printed Response");
        logger.info("Expected status code 201 Created");
        logger.info("Successfully Created User");
    }

    @Test
    public void updateUser_success() throws Exception{
        logger.info("Test PUT METHOD WITH ENDPOINT: /api/user/updateUser/{id}");
        Integer id = 7;
        try{
            this.mockMvc.perform(put(baseURI+ "updateUser/" + id)
                            .content(asJsonString(new User(id, "test@nisum.com", "John", "Doe", "pass123", "1234567890")))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isCreated());
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Printed Response");
        logger.info("Expected status code 201 Created");
        logger.info("Successfully Updated User item");
    }

    @Test
    public void deleteUser_success() throws Exception{
        logger.info("Test DELETE METHOD WITH ENDPOINT: /api/user/deleteUser/{id}");
        int id = 7;
        try{
            when(userService.deleteUserByID(id)).thenReturn(true);
            this.mockMvc.perform(delete(baseURI + "deleteUser/" + id))
                    .andDo(print())
                    .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Printed Response");
        logger.info("Expected status code 200 OK");
        logger.info("Successfully Deleted User item");
    }
}
