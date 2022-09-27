package nisum.marketplace.backend.repository;

import nisum.marketplace.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

    List<User> findByemail(String email);

}