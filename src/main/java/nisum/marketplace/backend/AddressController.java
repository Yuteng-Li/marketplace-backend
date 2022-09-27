package nisum.marketplace.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import nisum.marketplace.backend.model.Address;
import nisum.marketplace.backend.service.UserAddressService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/address")
public class AddressController {

	@Autowired
	UserAddressService service;
	
	@GetMapping("/getAllAddresses")
	public ResponseEntity<List<Address>> getAllAddresses(){
		return new ResponseEntity<List<Address>>((service.getAll()), HttpStatus.OK);
	}
	
	@GetMapping("/getAddress/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable Integer id){
		try {
			return new ResponseEntity<Address>(service.getAddressById(id), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<String>("Address " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Boolean>(service.deleteAddressById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Address  " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateAddress/{id}")
	public ResponseEntity<?> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
		try {
			return new ResponseEntity<Address>(service.updateAddress(id, address), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Address  " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/createAddress")
	public ResponseEntity<?> createAddress(@RequestBody Address address) {
		try {
			return new ResponseEntity<Address>(service.createAddress(address), HttpStatus.CREATED);
		}catch(Exception e) {

			return new ResponseEntity<String>("Address " + address.getAddress_id() + " not created", HttpStatus.BAD_REQUEST);

		}
	}
	
	
}
