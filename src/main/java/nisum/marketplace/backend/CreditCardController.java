package nisum.marketplace.backend;


import nisum.marketplace.backend.model.CreditCard;
import nisum.marketplace.backend.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/creditCard")
public class CreditCardController {

    @Autowired
    CreditCardService service;

    @GetMapping("/")
    public ResponseEntity<List<CreditCard>> getAllCards () throws Exception {
        return new ResponseEntity<List<CreditCard>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getCard/{id}")
    public ResponseEntity<?> getCardByID (@PathVariable Integer id){
        try{
            return new ResponseEntity<CreditCard>(service.getCreditCardByID(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Card not found", HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/createCard")
    public ResponseEntity<?> createCard (@RequestBody CreditCard card){
        try {
            return new ResponseEntity<CreditCard>(service.createCreditCard(card),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Card could not be created", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/updateCard/{id}")
    public ResponseEntity<?> updateCard (@PathVariable Integer id, @RequestBody CreditCard card){
        try {
            return new ResponseEntity<CreditCard>(service.updateCreditCard(id,card),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Card could not be updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCard/{id}")
    public ResponseEntity<?> deleteCard (@PathVariable Integer id){
        try {
            return new ResponseEntity<Boolean>(service.deleteCreditCardByID(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Card could not be deleted", HttpStatus.NOT_FOUND);
        }
    }
}
