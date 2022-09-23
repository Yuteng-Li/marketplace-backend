package nisum.marketplace.backend.service;

import nisum.marketplace.backend.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getUserByID(Integer userID) throws Exception;
    User getUserEmail(String email) throws Exception;
    User createUser(User newUser) throws Exception;
    User updateUser(Integer userID, User currentUser) throws Exception;
    boolean deleteUserByID(Integer userID)throws Exception;
}
