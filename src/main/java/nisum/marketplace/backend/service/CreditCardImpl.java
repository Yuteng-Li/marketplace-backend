package nisum.marketplace.backend.service;

import nisum.marketplace.backend.model.CreditCard;
import nisum.marketplace.backend.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardImpl implements CreditCardService{
    @Autowired
    CreditCardRepository cardRepository;


    @Override
    public List<CreditCard> getAll(){
        return cardRepository.findAll();
    }

    @Override
    public CreditCard getCreditCardByID(Integer creditCardID) throws Exception{
        if(cardRepository.findById(creditCardID).isEmpty()){
            System.out.println("Card with id:" + creditCardID +" could not be found.");
            throw new Exception();
        }
        else{
            return cardRepository.findById(creditCardID).get();
        }
    }

    @Override
    public CreditCard createCreditCard(CreditCard creditCard) throws Exception {
        if(cardRepository.existsById(creditCard.getCreditCardID())){
            System.out.println("Card could not be created. Card already exists.");
            throw new Exception();
        }
        else{
            return cardRepository.save(creditCard);
        }
    }

    @Override
    public CreditCard updateCreditCard(Integer creditCardID, CreditCard creditCard) throws Exception{
        if(!cardRepository.existsById(creditCard.getCreditCardID())){
            System.out.println("Card could not be updated. Card does not exists.");
            throw new Exception();
        }
        else{
            return cardRepository.save(creditCard);
        }
    }

    @Override
    public boolean deleteCreditCardByID(Integer creditCardID) throws Exception{
        if(!cardRepository.existsById(creditCardID)){
            System.out.println("Card could not be deleted. Card does not exists.");
            throw new Exception();
        }
        else{
            cardRepository.deleteById(creditCardID);
            return true;
        }
    }
}
