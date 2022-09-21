package nisum.marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import nisum.marketplace.backend.model.Address;


@Repository
public interface UserAddressRepository extends JpaRepository<Address, Integer>{

}
