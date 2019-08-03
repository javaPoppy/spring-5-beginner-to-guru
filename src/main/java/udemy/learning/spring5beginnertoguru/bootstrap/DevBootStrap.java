package udemy.learning.spring5beginnertoguru.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import udemy.learning.spring5beginnertoguru.model.Address;
import udemy.learning.spring5beginnertoguru.model.Author;
import udemy.learning.spring5beginnertoguru.model.Book;
import udemy.learning.spring5beginnertoguru.model.Publisher;
import udemy.learning.spring5beginnertoguru.repositories.AddressRepository;
import udemy.learning.spring5beginnertoguru.repositories.AuthorRepository;
import udemy.learning.spring5beginnertoguru.repositories.BookRepository;
import udemy.learning.spring5beginnertoguru.repositories.PublisherRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private AddressRepository addressRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
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

        Address adr1 = new Address(1,"Sannathai Theru","Tiruchi","India","639587");
        Address adr2 = new Address(2,"Second Theru","Tiruchi","India","639587");
        Address adr3 = new Address(3,"Third Theru","Tiruchi","India","639587");
        Address adr4 = new Address(4,"Fourth Theru","Tiruchi","India","639587");
        Address adr5 = new Address(5,"Fifth Theru","Tiruchi","India","639587");

        addressRepository.save(adr1);
        addressRepository.save(adr2);
        addressRepository.save(adr3);
        addressRepository.save(adr4);
        addressRepository.save(adr5);


        Publisher publisherForKalam = new Publisher();
        publisherForKalam.setPublisherName("ISRO");
        List<Address> kalamPubliserAddress = new ArrayList<>();
        kalamPubliserAddress.add(adr1);
        kalamPubliserAddress.add(adr2);
        kalamPubliserAddress.add(adr5);
        publisherForKalam.setPublisherAddressList(kalamPubliserAddress);
        agniSiragugal.setPublisher(publisherForKalam);


        Publisher publisherForKannadhasan = new Publisher();
        publisherForKannadhasan.setPublisherName("Govt Of TamilNadu");
        List<Address> kannadhasanPubliserAddress = new ArrayList<>();
        kannadhasanPubliserAddress.add(adr3);
        kannadhasanPubliserAddress.add(adr4);
        kannadhasanPubliserAddress.add(adr5);

        publisherForKannadhasan.setPublisherAddressList(kannadhasanPubliserAddress);

        publisherRepository.save(publisherForKalam);
        publisherRepository.save(publisherForKannadhasan);

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

        authorRepository.save(kannadhasan);
        bookRepository.save(artham);
    }
}
