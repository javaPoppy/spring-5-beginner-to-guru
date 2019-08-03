package udemy.learning.spring5beginnertoguru.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.learning.spring5beginnertoguru.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
