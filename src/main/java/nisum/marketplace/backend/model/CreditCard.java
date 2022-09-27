package nisum.marketplace.backend.model;

import javax.persistence.*;

@Table(name = "credit_cards")
@Entity
public class CreditCard {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "credit_card_id")
    private Integer credit_card_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "cardholder_name")
    private String cardholder_name;

    @Column(name = "last_four_card_number")
    private String last_four_card_number;

    @Column(name = "expiration_year")
    private String expiration_year;

    @Column(name = "expiration_month")
    private String expiration_month;

    public Integer getCredit_card_id() {
        return credit_card_id;
    }

    public void setCredit_card_id(Integer credit_card_id) {
        this.credit_card_id = credit_card_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCardholder_name() {
        return cardholder_name;
    }

    public void setCardholder_name(String cardholder_name) {
        this.cardholder_name = cardholder_name;
    }

    public String getLast_four_card_number() {
        return last_four_card_number;
    }

    public void setLast_four_card_number(String last_four_card_number) {
        this.last_four_card_number = last_four_card_number;
    }

    public String getExpiration_year() {
        return expiration_year;
    }

    public void setExpiration_year(String expiration_year) {
        this.expiration_year = expiration_year;
    }

    public String getExpiration_month() {
        return expiration_month;
    }

    public void setExpiration_month(String expiration_month) {
        this.expiration_month = expiration_month;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "credit_card_id=" + credit_card_id +
                ", user_id=" + user_id +
                ", cardholder_name='" + cardholder_name + '\'' +
                ", last_four_card_number='" + last_four_card_number + '\'' +
                ", expiration_year='" + expiration_year + '\'' +
                ", expiration_month='" + expiration_month + '\'' +
                '}';
    }
}
