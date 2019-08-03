package udemy.learning.spring5beginnertoguru.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import udemy.learning.spring5beginnertoguru.model.Address;
import udemy.learning.spring5beginnertoguru.model.Author;
import udemy.learning.spring5beginnertoguru.model.Book;
import udemy.learning.spring5beginnertoguru.model.Publisher;
import udemy.learning.spring5beginnertoguru.repositories.AuthorRepository;
import udemy.learning.spring5beginnertoguru.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

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

        Address adr1 = new Address(1,"Sannathai Theru","Tiruchi","India","639587");
        Address adr2 = new Address(2,"Second Theru","Tiruchi","India","639587");

        Book agniSiragugal = new Book();
        agniSiragugal.setTitle("Agni Chiragugal");
        agniSiragugal.setIsbn("ROCKET");


        Publisher publisherForKalam = new Publisher();
        publisherForKalam.setPublisherName("ISRO");
        List<Address> kalamPubliserAddress = new ArrayList<>();
        kalamPubliserAddress.add(adr1);
        kalamPubliserAddress.add(adr2);
        publisherForKalam.setPublisherAddressList(new ArrayList(kalamPubliserAddress));

        publisherForKalam.getPublisherAddressList().add(adr1);
        publisherForKalam.getPublisherAddressList().add(adr2);


        agniSiragugal.setPublisher(publisherForKalam);
        agniSiragugal.getPublisher().setPublisherName("Govt Of TamilNadu");

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

        kannadhasan.getBooks().add(artham);
        artham.getAuthors().add(kannadhasan);

        Publisher publisherForKannadhasan = new Publisher();
        publisherForKannadhasan.setPublisherName("Govt Of TamilNadu");
        publisherForKannadhasan.getPublisherAddressList().add(adr1);
        publisherForKannadhasan.getPublisherAddressList().add(adr2);


        artham.setPublisher(publisherForKannadhasan);

        Address adr3 = new Address(3,"Third Theru","Tiruchi","India","639587");
        Address adr4 = new Address(4,"Fourth Theru","Tiruchi","India","639587");
        Address adr5 = new Address(5,"Fifth Theru","Tiruchi","India","639587");

        artham.getPublisher().getPublisherAddressList().add(adr3);
        artham.getPublisher().getPublisherAddressList().add(adr4);
        artham.getPublisher().getPublisherAddressList().add(adr5);

        authorRepository.save(kannadhasan);
        bookRepository.save(artham);
    }


}
