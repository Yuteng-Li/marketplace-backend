package nisum.marketplace.backend.model;

import javax.persistence.*;

@Table(name = "creditcards")
@Entity
public class CreditCard {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer creditCardID;
    private Integer userID;
    private String bankName;
    private String cardholderName;
    private String cardType;
    private String cardNumber;
    private String securityNumber;
    private String expiration;

    public Integer getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(Integer creditCardID) {
        this.creditCardID = creditCardID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardID=" + creditCardID +
                ", userID=" + userID +
                ", bankName='" + bankName + '\'' +
                ", cardholderName='" + cardholderName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", securityNumber='" + securityNumber + '\'' +
                ", expiration='" + expiration + '\'' +
                '}';
    }
}
