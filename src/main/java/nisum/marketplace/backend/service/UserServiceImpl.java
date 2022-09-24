package nisum.marketplace.backend.service;


import nisum.marketplace.backend.model.User;
import nisum.marketplace.backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(Integer userID) throws Exception {
        if (userRepository.findById(userID).isEmpty()) {
            System.out.println("Card with id:" + userID + " could not be found.");
            throw new Exception();
        } else {
            return userRepository.findById(userID).get();
        }

    }

    @Override
    public User getUserEmail(String email) throws Exception{
        if (userRepository.findByemail(email).isEmpty()) {
            System.out.println("Card with id:" + email + " could not be found.");
            throw new Exception();
        } else {
            return userRepository.findByemail(email).get(0);
        }
    }

    @Override
    public User createUser(User newUser) throws Exception {
        if (newUser.getUser_id() != null) {
            if (userRepository.existsById(newUser.getUser_id())) {
                System.out.println("Card could not be created. Card already exists.");
                throw new Exception();
            }
        }
        return userRepository.save(newUser);
    }

    @Override
    public   User updateUser(Integer userID, User currentUser) throws Exception {
        if (!userRepository.existsById(currentUser.getUser_id())) {
            System.out.println("Card could not be updated. Card does not exists.");
            throw new Exception();
        } else {
            return userRepository.save(currentUser);
        }
    }

    @Override
    public boolean deleteUserByID(Integer userID) throws Exception {
        if (!userRepository.existsById(userID)) {
            System.out.println("Card could not be deleted. Card does not exists.");
            throw new Exception();
        } else {
            userRepository.deleteById(userID);
            return true;
        }
    }
}
