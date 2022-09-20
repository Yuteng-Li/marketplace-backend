package nisum.marketplace.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name ="creditcards")
@Entity
public class CreditCard {
    @Id
    Integer CreditCardID;
    Integer UserID;
    String BankName;
    String CardType;
    String CardNumber;
    String SecurityNumber;
    String Expiration;

    public Integer getCreditCardID() {
        return CreditCardID;
    }

    public void setCreditCardID(Integer creditCardID) {
        CreditCardID = creditCardID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String cardType) {
        CardType = cardType;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getSecurityNumber() {
        return SecurityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        SecurityNumber = securityNumber;
    }

    public String getExpiration() {
        return Expiration;
    }

    public void setExpiration(String expiration) {
        Expiration = expiration;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "CreditCardID=" + CreditCardID +
                ", UserID=" + UserID +
                ", BankName='" + BankName + '\'' +
                ", CardType='" + CardType + '\'' +
                ", CardNumber='" + CardNumber + '\'' +
                ", SecurityNumber='" + SecurityNumber + '\'' +
                ", Expiration='" + Expiration + '\'' +
                '}';
    }
}
