package udemy.learning.spring5beginnertoguru.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.learning.spring5beginnertoguru.model.Book;


public interface BookRepository extends CrudRepository<Book,Long> {
}
