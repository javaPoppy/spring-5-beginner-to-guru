package udemy.learning.spring5beginnertoguru.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.learning.spring5beginnertoguru.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
