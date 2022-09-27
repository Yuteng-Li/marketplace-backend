package nisum.marketplace.backend;




import nisum.marketplace.backend.model.User;
import nisum.marketplace.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllCards () throws Exception {
        return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getUserByID/{id}")
    public ResponseEntity<?> getUserByID (@PathVariable Integer id){
        try{
            return new ResponseEntity<User>(service.getUserByID(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail (@PathVariable String email){
        try{
            return new ResponseEntity<User>(service.getUserEmail(email),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser (@RequestBody User user){
        try {
            return new ResponseEntity<User>(service.createUser(user),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("User could not be created", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser (@PathVariable Integer id, @RequestBody User user){
        try {
            return new ResponseEntity<User>(service.updateUser(id,user),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("User could not be updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Integer id){
        try {
            return new ResponseEntity<Boolean>(service.deleteUserByID(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("User could not be deleted", HttpStatus.NOT_FOUND);
        }
    }
}
