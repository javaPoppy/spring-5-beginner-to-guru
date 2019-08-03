package udemy.learning.spring5beginnertoguru.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import udemy.learning.spring5beginnertoguru.model.Author;
import udemy.learning.spring5beginnertoguru.model.Book;
import udemy.learning.spring5beginnertoguru.repositories.AuthorRepository;
import udemy.learning.spring5beginnertoguru.repositories.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDevData();
    }

    private void initDevData() {
        Author kalam = new Author();
        kalam.setFirstName("Abdul");
        kalam.setLastName("Kalam");


        Book agniSiragugal = new Book();
        agniSiragugal.setTitle("Agni Chiragugal");
        agniSiragugal.setIsbn("ROCKET");
        agniSiragugal.setPublisher("ISRO");

        kalam.getBooks().add(agniSiragugal);
        agniSiragugal.getAuthors().add(kalam);

        authorRepository.save(kalam);
        bookRepository.save(agniSiragugal);

        Author kannadhasan = new Author();
        kannadhasan.setFirstName("Kannadashan");
        kannadhasan.setLastName("Kavigar");

        Book artham = new Book();
        artham.setTitle("Arthamulla Hindhu Madham");
        artham.setIsbn("TAMIL");
        artham.setPublisher("Govt of Tamil Nadu");

        kannadhasan.getBooks().add(artham);
        artham.getAuthors().add(kannadhasan);

        authorRepository.save(kannadhasan);
        bookRepository.save(artham);
    }


}
