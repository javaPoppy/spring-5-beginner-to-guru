package udemy.learning.spring5beginnertoguru.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.learning.spring5beginnertoguru.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
