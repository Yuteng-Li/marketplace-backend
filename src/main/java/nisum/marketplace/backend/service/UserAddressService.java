package nisum.marketplace.backend.service;

import java.util.List;

import nisum.marketplace.backend.exception.AddressAlreadyExistsException;
import nisum.marketplace.backend.exception.AddressNotFoundException;
import nisum.marketplace.backend.model.Address;

public interface UserAddressService {
	List<Address> getAll();
	Address getAddressById(Integer id) throws AddressNotFoundException;
	Boolean deleteAddressById(Integer id) throws AddressNotFoundException;
	Address updateAddress(Integer id, Address address) throws AddressNotFoundException;
	Address createAddress(Address address) throws AddressAlreadyExistsException;
}
	