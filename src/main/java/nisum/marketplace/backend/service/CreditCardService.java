package nisum.marketplace.backend.service;

import nisum.marketplace.backend.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    List <CreditCard> getAll();
    CreditCard getCreditCardByID(Integer creditCardID) throws Exception;
    CreditCard createCreditCard(CreditCard creditCard) throws Exception;
    CreditCard updateCreditCard(Integer creditCardID, CreditCard creditCard) throws Exception;
    boolean deleteCreditCardByID(Integer creditCardID)throws Exception;
}
