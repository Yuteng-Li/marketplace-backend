package nisum.marketplace.backend.model;
import javax.persistence.*;

@Table(name = "users")
@Entity
public class User {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer user_id;

    private String email;

    private String first_name;

    private String last_name;

    private String user_password;

    private String phone;
<<<<<<< HEAD
    //public User(){}

    public User(Integer user_id, String email, String first_name, String last_name, String user_password, String phone) {
=======
    
    public User(){}
    
	public User(Integer user_id, String email, String first_name, String last_name, String user_password, String phone) {
>>>>>>> 99ed0f1e8866ac6c3049e5b9aa141d8b27d92c27
        super();
        this.user_id = user_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_password = user_password;
        this.phone = phone;
    }
   

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
