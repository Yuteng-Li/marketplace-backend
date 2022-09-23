package nisum.marketplace.backend.model;

import javax.persistence.*;

@Table(name = "credit_cards")
@Entity
public class CreditCard {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "credit_card_id")
    private Integer creditCardID;

    @Column(name = "user_id")
    private Integer userID;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "security_code")
    private String securityNumber;

    @Column(name = "expiration_year")
    private String expirationYear;

    @Column(name = "expiration_month")
    private String expirationMonth;

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

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardID=" + creditCardID +
                ", userID=" + userID +
                ", cardholderName='" + cardholderName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", securityNumber='" + securityNumber + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                '}';
    }
}
